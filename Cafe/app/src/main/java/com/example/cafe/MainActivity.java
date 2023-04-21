package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editTextName, editTextPassword;

    String name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString().trim();
                password = editTextPassword.getText().toString().trim();

                if (name.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.error_fields_empty,Toast.LENGTH_SHORT).show();

                }else {
                    name = editTextName.getText().toString();
                    password = editTextPassword.getText().toString();
                    launchNextScreen();
                }
            }
        });
    }
    private void launchNextScreen(){
        startActivity(MainOrderActivity.newIntent(MainActivity.this, name));
    }
    private void initViews(){
        button = findViewById(R.id.buttonSignIn);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }
}