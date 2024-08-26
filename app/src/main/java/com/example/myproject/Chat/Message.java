package com.example.myproject.Chat;

public class Message {
    private String senderId;
    private String receiverId;
    private String senderName; // New field
    private String message;
    private long timestamp;

    public Message() {
        // Default constructor required for calls to DataSnapshot.getValue(Message.class)
    }

    public Message(String senderId, String receiverId, String senderName, String message, long timestamp) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and setters for all fields
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
