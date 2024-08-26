package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class PregnancyTrackerActivity extends AppCompatActivity {
    private static final Map<String, String> symptomPrecautions = new HashMap<>();

    static {
        symptomPrecautions.put("nausea", "Eat small, frequent meals. Stay hydrated. Avoid triggers like strong smells.");
        symptomPrecautions.put("headache", "Rest, stay hydrated, and use over-the-counter pain relievers if approved by your doctor.");
        symptomPrecautions.put("back pain", "Practice good posture, use a pregnancy pillow, and consider prenatal massage.");
        symptomPrecautions.put("fatigue", "Get plenty of rest, eat a balanced diet, and try gentle exercise like walking.");
        symptomPrecautions.put("swelling", "Elevate your feet, stay hydrated, and avoid standing for long periods.");
    }

    private EditText symptomEditText;
    private TextView precautionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_tracker);

        symptomEditText = findViewById(R.id.symptomEditText);
        precautionTextView = findViewById(R.id.precautionTextView);

        findViewById(R.id.checkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String symptom = symptomEditText.getText().toString().toLowerCase();
                if (symptomPrecautions.containsKey(symptom)) {
                    precautionTextView.setText("Precaution for " + symptom + ":\n" + symptomPrecautions.get(symptom));
                } else {
                    precautionTextView.setText("Sorry, we don't have information on precautions for that symptom. Please consult your healthcare provider.");
                }
            }
        });
    }
}