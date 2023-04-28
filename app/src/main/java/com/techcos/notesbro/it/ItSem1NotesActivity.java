package com.techcos.notesbro.it;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.techcos.notesbro.R;

public class ItSem1NotesActivity extends AppCompatActivity {

    Spinner sub,unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_sem1_notes);

        findIDs();
        ArrayAdapter<CharSequence> subAdapter = ArrayAdapter.createFromResource(this,R.array.dept,R.layout.custom_spinner);
        sub.setAdapter(subAdapter);

        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(this,R.array.dept,R.layout.custom_spinner);
        unit.setAdapter(unitAdapter);

        sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                res_dept = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(StudentLoginActivity.this, res_dept, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                res_dept = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(StudentLoginActivity.this, res_dept, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    void findIDs(){
        sub = findViewById(R.id.subSpinner);
        unit = findViewById(R.id.unitSpinner);
    }
}