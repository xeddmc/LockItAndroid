package com.example.lockitpasswordsaver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText mUsernameet, mEmailEt, mPasswordet;
    Button mRegisterButton;
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Create Account");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mUsernameet = findViewById(R.id.username_textField);
        mEmailEt = findViewById(R.id.email_textField);
        mPasswordet = findViewById(R.id.password_textField);
        mRegisterButton = findViewById(R.id.sign_up_button);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Working...");

        mAuth = FirebaseAuth.getInstance();

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEt.getText().toString().trim();
                String password = mPasswordet.getText().toString().trim();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mEmailEt.setError("Invalid Email");
                    mEmailEt.setFocusable(true);
                } else if (password.length() < 6) {
                    mPasswordet.setError("Please Enter A Password At Least 6 Digits");
                    mPasswordet.setFocusable(true);
                } else {
                    System.out.println("HI");
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}