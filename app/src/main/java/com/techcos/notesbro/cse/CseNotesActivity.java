package com.techcos.notesbro.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.techcos.notesbro.R;

public class CseNotesActivity extends AppCompatActivity {

    AppCompatButton sem1;
    AppCompatButton sem2;
    AppCompatButton sem3;
    AppCompatButton sem4;
    AppCompatButton sem5;
    AppCompatButton sem6;
    AppCompatButton sem7;
    AppCompatButton sem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_notes);

        findIDs();


        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this,CseSem1Activity.class);
                startActivity(intent);
            }
        });
    }

    void findIDs(){
        sem1 = findViewById(R.id.sem1Id);
        sem2 = findViewById(R.id.sem2Id);
        sem3 = findViewById(R.id.sem3Id);
        sem4 = findViewById(R.id.sem4Id);
        sem5 = findViewById(R.id.sem5Id);
        sem6 = findViewById(R.id.sem6Id);
        sem7 = findViewById(R.id.sem7Id);
        sem8 = findViewById(R.id.sem8Id);
    }

}