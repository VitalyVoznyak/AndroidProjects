package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextNote;
    private RadioButton radioButtonLow;
    private RadioButton radioButtonMedium;
    private Button buttonSave;
    private NoteDataBase dataBase;
    private Handler handler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();

        dataBase = NoteDataBase.getInstance(getApplication());
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void initViews() {
        editTextNote = findViewById(R.id.editTextNote);
        radioButtonLow = findViewById(R.id.radioButtonLow);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        buttonSave = findViewById(R.id.buttonSave);
    }
    private void saveNote(){
        String text = editTextNote.getText().toString().trim();
        int priority = getPriority();
        Note note = new Note(0,text,priority);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dataBase.notesDao().add(note);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        });
        thread.start();
    }
    private int getPriority(){
        int priority;
        if(radioButtonLow.isChecked()){
            priority = 0;
        }else if(radioButtonMedium.isChecked()){
            priority = 1;
        } else {
            priority = 2;
        }
        return priority;
    }
    public static Intent newIntent(Context context){
        return new Intent(context, AddNoteActivity.class);
    }
}