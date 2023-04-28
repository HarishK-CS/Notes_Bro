package com.techcos.notesbro.cse.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.techcos.notesbro.R;

public class CseSem2Activity extends AppCompatActivity {

    Spinner sub,unit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sem2);

        findIDs();

        ArrayAdapter<CharSequence> adapterSub = ArrayAdapter.createFromResource(this,R.array.cseSem2,R.layout.custom_spinner);
        sub.setAdapter(adapterSub);

        ArrayAdapter<CharSequence> adapterUnit = ArrayAdapter.createFromResource(this,R.array.unit,R.layout.custom_spinner);
        unit.setAdapter(adapterUnit);

        sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

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