package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppointmentAdapter extends ArrayAdapter<Appointment> {

    private Context context;
    private List<Appointment> appointments;

    public AppointmentAdapter(@NonNull Context context, List<Appointment> appointments) {
        super(context, R.layout.item_appointments, appointments);
        this.context = context;
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_appointments, parent, false);
        }

        Appointment appointment = appointments.get(position);

        TextView timeTextView = convertView.findViewById(R.id.timeTextView);
        TextView statusTextView = convertView.findViewById(R.id.statusTextView);

        timeTextView.setText(appointment.getTime());
        statusTextView.setText(appointment.isBooked() ? "Booked" : "Available");

        return convertView;
    }
}
