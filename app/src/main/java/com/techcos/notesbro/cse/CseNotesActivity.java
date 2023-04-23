package com.techcos.notesbro.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.techcos.notesbro.R;
import com.techcos.notesbro.cse.notes.CseSem1Activity;
import com.techcos.notesbro.cse.notes.CseSem2Activity;
import com.techcos.notesbro.cse.notes.CseSem3Activity;
import com.techcos.notesbro.cse.notes.CseSem4Activity;
import com.techcos.notesbro.cse.notes.CseSem5Activity;
import com.techcos.notesbro.cse.notes.CseSem6Activity;
import com.techcos.notesbro.cse.notes.CseSem7Activity;
import com.techcos.notesbro.cse.notes.CseSem8Activity;

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
                Intent intent = new Intent(CseNotesActivity.this, CseSem1Activity.class);
                startActivity(intent);
            }
        });
        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem2Activity.class);
                startActivity(intent);
            }
        });
        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem3Activity.class);
                startActivity(intent);
            }
        });
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem4Activity.class);
                startActivity(intent);
            }
        });
        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem5Activity.class);
                startActivity(intent);
            }
        });
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem6Activity.class);
                startActivity(intent);
            }
        });
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem7Activity.class);
                startActivity(intent);
            }
        });
        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseNotesActivity.this, CseSem8Activity.class);
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