package com.example.myproject;

public class User {
    public String name;
    public String age;
    public String dueDate;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String age, String dueDate, String email) {
        this.name = name;
        this.age = age;
        this.dueDate = dueDate;
        this.email = email;
    }
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
