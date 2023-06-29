package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{
    Intent intent;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private EditText fullName, email, password;
    String emailString, passwordString, selectedCharacteristic, phoneNumber;
    CheckBox checkStudent, checkTeacher, checkMentor, checkServiceProvider;
    boolean studentChecked, teacherChecked, mentorChecked, serviceProviderChecked;
    AlertDialog.Builder adb;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);

        checkStudent = (CheckBox) findViewById(R.id.checkStudent);
        checkTeacher = (CheckBox) findViewById(R.id.checkTeacher);
        checkMentor = (CheckBox) findViewById(R.id.checkMentor);
        checkServiceProvider = (CheckBox) findViewById(R.id.checkServiceProvider);

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("הכנס את מספר הטלפון שלך ווודא את תקינותו");
        final EditText eT = new EditText(this);
        eT.setInputType(InputType.TYPE_CLASS_PHONE);
        eT.setText("                    ");
        eT.requestFocus();
        adb.setView(eT);
        adb.setPositiveButton("המשך", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                phoneNumber = eT.getText().toString().trim();
                if(phoneNumber.isEmpty())return;

                if(checkStudent.isChecked()) studentChecked=true;
                if(checkTeacher.isChecked()) teacherChecked=true;
                if(checkMentor.isChecked()) mentorChecked=true;
                if(checkServiceProvider.isChecked()) serviceProviderChecked=true;

                // user data saving on Firebase Database
                StudentValue studentValue = new StudentValue(fullName.getText().toString().trim(), emailString, passwordString, selectedCharacteristic, phoneNumber, studentChecked, teacherChecked, mentorChecked, serviceProviderChecked);
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Student Info").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                databaseReference.setValue(studentValue);

                // new user creation
                firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(emailString, passwordString);
                Toast.makeText(RegisterActivity.this, "יצירת המשתמש נעשתה בהצלחה!", Toast.LENGTH_SHORT).show();
                intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("emailString", emailString);
                intent.putExtra("passwordString", passwordString);
                startActivity(intent);

                dialogInterface.dismiss();
            }
        });
        adb.setNegativeButton("בטל", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        ad=adb.create();

    }

    public void mainPage(View view) {
        intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void registerUser(View view) {
        emailString = email.getText().toString().trim();
        passwordString = password.getText().toString().trim();

        // checking for empty fields
        if(         fullName.getText().toString().trim().length() == 0 ||  emailString.length() == 0 ||  passwordString.length() == 0 || !boxIsChecked(checkStudent,  checkTeacher, checkMentor, checkServiceProvider)) {
            Toast.makeText(this, "אנא מלא את כל התאים על מנת להמשיך!", Toast.LENGTH_LONG).show();
        }
        else {
            ad.show();
        }

    }

    public boolean boxIsChecked (CheckBox checkStudent,  CheckBox checkTeacher, CheckBox checkMentor, CheckBox checkServiceProvider){
        if(checkStudent.isChecked() || checkTeacher.isChecked() || checkMentor.isChecked() || checkServiceProvider.isChecked()) return true;
        else{
            return false;
        }
    }

    // this function is called on clicking validate button
    public boolean checkPhone (String phone) {
        // checking text is entered or empty
        if (!phone.isEmpty()) {
            // storing the entered number in to string
            return false;
        }
        if(android.util.Patterns.PHONE.matcher(phone).matches())
        // using android available method of checking phone
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}