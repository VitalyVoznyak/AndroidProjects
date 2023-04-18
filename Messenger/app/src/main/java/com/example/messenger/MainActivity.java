package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button buttonSendMessage = findViewById(R.id.buttonSendMessage);
        EditText editMessageText = findViewById(R.id.editMessageText);


        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editMessageText.getText().toString();
                launchNextScreen(messageText);
            }
        });
    }
    private void  launchNextScreen(String message){
        Intent intent = new Intent(this,ReceivedMessageActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}