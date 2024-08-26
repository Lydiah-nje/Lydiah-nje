package com.example.myproject.Chat;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private LinearLayout chatMessagesContainer;
    private EditText messageInputField;
    private Button sendButton;
    private DatabaseReference usersReference;
    private DatabaseReference messagesReference;
    private FirebaseUser currentUser;
    private String userName;
    private String selectedClinicianEmail; // Email of the selected clinician
    private ChildEventListener messagesListener;
    private Map<String, User> clinicianMap; // Map to store clinicians for easy access

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initialize Firebase Database references
        usersReference = FirebaseDatabase.getInstance().getReference().child("clinicians");
        messagesReference = FirebaseDatabase.getInstance().getReference().child("Messages");

        // Initialize current user
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            userName = currentUser.getDisplayName(); // Get the current user's display name
        } else {
            Log.w("chat", "User not authenticated");
        }

        // Initialize views
        scrollView = findViewById(R.id.chatScrollView);
        chatMessagesContainer = findViewById(R.id.chatMessagesContainer);
        messageInputField = findViewById(R.id.messageInputField);
        sendButton = findViewById(R.id.sendButton);

        // Initialize clinician map
        clinicianMap = new HashMap<>();

        // Load clinicians
        loadClinicians();

        // Set click listener for send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void loadClinicians() {
        usersReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String previousChildName) {
                User user = dataSnapshot.getValue(User.class);
                if (user != null && !user.getEmail().equals(currentUser.getEmail())) {
                    clinicianMap.put(user.getEmail(), user);
                    displayClinician(user);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String previousChildName) {
                // Handle changes if necessary
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                // Handle removals if necessary
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String previousChildName) {
                // Handle moves if necessary
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("chat", "Database error: " + databaseError.getMessage());
            }
        });
    }

    private void displayClinician(User clinician) {
        TextView clinicianTextView = new TextView(this);
        clinicianTextView.setText(clinician.getName());
        clinicianTextView.setPadding(16, 8, 16, 8);
        clinicianTextView.setGravity(Gravity.CENTER);
        clinicianTextView.setBackgroundResource(R.drawable.user_background);
        clinicianTextView.setTextColor(getResources().getColor(android.R.color.black));

        // Set click listener to select the clinician for chat
        clinicianTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedClinicianEmail = clinician.getEmail(); // Use email as the ID
                chatMessagesContainer.removeAllViews(); // Clear previous messages
                loadMessages(); // Load existing messages
                showChatInterface(); // Show chat interface
            }
        });

        // Add the TextView to the chat messages container
        chatMessagesContainer.addView(clinicianTextView);
    }

    private void loadMessages() {
        if (selectedClinicianEmail != null) {
            messagesReference.child(encodeEmail(selectedClinicianEmail)).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String previousChildName) {
                    chatmessage chatMessage = dataSnapshot.getValue(chatmessage.class);
                    if (chatMessage != null) {
                        receiveMessage(chatMessage); // Display the received message
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String previousChildName) {
                    // Not used in this scenario
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    // Not used in this scenario
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String previousChildName) {
                    // Not used in this scenario
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e("chat", "Database error: " + databaseError.getMessage());
                }
            });
        }
    }

    private void sendMessage() {
        String messageText = messageInputField.getText().toString().trim();
        if (!messageText.isEmpty() && userName != null && selectedClinicianEmail != null) {
            // Create a new chatmessage object
            User sender = new User(userName, currentUser.getEmail());
            chatmessage message = new chatmessage(sender, messageText);

            // Push the message to Firebase Database
            messagesReference.child(encodeEmail(selectedClinicianEmail)).push().setValue(message).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(ChatActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("chat", "Failed to send message", task.getException());
                        Toast.makeText(ChatActivity.this, "Failed to send message", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Clear the message input field
            messageInputField.setText("");
        } else {
            Toast.makeText(this, "Message cannot be empty or user not authenticated", Toast.LENGTH_SHORT).show();
        }
    }

    private void receiveMessage(chatmessage chatMessage) {
        String message = chatMessage.getMessageText();
        User sender = chatMessage.getSender();

        // Create a new TextView to display the received message
        TextView messageTextView = new TextView(this);
        messageTextView.setText(sender.getName() + ": " + message);
        messageTextView.setPadding(16, 8, 16, 8);

        // Set layout params
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 4, 0, 4);

        // Check if sender is the current user before setting gravity and background
        if (userName != null && userName.equals(sender.getName())) {
            params.gravity = Gravity.END;
            messageTextView.setBackgroundResource(R.drawable.outgoing_message_background);
        } else {
            params.gravity = Gravity.START;
            messageTextView.setBackgroundResource(R.drawable.incoming_message_background);
        }
        messageTextView.setLayoutParams(params);
        messageTextView.setTextColor(getResources().getColor(android.R.color.black));

        // Add the TextView to the chat messages container
        chatMessagesContainer.addView(messageTextView);

        // Scroll to the bottom to show the latest message
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void showChatInterface() {
        // Make the chat interface visible
        scrollView.setVisibility(View.VISIBLE);
        messageInputField.setVisibility(View.VISIBLE);
        sendButton.setVisibility(View.VISIBLE);
    }

    private String encodeEmail(String email) {
        return email.replace(".", ",");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the listener when activity is destroyed
        if (messagesReference != null && messagesListener != null) {
            messagesReference.removeEventListener(messagesListener);
        }
    }

    // User class to store user data
    public static class User {
        private String name;
        private String email;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    // chatmessage class to store chat data
    public static class chatmessage {
        private User sender;
        private String messageText;

        public chatmessage() {
            // Default constructor required for calls to DataSnapshot.getValue(chatmessage.class)
        }

        public chatmessage(User sender, String messageText) {
            this.sender = sender;
            this.messageText = messageText;
        }

        public User getSender() {
            return sender;
        }

        public String getMessageText() {
            return messageText;
        }
    }
}
