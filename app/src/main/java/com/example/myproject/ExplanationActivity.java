package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplanationActivity extends AppCompatActivity {
    private Button btnPredict;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk);
        btnPredict = findViewById(R.id.btn_predict);
        Button buttonShowRiskExplanation = findViewById(R.id.btn_predict);
        buttonShowRiskExplanation.setOnClickListener(v -> {
            Intent intent = new Intent(ExplanationActivity.this, ModelActivity.class);
            startActivity(intent);
        });


        // Additional setup can be done here if needed
    }
}
