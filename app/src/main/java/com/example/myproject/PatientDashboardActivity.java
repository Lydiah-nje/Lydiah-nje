package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PatientDashboardActivity extends AppCompatActivity {
    private TextView nameTextView, ageTextView, dueDateTextView, emailTextView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientdashboard);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("user").child(currentUser.getUid());

        nameTextView = findViewById(R.id.nameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        dueDateTextView = findViewById(R.id.dueDateTextView);
        emailTextView = findViewById(R.id.emailTextView);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String name = dataSnapshot.child("name").getValue(String.class);
                    int age = dataSnapshot.child("age").getValue(Integer.class);
                    String dueDate = dataSnapshot.child("dueDate").getValue(String.class);
                    String email = dataSnapshot.child("email").getValue(String.class);

                    nameTextView.setText("Name: " + name);
                    ageTextView.setText("Age: " + age);
                    dueDateTextView.setText("Due Date: " + dueDate);
                    emailTextView.setText("Email: " + email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patientdashboardmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            firebaseAuth.signOut();
            startActivity(new Intent(PatientDashboardActivity.this, PatientLoginActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}