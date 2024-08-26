package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Main extends AppCompatActivity {
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(Main.this, PatientRegistrationActivity.class));
        });
    }
}