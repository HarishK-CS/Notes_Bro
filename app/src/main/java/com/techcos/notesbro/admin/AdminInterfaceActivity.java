package com.techcos.notesbro.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.techcos.notesbro.R;

public class AdminInterfaceActivity extends AppCompatActivity {

    AppCompatButton registerUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_interface);

        findIds();

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminInterfaceActivity.this,RegisterUserActivity.class);
                startActivity(intent);
            }
        });
    }
    void findIds(){
        registerUser = findViewById(R.id.registerUser);
    }
}