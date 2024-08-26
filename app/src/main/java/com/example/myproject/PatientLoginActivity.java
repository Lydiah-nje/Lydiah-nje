package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class PatientLoginActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginButton, registerButton, btnLogin;
    private ImageView passwordVisibilityToggle;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private boolean isPasswordVisible = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientlogin);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        btnLogin = findViewById(R.id.btn_login);
        passwordVisibilityToggle = findViewById(R.id.passwordVisibilityToggle);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                // Display toast for empty fields
                Toast.makeText(PatientLoginActivity.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Check if the user is registered in the database
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            if (firebaseUser != null) {
                                String userId = firebaseUser.getUid();
                                databaseReference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            // User is registered, proceed to the dashboard
                                            startActivity(new Intent(PatientLoginActivity.this, PregnancyActivity.class));
                                            finish();
                                        } else {
                                            // User is not registered in the database
                                            firebaseAuth.signOut();
                                            Toast.makeText(PatientLoginActivity.this, "You are not registered as a patient.", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Handle any errors
                                        Toast.makeText(PatientLoginActivity.this, "Database error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(PatientLoginActivity.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(PatientLoginActivity.this, PatientRegistrationActivity.class));
        });

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(PatientLoginActivity.this, ClinicianLoginActivity.class);
            startActivity(intent);
        });

        passwordVisibilityToggle.setOnClickListener(v -> {
            isPasswordVisible = !isPasswordVisible;
            if (isPasswordVisible) {
                passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                passwordVisibilityToggle.setImageResource(R.drawable.my_visibility);
            } else {
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                passwordVisibilityToggle.setImageResource(R.drawable.my_visibility_off);
            }
            passwordEditText.setSelection(passwordEditText.length());
        });
    }
}
