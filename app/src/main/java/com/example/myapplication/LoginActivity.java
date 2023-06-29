package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    private EditText Email, Password;
    String intentEmail, intentPassword;
    String emailString, passwordString;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
    }

    @Override
    protected void onStart() {
        super.onStart();

        intent = getIntent();
        intentEmail = intent.getStringExtra("emailString");
        intentPassword = intent.getStringExtra("passwordString");
        Email.setText(intentEmail);
        Password.setText(intentPassword);

    }



    public void forgotPassword(View view) {
    }

    public void login(View view) {
        emailString = Email.getText().toString().trim();
        passwordString = Password.getText().toString().trim();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "התחברת בהצלחה!", Toast.LENGTH_SHORT).show();
                    intent = new Intent(LoginActivity.this, NewsActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "הייתה בעיה בהתחברותך, וודא את פרטי המשתמש", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void register(View view) {
        intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void rememberMe(View view) {
    }
}