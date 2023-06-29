package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference reference;
    TextView event_a, event_b, event_c;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> valueArr = new ArrayList<>();
    CheckBox check_a, check_b, check_c;
    StudentValue currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        event_a = (TextView) findViewById(R.id.event_a);
        event_b = (TextView) findViewById(R.id.event_b);
        event_c = (TextView) findViewById(R.id.event_c);

        check_a = (CheckBox) findViewById(R.id.checkBox_a);
        check_b = (CheckBox) findViewById(R.id.checkBox_b);
        check_c = (CheckBox) findViewById(R.id.checkBox_c);


        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("אירועים");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.clear();
                valueArr.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    arr.add(snapshot.getValue().toString());
                    valueArr.add(snapshot.getKey());
                }
                event_a.setText(arr.get(0));
                event_b.setText(arr.get(1));
                event_c.setText(arr.get(2));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void check_c(View view) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("אישורי הגעה");
        if(check_c.isChecked()){
            reference.child(firebaseAuth.getCurrentUser().getUid()).child("event_c").setValue(arr.get(2) + "   " + "מגיע");
        }
        else{
            reference.child(firebaseAuth.getCurrentUser().getUid()).child("event_c").setValue(arr.get(2) + "   " + "לא מגיע");
        }
    }

    public void check_b(View view) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("אישורי הגעה");
        if(check_b.isChecked()){
            reference.child(firebaseAuth.getCurrentUser().getUid()).child("event_b").setValue(arr.get(1) + "   " + "מגיע");
        }
        else{
            reference.child(firebaseAuth.getCurrentUser().getUid()).child("event_b").setValue(arr.get(1) + "   " + "לא מגיע");
        }
    }

    public void check_a(View view) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("אישורי הגעה");
        if(check_a.isChecked()){
            reference.child(firebaseAuth.getCurrentUser().getUid()).child("event_a").setValue(arr.get(0) + "   " + "מגיע");
        }
        else{
            reference.child(firebaseAuth.getCurrentUser().getUid()).child("event_a").setValue(arr.get(0) + "   " + "לא מגיע");
        }
    }
}