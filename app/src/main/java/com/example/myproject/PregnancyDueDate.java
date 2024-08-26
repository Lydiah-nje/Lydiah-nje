package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PregnancyDueDate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText dateInput;
    private Button Button;
    private TextView resultTextView;
    private Spinner calculationMethodSpinner;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String hintText; // To store the current hint for the date input

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregnancyduedate);

        dateInput = findViewById(R.id.dateInput);
        resultTextView = findViewById(R.id.resultTextView);
        calculationMethodSpinner = findViewById(R.id.calculationMethodSpinner);
        Button = findViewById(R.id.button);

        // Create an ArrayAdapter for the spinner with calculation methods
        String[] calculationMethods = {"Last Period Date", "Conception Date", "Ultrasound Date"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, calculationMethods);
        calculationMethodSpinner.setAdapter(adapter);

        calculationMethodSpinner.setOnItemSelectedListener(this);

        hintText = dateInput.getHint().toString(); // Get initial hint

        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Button.setOnClickListener(v -> startActivity(new Intent(PregnancyDueDate.this, PregnancyActivity.class)));

                calculateDueDate();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedMethod = (String) parent.getItemAtPosition(position);

        // Update hint based on selected method
        switch (selectedMethod) {
            case "Last Period Date":
                hintText = "Enter First Day of Last Period (DD/MM/YYYY)";
                break;
            case "Conception Date":
                hintText = "Enter Date of Conception (DD/MM/YYYY)";
                break;
            case "Ultrasound Date":
                hintText = "Enter Ultrasound Date (DD/MM/YYYY)";
                break;
        }

        dateInput.setHint(hintText); // Set the new hint
        resultTextView.setText(""); // Clear previous result
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    private void calculateDueDate() {
        String selectedMethod = (String) calculationMethodSpinner.getSelectedItem();
        Date selectedDate = null;

        try {
            selectedDate = dateFormat.parse(dateInput.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date dueDate = null;
        String resultText = "";

        if (selectedMethod.equals("Last Period Date") && selectedDate != null) {
            dueDate = calculateDueDateFromLastPeriod(selectedDate);
            resultText = "Due date based on Last Period Date: ";
        } else if (selectedMethod.equals("Conception Date") && selectedDate != null) {
            dueDate = calculateDueDateFromConception(selectedDate);
            resultText = "Due date based on Conception Date: ";
        } else if (selectedMethod.equals("Ultrasound Date") && selectedDate != null) {
            dueDate = calculateDueDateFromUltrasound(selectedDate);
            resultText = "Due date based on Ultrasound Date: ";
        } else {
            resultText = "Please enter a valid date.";
        }

        if (dueDate != null) {
            resultText += dateFormat.format(dueDate);
        }

        resultTextView.setText(resultText);
    }

    private Date calculateDueDateFromLastPeriod(Date lastPeriodDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastPeriodDate);
        calendar.add(Calendar.DAY_OF_YEAR, 280);
        return calendar.getTime();
    }

    private Date calculateDueDateFromConception(Date conceptionDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(conceptionDate);
        calendar.add(Calendar.DAY_OF_YEAR, 266);
        return calendar.getTime();
    }

    private Date calculateDueDateFromUltrasound(Date ultrasoundDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ultrasoundDate);
        calendar.add(Calendar.DAY_OF_YEAR, 280);
        return calendar.getTime();
    }
}