package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddNoteActivity extends AppCompatActivity {

    EditText editTextNote;
    private RadioGroup radioGroup;
    private RadioButton radioButtonLow, radioButtonMedium,radioButtonHigh;
    private Button buttonSave;
    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }



    private void initViews(){
        editTextNote = findViewById(R.id.editTextNote);
        radioGroup = findViewById(R.id.radioGroupPriority);
        radioButtonLow = findViewById(R.id.radioButtonLow);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        radioButtonHigh = findViewById(R.id.radioButtonHigh);
        buttonSave = findViewById(R.id.buttonSave);
    }
    private void saveNote(){
        String noteName = editTextNote.getText().toString().trim();
        int notePriorityId = radioGroup.getCheckedRadioButtonId();
        int noteId = dataBase.getNotes().size();
        Note note = new Note(noteId,noteName,notePriorityId);
        dataBase.add(note);
        finish();
    }
    public static Intent newIntend(Context context){
        Intent intent = new Intent(context, AddNoteActivity.class);
        return intent;
    }
}