package com.techcos.notesbro.ece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
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
    Spinner depts;

    FirebaseStorage fs;
    StorageReference sr;
    DownloadManager downloadManager;
    long reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_list);

        findIDs();
        fs = FirebaseStorage.getInstance();
        sr = fs.getReference().child("ECE");
        registerReceiver(onDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

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

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StorageReference dateRef = sr.child("ECE Syllabus" + ".pdf");
                dateRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setTitle("ECE Syllabus");
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/Notes Bro/" + uri.getLastPathSegment());
                        reference = downloadManager.enqueue(request);
                    }
                });

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
                Toast.makeText(EceListActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }



    void findIDs(){
        txtBook = findViewById(R.id.Btn_textBook);
        notes = findViewById(R.id.Btn_notes);
        syllabus = findViewById(R.id.Btn_syllabus);
        prevYrQues = findViewById(R.id.Btn_prevYrQues);
        labManual = findViewById(R.id.Btn_labmanual);

        depts = findViewById(R.id.spinnerEce);
    }
}