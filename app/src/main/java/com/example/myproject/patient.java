package com.example.myproject;

public class patient{
    private String email;
    private String password;

    public patient(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}