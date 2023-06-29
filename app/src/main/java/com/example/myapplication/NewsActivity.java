package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewsActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }

    public void showEvents(View view) {
        intent = new Intent(NewsActivity.this, EventsActivity.class);
        startActivity(intent);
    }

    public void showInnovations(View view) {
        intent = new Intent(NewsActivity.this, InnovationsActivity.class);
        startActivity(intent);
    }
}