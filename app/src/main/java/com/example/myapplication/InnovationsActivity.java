package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InnovationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovations);
    }

    public void move(View view) {
        Intent intent = new Intent(InnovationsActivity.this, CreateInnovations.class);
        startActivity(intent);
    }
}