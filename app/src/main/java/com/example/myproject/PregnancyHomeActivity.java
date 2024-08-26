package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PregnancyHomeActivity extends AppCompatActivity {

    private TextView babySize, nameTextView;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_home);

        // Initialize Firebase components
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users").child(firebaseAuth.getCurrentUser().getUid());

        // Find the views
        babySize = findViewById(R.id.baby_size_textview);
        nameTextView = findViewById(R.id.name_textview);

        // Retrieve user data from Firebase
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user != null) {
                    nameTextView.setText(user.getName());
                    updateBabySize(user.getDueDate());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
            }
        });
    }

    private void updateBabySize(String dueDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date dueDateParsed = dateFormat.parse(dueDate);
            if (dueDateParsed != null) {
                long dueDateInMillis = dueDateParsed.getTime();
                long currentDateInMillis = Calendar.getInstance().getTimeInMillis();
                long timeDifference = currentDateInMillis - dueDateInMillis;
                long weeksPregnant = timeDifference / (1000 * 60 * 60 * 24 * 7);

                // Determine the baby size based on the number of weeks pregnant
                String babySizeText = getBabySize(weeksPregnant);
                babySize.setText(babySizeText);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String getBabySize(long weeksPregnant) {
        if (weeksPregnant < 12) {
            return "The size of the baby is about the size of a lime.";
        } else if (weeksPregnant < 16) {
            return "The size of the baby is about the size of an avocado.";
        } else if (weeksPregnant < 20) {
            return "The size of the baby is about the size of a banana.";
        } else if (weeksPregnant < 24) {
            return "The size of the baby is about the size of a papaya.";
        } else if (weeksPregnant < 28) {
            return "The size of the baby is about the size of an eggplant.";
        } else if (weeksPregnant < 32) {
            return "The size of the baby is about the size of a pineapple.";
        } else if (weeksPregnant < 36) {
            return "The size of the baby is about the size of a honeydew melon.";
        } else {
            return "The size of the baby is about the size of a pumpkin.";
        }
    }

    private void PatientSelectSlotActivity () {
        // Code to start the Book Appointment activity
        Intent intent = new Intent(this, PatientAppointmentActivity.class);
        startActivity(intent);
    }

    public static class User {
        private String name;
        private String dueDate;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public String getName() {
            return name;
        }

        public String getDueDate() {
            return dueDate;
        }

        // Getters and setters
        public void setName(String name) {
            this.name = name;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }
    }
}
