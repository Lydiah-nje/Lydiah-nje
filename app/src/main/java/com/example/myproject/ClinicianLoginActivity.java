package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClinicianLoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private ImageView ivPasswordVisibility;
    private boolean isPasswordVisible = false;

    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinicianlogin);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference("clinicians");

        // Initialize views
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
        ivPasswordVisibility = findViewById(R.id.iv_password_visibility);

        // Set up password visibility toggle
        ivPasswordVisibility.setOnClickListener(v -> {
            isPasswordVisible = !isPasswordVisible;
            updatePasswordVisibility();
        });

        // Set up login button click listener
        btnLogin.setOnClickListener(v -> {
            if (validateInput()) {
                loginClinician();
            }
        });

        // Set up register text view click listener
        tvRegister.setOnClickListener(v -> {
            // Navigate to registration screen
            Intent intent = new Intent(ClinicianLoginActivity.this, ClinicianRegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void updatePasswordVisibility() {
        if (isPasswordVisible) {
            etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            ivPasswordVisibility.setImageResource(R.drawable.my_visibility);
        } else {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivPasswordVisibility.setImageResource(R.drawable.my_visibility_off);
        }
    }

    private boolean validateInput() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return false;
        }

        return true;
    }

    private void loginClinician() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login successful, check if user is a clinician
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            verifyClinician(user.getUid());
                        }
                    } else {
                        // If login fails, display a message to the user.
                        Toast.makeText(ClinicianLoginActivity.this, "Authentication failed. Please check your email and password.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void verifyClinician(String uid) {
        dbRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // User is a registered clinician
                    Intent intent = new Intent(ClinicianLoginActivity.this, ClinicianDashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // User is not a registered clinician
                    mAuth.signOut();
                    Toast.makeText(ClinicianLoginActivity.this, "You are not registered as a clinician.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors
                Toast.makeText(ClinicianLoginActivity.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
