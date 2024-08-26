package com.example.myproject;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        // Find the views by their IDs
        TextView dosAndDontsCard = findViewById(R.id.dos_and_donts_card);
        TextView dueDateCalcCard = findViewById(R.id.due_date_calc_card);
        TextView enterSymptomsCard = findViewById(R.id.enter_symptoms_card);
        TextView bookAppointmentCard = findViewById(R.id.book_appointment_card);

        // Set click listeners for the card views
        dosAndDontsCard.setOnClickListener(v -> openDosAndDontsActivity());
        dueDateCalcCard.setOnClickListener(v -> openDueDateCalculatorActivity());
        enterSymptomsCard.setOnClickListener(v -> openEnterSymptomsActivity());
        bookAppointmentCard.setOnClickListener(v -> openBookAppointmentActivity());
    }

    private void openDosAndDontsActivity() {
        // Code to start the Dos and Don'ts activity
        Intent intent = new Intent(MainPage.this, DosandDonts.class);
        startActivity(intent);
    }

    private void openDueDateCalculatorActivity() {
        // Code to start the Due Date Calculator activity
        Intent intent = new Intent(MainPage.this, PregnancyDueDate.class);
        startActivity(intent);
    }

    private void openEnterSymptomsActivity() {
        // Code to start the Enter Symptoms activity
        Intent intent = new Intent(MainPage.this, PregnancyTrackerActivity.class);
        startActivity(intent);
    }

    private void openBookAppointmentActivity() {
        // Code to start the Book Appointment activity
        Intent intent = new Intent(MainPage.this, PatientAppointmentActivity.class);
        startActivity(intent);
    }
}