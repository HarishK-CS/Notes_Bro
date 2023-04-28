package com.techcos.notesbro.cse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.techcos.notesbro.MainActivity;
import com.techcos.notesbro.R;
import com.techcos.notesbro.UploadActivity;
import com.techcos.notesbro.admin.AdminInterfaceActivity;
import com.techcos.notesbro.civil.CivilListActivity;
import com.techcos.notesbro.ece.EceListActivity;
import com.techcos.notesbro.eee.EeeListActivity;
import com.techcos.notesbro.it.ItListActivity;
import com.techcos.notesbro.login.LoginActivity;
import com.techcos.notesbro.login.StudentLoginActivity;
import com.techcos.notesbro.mech.MechListActivity;

public class CseListActivity extends AppCompatActivity {

    FirebaseStorage fs;
    StorageReference sr;
    DownloadManager downloadManager;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    AppCompatButton b1;
    long reference;
    Toolbar toolbar;
    AppCompatImageView adminIcon,uploadIcon,logoutIcon;
    AppCompatButton txtBook;
    AppCompatButton notes;
    AppCompatButton syllabus;
    AppCompatButton prevYrQues;
    AppCompatButton labManual;
    Spinner depts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_list);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        DatabaseReference userRef = databaseReference.child("user");

        userRef.child(mAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (mAuth.getCurrentUser().isAnonymous()) {

                } else {

                    Boolean isAdmin = (Boolean) snapshot.child("isAdmin").getValue();
                    Boolean isStaff = (Boolean) snapshot.child("isStaff").getValue();
                    if (isStaff) {
                        uploadIcon.setVisibility(View.VISIBLE);
                        logoutIcon.setVisibility(View.VISIBLE);
                    }
                    if (isAdmin) {
                        uploadIcon.setVisibility(View.VISIBLE);
                        adminIcon.setVisibility(View.VISIBLE);
                        logoutIcon.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        findIDs();

        ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.depts,R.layout.custom_spinner);
        depts.setAdapter(adapterDept);
        depts.setSelection(0);

        depts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("IT")){
                    Intent intent =  new Intent(CseListActivity.this, ItListActivity.class);
                    finish();
                    startActivity(intent);
                } else if (adapterView.getItemAtPosition(i).toString().equals("EEE")) {
                    Intent intent =  new Intent(CseListActivity.this, EeeListActivity.class);
                    finish();
                    startActivity(intent);
                }else if (adapterView.getItemAtPosition(i).toString().equals("ECE")) {
                    Intent intent =  new Intent(CseListActivity.this, EceListActivity.class);
                    finish();
                    startActivity(intent);
                }
                else if (adapterView.getItemAtPosition(i).toString().equals("CIVIL")) {
                    Intent intent =  new Intent(CseListActivity.this, CivilListActivity.class);
                    finish();
                    startActivity(intent);
                }
                else if (adapterView.getItemAtPosition(i).toString().equals("MECH")) {
                    Intent intent =  new Intent(CseListActivity.this, MechListActivity.class);
                    finish();
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fs = FirebaseStorage.getInstance();
        sr = fs.getReference().child("CSE");


        registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        txtBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseListActivity.this,CseTextbookActivity.class);
                startActivity(intent);
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseListActivity.this, CseNotesActivity.class);
                startActivity(intent);
            }
        });
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StorageReference dateRef = sr.child("CSE Syllabus"+".pdf");
                dateRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setTitle("CSE Syllabus");
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"/Notes Bro/"+ uri.getLastPathSegment());
                        reference = downloadManager.enqueue(request);
                    }
                });

            }
        });

        adminIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseListActivity.this, AdminInterfaceActivity.class);
                startActivity(intent);
            }
        });

        uploadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CseListActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });

        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(CseListActivity.this, "You Have Been Sign Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CseListActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
                Toast.makeText(CseListActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();
            }
        }
    };

    void findIDs(){
        txtBook = findViewById(R.id.Btn_textBook);
        notes = findViewById(R.id.Btn_notes);
        syllabus = findViewById(R.id.Btn_syllabus);
        prevYrQues = findViewById(R.id.Btn_prevYrQues);
        labManual = findViewById(R.id.Btn_labmanual);

        toolbar = findViewById(R.id.main_page_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(Html.fromHtml("<small>Notes Bro</small>"));

        depts = findViewById(R.id.spinnerCse);

        adminIcon = findViewById(R.id.admin);
        uploadIcon = findViewById(R.id.upload);
        logoutIcon = findViewById(R.id.logout);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }
}