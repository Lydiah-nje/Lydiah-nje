package com.example.myproject;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientRegistrationActivity extends AppCompatActivity {
    private EditText nameEditText, dueDateEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private ImageButton showPasswordButton, showConfirmPasswordButton;
    private Button registerButton, loginButton, btnRegister;
    private Spinner ageSpinner;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private int mYear, mMonth, mDay;
    private String selectedAge;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientregistration);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        nameEditText = findViewById(R.id.nameEditText);
        ageSpinner = findViewById(R.id.ageSpinner);
        dueDateEditText = findViewById(R.id.dueDateEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        showPasswordButton = findViewById(R.id.showPasswordButton);
        showConfirmPasswordButton = findViewById(R.id.showConfirmPasswordButton);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        btnRegister = findViewById(R.id.btn_register);

        // Set the initial password visibility
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        confirmPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        showPasswordButton.setOnClickListener(v -> togglePasswordVisibility(passwordEditText, showPasswordButton));
        showConfirmPasswordButton.setOnClickListener(v -> togglePasswordVisibility(confirmPasswordEditText, showConfirmPasswordButton));

        registerButton.setOnClickListener(v -> startActivity(new Intent(PatientRegistrationActivity.this, PatientLoginActivity.class)));
        loginButton.setOnClickListener(v -> startActivity(new Intent(PatientRegistrationActivity.this, PatientLoginActivity.class)));
        btnRegister.setOnClickListener(v -> startActivity(new Intent(PatientRegistrationActivity.this, ClinicianRegistrationActivity.class)));

        // Set the due date EditText to open a DatePickerDialog
        dueDateEditText.setOnClickListener(v -> showDatePickerDialog());
        registerButton.setOnClickListener(v -> registerUser());

        // Set the due date to be 9 months from today
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 9);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        dueDateEditText.setText(dateFormat.format(calendar.getTime()));

        // Populate the age spinner
        Integer[] ages = new Integer[37];
        for (int i = 0; i < 37; i++) {
            ages[i] = i + 14;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, ages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAge = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedAge = null;
            }
        });
    }

    private void showDatePickerDialog() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year, monthOfYear, dayOfMonth);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                    dueDateEditText.setText(dateFormat.format(selectedDate.getTime()));
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void registerUser() {
        // Get the values from the EditText fields
        String name = nameEditText.getText().toString().trim();
        String dueDate = dueDateEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        // Validate the input fields
        if (name.isEmpty() || selectedAge == null || dueDate.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            // Display a toast message if any field is empty
            Toast.makeText(PatientRegistrationActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
        } else if (!isValidPassword(password)) {
            // Display a toast message if the password is invalid
            Toast.makeText(PatientRegistrationActivity.this, "Password must be at least 6 characters long and contain at least one uppercase letter, one lowercase letter, and one number", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmPassword)) {
            // Display a toast message if the passwords don't match
            Toast.makeText(PatientRegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else if (!isValidDueDate(dueDate)) {
            // Display a toast message if the due date is invalid
            Toast.makeText(PatientRegistrationActivity.this, "Please enter a valid due date (MM/dd/yyyy)", Toast.LENGTH_SHORT).show();
        } else if (!isValidAge(selectedAge)) {
            // Display a toast message if the age is invalid
            Toast.makeText(PatientRegistrationActivity.this, "Age must be between 14 and 50 years", Toast.LENGTH_SHORT).show();
        } else {
            // Registration logic
            // Create a user account in Firebase Authentication
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        // Store user data in the Firebase Realtime Database
                        String userId = firebaseAuth.getCurrentUser().getUid();
                        User user = new User(name, selectedAge, dueDate, email);
                        databaseReference.child(userId).setValue(user)
                                .addOnSuccessListener(aVoid -> {
                                    // Display a toast message for successful registration
                                    Toast.makeText(PatientRegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                    clearInputFields();
                                    // Start the login activity
                                    startActivity(new Intent(PatientRegistrationActivity.this, PatientLoginActivity.class));
                                    finish();
                                })
                                .addOnFailureListener(e -> {
                                    // Display a toast message for failed database operation
                                    Toast.makeText(PatientRegistrationActivity.this, "Failed to store user data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                });
                    })
                    .addOnFailureListener(e -> {
                        // Display a toast message for failed authentication
                        Toast.makeText(PatientRegistrationActivity.this, "Failed to create user account: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });

        }
    }

    private void clearInputFields() {
    }

    private boolean isValidAge(String age) {
        try {
            int ageInt = Integer.parseInt(age);
            return ageInt >= 14 && ageInt <= 50;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void togglePasswordVisibility(EditText editText, ImageButton button) {
        if (editText.getTransformationMethod() instanceof PasswordTransformationMethod) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            button.setImageResource(R.drawable.my_visibility_off);
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            button.setImageResource(R.drawable.my_visibility);
        }
    }

    private boolean isValidPassword(String password) {
        // Password must be at least 6 characters long and contain at least one uppercase letter, one lowercase letter, and one number
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean isValidDueDate(String dueDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dueDate);
            return date != null && date.after(new Date());
        } catch (ParseException e) {
            return false;
        }
    }
}
