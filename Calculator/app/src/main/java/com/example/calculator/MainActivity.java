package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewCorrectAnswer = findViewById(R.id.textViewCorrectAnswer);
        TextView textViewWrongAnswer = findViewById(R.id.textViewWrongAnswer);
        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText("10 + 20 = ?");

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                if (text.equals("30")){
                    textViewCorrectAnswer.setVisibility(View.VISIBLE);
                    textViewWrongAnswer.setVisibility(View.GONE);
                }else {
                    textViewWrongAnswer.setVisibility(View.VISIBLE);
                    textViewCorrectAnswer.setVisibility(View.GONE);
                }
            }
        });
    }
}