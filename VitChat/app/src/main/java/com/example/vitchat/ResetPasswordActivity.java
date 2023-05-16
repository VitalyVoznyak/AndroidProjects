package com.example.vitchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private static final String EXTRA_EMAIL = "email";

    private EditText editTextEmail;
    private Button buttonResetPassword;
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    private ResetPasswordViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initViews();
        viewModel = new ViewModelProvider(this).get(ResetPasswordViewModel.class);
        observeViewModel();
        editTextEmail.setText(getIntent().getStringExtra(EXTRA_EMAIL));

        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                viewModel.resetPassword(email);
            }
        });
    }

    private void observeViewModel(){
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                if(errorMessage != null){
                    Toast.makeText(ResetPasswordActivity.this,errorMessage,Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        viewModel.getIsSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                Toast.makeText(ResetPasswordActivity.this, R.string.reset_link_sent,Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void initViews(){
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonResetPassword = findViewById(R.id.buttonResetPassword);
    }
    public static Intent getIntent(Context context,String email){
        Intent intent = new Intent(context, ResetPasswordActivity.class);
        intent.putExtra(EXTRA_EMAIL,email);
        return intent;
    }
}