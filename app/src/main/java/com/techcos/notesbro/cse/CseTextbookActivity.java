package com.techcos.notesbro.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.techcos.notesbro.R;


public class CseTextbookActivity extends AppCompatActivity {

    FirebaseStorage fs;
    StorageReference sr;
    DownloadManager downloadManager;
    AppCompatButton b1;
    long reference;

    Spinner sems;
    RecyclerView semRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_textbook);

        findIDs();

        fs = FirebaseStorage.getInstance();
        sr = fs.getReference().child("CSE");

        ArrayAdapter<CharSequence> adapterSem = ArrayAdapter.createFromResource(this,R.array.sem,R.layout.custom_spinner);
        sems.setAdapter(adapterSem);
        sems.setSelection(0);

        registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        sems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (adapterView.getItemAtPosition(i).toString().equals("IT")){
//
//                    startActivity(intent);
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (reference == id) {
                Toast.makeText(CseTextbookActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();
            }
        }
    };

    void findIDs(){
        sems = findViewById(R.id.spinnerTextbook);
        semRecyclerView = findViewById(R.id.txtbookRecycler);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }

}