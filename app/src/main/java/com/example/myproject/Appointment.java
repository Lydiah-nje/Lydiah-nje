package com.example.myproject;
public class Appointment {
    private String id;
    private String time;
    private boolean isBooked;
    private String patientName;


    public Appointment() {
    }

    public Appointment(String time, boolean isBooked) {
        this.time = time;
        this.isBooked = isBooked;
    }
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
