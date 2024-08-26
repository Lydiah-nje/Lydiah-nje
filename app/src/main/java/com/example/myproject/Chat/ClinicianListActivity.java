package com.example.myproject.Chat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClinicianListActivity extends AppCompatActivity {

    private static final String TAG = "ClinicianListActivity";

    private ListView listViewClinicians;
    private List<String> clinicianIds;
    private List<String> clinicianNames;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinician_list);

        listViewClinicians = findViewById(R.id.listViewClinicians);
        clinicianIds = new ArrayList<>();
        clinicianNames = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Clinicians");

        loadClinicians();

        listViewClinicians.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedClinicianId = clinicianIds.get(position);
                String selectedClinicianName = clinicianNames.get(position);
                Intent intent = new Intent(ClinicianListActivity.this, ChatActivity.class);
                intent.putExtra("CLINICIAN_ID", selectedClinicianId);
                intent.putExtra("CLINICIAN_NAME", selectedClinicianName);
                startActivity(intent);
            }
        });
    }

    private void loadClinicians() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clinicianIds.clear();
                clinicianNames.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String clinicianId = snapshot.getKey();
                    String clinicianName = snapshot.child("name").getValue(String.class);
                    clinicianIds.add(clinicianId);
                    clinicianNames.add(clinicianName);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(ClinicianListActivity.this,
                        android.R.layout.simple_list_item_1, clinicianNames);
                listViewClinicians.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "Failed to load clinicians: " + databaseError.getMessage());
                Toast.makeText(ClinicianListActivity.this, "Failed to load clinicians.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
