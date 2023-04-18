package com.example.gamecore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewScore1 = findViewById(R.id.textViewTeamScore1);
        TextView textViewScore2 = findViewById(R.id.textViewTeamScore2);

        textViewScore1.setText(String.valueOf(score1));
        textViewScore2.setText(String.valueOf(score2));

        textViewScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewScore1.setText(String.valueOf(++score1));
            }
        });
        textViewScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewScore2.setText(String.valueOf(++score2));
            }
        });
    }
}