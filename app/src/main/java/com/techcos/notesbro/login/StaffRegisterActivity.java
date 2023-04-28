package com.techcos.notesbro.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.techcos.notesbro.R;

public class StaffRegisterActivity extends AppCompatActivity {


    EditText name,email;
    TextView loginStaff;
    Spinner dept;
    String res_dept;
    AppCompatButton sendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_register);

        findIDs();

        ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.dept,R.layout.custom_spinner);
        dept.setAdapter(adapterDept);

        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_dept = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        loginStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffRegisterActivity.this,StaffLogInActivity.class);
                startActivity(intent);
            }
        });

        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = " Name : "+name.getText().toString()+"\n Dept: "+res_dept+"\n Email: "+email.getText().toString()+"\n Must Attach the Staff Identity Card to Create Account";
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] rec = {"TechCosIncorporated@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,rec);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Staff Account Creation - Regd");
                intent.putExtra(Intent.EXTRA_TEXT,txt);

                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent,"Send Mail"));
            }
        });


    }

    void findIDs(){
        name = findViewById(R.id.username);
        email = findViewById(R.id.inputEmail);
        dept = findViewById(R.id.dept);
        sendMail = findViewById(R.id.sendMail);
        loginStaff = findViewById(R.id.logInStaff);
    }
}