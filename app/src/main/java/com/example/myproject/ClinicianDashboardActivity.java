package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.Chat.ChatActivity;
import com.example.myproject.Chat.ClinicianChatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ClinicianDashboardActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView tvWelcome;
    private Button btnLogout, btnappointment,btnvieslots, btnChat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinician_dashboard);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize views
        tvWelcome = findViewById(R.id.tv_welcome);
        btnLogout = findViewById(R.id.btn_logout);
        btnappointment = findViewById(R.id.btnBookAppointment);
        btnvieslots= findViewById(R.id.btnviewslots);
        btnChat = findViewById(R.id.btn_chat);



        // Set the welcome message with the clinician's email
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            tvWelcome.setText("Welcome, " + user.getEmail() + "!");
        } else {
            // If no user is logged in, redirect to the login activity
            startActivity(new Intent(ClinicianDashboardActivity.this, ClinicianLoginActivity.class));
            finish();
        }

        // Set up logout button click listener
        btnLogout.setOnClickListener(v -> logout());
        btnappointment.setOnClickListener(v -> {
            // Navigate to registration screen
            Intent intent = new Intent(ClinicianDashboardActivity.this, DoctorAppointmentActivity.class);
            startActivity(intent);
        });
        btnvieslots.setOnClickListener(v -> {
            // Navigate to registration screen
            Intent intent = new Intent(ClinicianDashboardActivity.this, ViewAppointmentActivity.class);
            startActivity(intent);
        });
        btnChat.setOnClickListener(v -> {
            // Navigate to registration screen
            Intent intent = new Intent(ClinicianDashboardActivity.this, ClinicianChatActivity.class);
            startActivity(intent);
        });
    }

    private void logout() {
        mAuth.signOut();
        Toast.makeText(ClinicianDashboardActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ClinicianDashboardActivity.this, ClinicianLoginActivity.class));
        finish();
    }
}
