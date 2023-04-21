package com.example.gamecore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int score1 = 0;
    public int score2 = 0;

    private  TextView textViewScore1;
    private  TextView textViewScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        textViewScore1 = findViewById(R.id.textViewTeamScore1);
        textViewScore2 = findViewById(R.id.textViewTeamScore2);

        if (savedInstanceState != null)
        {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        OnScoreUpdate1();
        OnScoreUpdate2();

        textViewScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                score1++;
                OnScoreUpdate1();
            }
        });
        textViewScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2++;
                OnScoreUpdate2();
            }
        });
    }
    private  void  OnScoreUpdate1(){
        textViewScore1.setText(String.valueOf(score1));
    }
    private  void  OnScoreUpdate2(){
        textViewScore2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstanceState");
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }
}