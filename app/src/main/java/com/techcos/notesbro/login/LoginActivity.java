package com.techcos.notesbro.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techcos.notesbro.R;
import com.techcos.notesbro.civil.CivilListActivity;
import com.techcos.notesbro.cse.CseListActivity;
import com.techcos.notesbro.ece.EceListActivity;
import com.techcos.notesbro.eee.EeeListActivity;
import com.techcos.notesbro.it.ItListActivity;
import com.techcos.notesbro.mech.MechListActivity;

public class LoginActivity extends AppCompatActivity {

    AppCompatButton student,staff,admin;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        DatabaseReference userRef = databaseReference.child("user");

//        UserInformation userInformation = new UserInformation(mAuth.getUid(),"TechCos","CSE","admin@techcos.in","SHRAM@2022",true,false);
//        userRef.child(mAuth.getUid()).setValue(userInformation);

        if (mAuth.getCurrentUser() != null) {
            if(mAuth.getCurrentUser().isAnonymous()){
                Intent intent = new Intent(LoginActivity.this, CseListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }else {
                userRef.child(mAuth.getUid())
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild("dept")) {
                                    String dept = snapshot.child("dept").getValue().toString();

                                    if (dept.equals("CSE")) {
                                        Intent intent = new Intent(LoginActivity.this, CseListActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    } else if (dept.equals("IT")) {
                                        Intent intent = new Intent(LoginActivity.this, ItListActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    } else if (dept.equals("MECH")) {
                                        Intent intent = new Intent(LoginActivity.this, MechListActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    } else if (dept.equals("ECE")) {
                                        Intent intent = new Intent(LoginActivity.this, EceListActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    } else if (dept.equals("EEE")) {
                                        Intent intent = new Intent(LoginActivity.this, EeeListActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    } else if (dept.equals("CIVIL")) {
                                        Intent intent = new Intent(LoginActivity.this, CivilListActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Log In error", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "Log In error", Toast.LENGTH_SHORT).show();
                                }


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }

        }

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
                Intent intent = new Intent(LoginActivity.this, StaffRegisterActivity.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, AdminLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    void findIDs(){
        student = findViewById(R.id.studentLogin);
        staff = findViewById(R.id.staffLogin);
        admin = findViewById(R.id.adminLogin);
    }

}