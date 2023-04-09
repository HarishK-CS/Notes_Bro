package com.techcos.notesbro.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.techcos.notesbro.MainActivity;
import com.techcos.notesbro.R;

public class LoginActivity extends AppCompatActivity {
    AppCompatButton student;
    AppCompatButton staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findIDs();

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,StaffLoginActivity.class);
                startActivity(intent);
            }
        });

    }

    void findIDs(){
        student = findViewById(R.id.studentLogin);
        staff = findViewById(R.id.staffLogin);
    }
}