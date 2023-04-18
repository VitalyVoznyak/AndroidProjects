package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        TextView textView = findViewById(R.id.textViewMessage);
        textView.setText(message);
    }
}