package com.techcos.notesbro.ece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.techcos.notesbro.R;
import com.techcos.notesbro.civil.CivilListActivity;
import com.techcos.notesbro.cse.CseListActivity;
import com.techcos.notesbro.eee.EeeListActivity;
import com.techcos.notesbro.it.ItListActivity;
import com.techcos.notesbro.mech.MechListActivity;

public class EceListActivity extends AppCompatActivity {

    AppCompatButton txtBook;
    AppCompatButton notes;
    AppCompatButton syllabus;
    AppCompatButton prevYrQues;
    AppCompatButton labManual;
    AppCompatButton upload;
    Spinner depts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_list);

        findIDs();

        ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.depts,R.layout.custom_spinner);
        depts.setAdapter(adapterDept);
        depts.setSelection(3);

        depts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("IT")){
                    Intent intent =  new Intent(EceListActivity.this, ItListActivity.class);
                    finish();
                    startActivity(intent);
                } else if (adapterView.getItemAtPosition(i).toString().equals("EEE")) {
                    Intent intent =  new Intent(EceListActivity.this, EeeListActivity.class);
                    finish();
                    startActivity(intent);
                }else if (adapterView.getItemAtPosition(i).toString().equals("CSE")) {
                    Intent intent =  new Intent(EceListActivity.this, CseListActivity.class);
                    finish();
                    startActivity(intent);
                }
                else if (adapterView.getItemAtPosition(i).toString().equals("CIVIL")) {
                    Intent intent =  new Intent(EceListActivity.this, CivilListActivity.class);
                    finish();
                    startActivity(intent);
                }
                else if (adapterView.getItemAtPosition(i).toString().equals("MECH")) {
                    Intent intent =  new Intent(EceListActivity.this, MechListActivity.class);
                    finish();
                    startActivity(intent);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void findIDs(){
        txtBook = findViewById(R.id.Btn_textBook);
        notes = findViewById(R.id.Btn_notes);
        syllabus = findViewById(R.id.Btn_syllabus);
        prevYrQues = findViewById(R.id.Btn_prevYrQues);
        labManual = findViewById(R.id.Btn_labmanual);
        upload = findViewById(R.id.Btn_upload);

        depts = findViewById(R.id.spinnerEce);
    }
}