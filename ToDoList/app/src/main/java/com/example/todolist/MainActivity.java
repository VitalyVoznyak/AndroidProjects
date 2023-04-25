package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutNotes;
    private FloatingActionButton buttonAddNote;

    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddNoteActivity.newIntent(MainActivity.this));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNodes();
    }

    private void initViews(){
        linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }
    private void showNodes(){
        linearLayoutNotes.removeAllViews();
        for (Note note: dataBase.getNotes()) {
            View view = getLayoutInflater().inflate(
                    R.layout.note_item,
                    linearLayoutNotes,
                    false
            );
            TextView textViewNote = view.findViewById(R.id.textViewNote);
            textViewNote.setText(note.getText());

            int colorResId;
            switch (note.getPriority()){
                case 0:
                    colorResId = android.R.color.holo_green_light;
                    break;
                case 1:
                    colorResId = android.R.color.holo_orange_light;
                    break;
                default:
                    colorResId = android.R.color.holo_red_light;
                    break;
            }
            int color = ContextCompat.getColor(this,colorResId);
            textViewNote.setBackgroundColor(color);
            linearLayoutNotes.addView(view);
        }
    }
}