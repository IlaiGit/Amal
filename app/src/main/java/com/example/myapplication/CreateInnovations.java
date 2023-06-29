package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class CreateInnovations extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;
    String pic_id;
    Integer icon_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_innovations);

       gridView = (GridView) findViewById(R.id.grid);
       GridViewAdapter gridViewAdapter = new
               GridViewAdapter(CreateInnovations.this, new ArrayListModel().setListData());
       gridView.setAdapter(gridViewAdapter);
       gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        AlphabetModel model = (AlphabetModel) parent.getItemAtPosition(position);
        pic_id = model.getLetters();
        icon_id = model.getIconId();
    }
}