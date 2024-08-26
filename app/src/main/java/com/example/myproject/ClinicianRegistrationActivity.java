package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ClinicianRegistrationActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword, etConfirmPassword;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale;
    private Button btnRegister;
    private ImageView ivPasswordVisibility;
    private boolean isPasswordVisible = false;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinicianregistration);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("clinicians");

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        rgGender = findViewById(R.id.rg_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        btnRegister = findViewById(R.id.btn_register);
        ivPasswordVisibility = findViewById(R.id.iv_password_visibility);

        ivPasswordVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                int selectedGenderId = rgGender.getCheckedRadioButtonId();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || selectedGenderId == -1) {
                    Toast.makeText(ClinicianRegistrationActivity.this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(ClinicianRegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(ClinicianRegistrationActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(name, email, password, selectedGenderId);
                }
            }
        });
    }

    private void registerUser(String name, String email, String password, int selectedGenderId) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registration successful, save user data to the Realtime Database
                            String userId = mAuth.getCurrentUser().getUid();
                            Map<String, Object> clinicianData = new HashMap<>();
                            clinicianData.put("name", name);
                            clinicianData.put("email", email);
                            clinicianData.put("gender", selectedGenderId == R.id.rb_male ? "Male" : "Female");
                            mDatabase.child(userId).setValue(clinicianData)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                // Registration and data storage successful, navigate to the clinician login page
                                                startActivity(new Intent(ClinicianRegistrationActivity.this, ClinicianLoginActivity.class));
                                                finish();
                                            } else {
                                                Toast.makeText(ClinicianRegistrationActivity.this, "Failed to save user data", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        } else {
                            Toast.makeText(ClinicianRegistrationActivity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivPasswordVisibility.setImageResource(R.drawable.my_visibility_off);
        } else {
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivPasswordVisibility.setImageResource(R.drawable.my_visibility);
        }
        isPasswordVisible = !isPasswordVisible;
    }
}