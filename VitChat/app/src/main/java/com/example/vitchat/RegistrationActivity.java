package com.example.vitchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    EditText editTextEmail,editTextPassword,editTextName,editTextLastName,editTextAge;
    Button buttonLogin;

    private RegistrationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        observeViewModel();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = getTrimmedValue(editTextEmail);
                String password = getTrimmedValue(editTextEmail);
                String name = getTrimmedValue(editTextName);
                String lastName = getTrimmedValue(editTextLastName);
                int age = Integer.parseInt(getTrimmedValue(editTextAge));
                viewModel.signUp(email,password,name,lastName,age);
                Log.d("rror","ror");
            }
        });
    }
    private void observeViewModel(){
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                if(errorMessage != null){
                    Toast.makeText(RegistrationActivity.this,errorMessage,Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.getUser().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser != null){
                    startActivity(UsersActivity.getIntent(RegistrationActivity.this));
                }
            }
        });
    }
    private void initViews (){
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonLogin = findViewById(R.id.buttonLogin);
    }
    private String getTrimmedValue(EditText editText){
        return editText.getText().toString().trim();
    }

    public static Intent getIntent(Context context){
        return new Intent(context, RegistrationActivity.class );
    }
}