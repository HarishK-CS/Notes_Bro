package com.techcos.notesbro.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.techcos.notesbro.MainActivity;
import com.techcos.notesbro.R;
import com.techcos.notesbro.civil.CivilListActivity;
import com.techcos.notesbro.cse.CseListActivity;
import com.techcos.notesbro.ece.EceListActivity;
import com.techcos.notesbro.eee.EeeListActivity;
import com.techcos.notesbro.it.ItListActivity;
import com.techcos.notesbro.mech.MechListActivity;

public class StudentLoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText name;
    AppCompatButton setUpSubmit;
    String res_dept;
    Spinner dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        findIDs();
        mAuth = FirebaseAuth.getInstance();
        ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.dept,R.layout.custom_spinner);
        dept.setAdapter(adapterDept);

        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_dept = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(StudentLoginActivity.this, res_dept, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setUpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (res_dept.equals("----")){
                    Toast.makeText(StudentLoginActivity.this, "Select a valid department ! ", Toast.LENGTH_SHORT).show();
                }else{

                    mAuth.signInAnonymously()
                            .addOnCompleteListener(
                                    new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        if (res_dept.equals("CSE")){
                                            Intent intent = new Intent(StudentLoginActivity.this, CseListActivity.class);
                                            finish();
                                            startActivity(intent);
                                        } else if (res_dept.equals("IT")) {
                                            Intent intent = new Intent(StudentLoginActivity.this, ItListActivity.class);
                                            finish();
                                            startActivity(intent);
                                        }
                                        else if (res_dept.equals("EEE")) {
                                            Intent intent = new Intent(StudentLoginActivity.this, EeeListActivity.class);
                                            finish();
                                            startActivity(intent);
                                        }
                                        else if (res_dept.equals("ECE")) {
                                            Intent intent = new Intent(StudentLoginActivity.this, EceListActivity.class);
                                            finish();
                                            startActivity(intent);
                                        }
                                        else if (res_dept.equals("CIVIL")) {
                                            Intent intent = new Intent(StudentLoginActivity.this, CivilListActivity.class);
                                            finish();
                                            startActivity(intent);
                                        }
                                        else if (res_dept.equals("MECH")) {
                                            Intent intent = new Intent(StudentLoginActivity.this, MechListActivity.class);
                                            finish();
                                            startActivity(intent);
                                        }
                                    }else{
                                        Toast.makeText(StudentLoginActivity.this, "Auth Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
            }
        });
    }

    void findIDs(){
        name = findViewById(R.id.txt_name);
        setUpSubmit = findViewById(R.id.Btn_setupProfile);
        dept = findViewById(R.id.spinner_dept);
    }
}