package com.techcos.notesbro.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techcos.notesbro.R;

public class RegisterUserActivity extends AppCompatActivity {

    EditText uid,username,email,password;
    Spinner dept;
    SwitchCompat isAdmin,isStaff;
    ProgressBar progressBar;
    AppCompatButton createUserButton;

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    String res_dept;
    Boolean res_admin,res_staff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        DatabaseReference userRef = databaseReference.child("user");

        findIds();

        res_admin=false;
        res_staff=false;

        ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.dept,R.layout.custom_spinner);
        dept.setAdapter(adapterDept);

        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_dept = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        isAdmin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                res_admin = b;
            }
        });

        isStaff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                res_staff = b;
            }
        });

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uid.getText().toString().equals("kWPg3cfq7RgcwOWRoe5dwzFJjuD2")){
                    Toast.makeText(RegisterUserActivity.this, "Nan Vilven Endru NinaithaYoo !! Admin account Can't be Changed", Toast.LENGTH_SHORT).show();
                }else{
                    createUserButton.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);

                    UserInformation userInformation = new UserInformation(uid.getText().toString(),username.getText().toString(),res_dept,email.getText().toString(),password.getText().toString(),res_admin,res_staff);
                    userRef.child(uid.getText().toString()).setValue(userInformation);

                    Toast.makeText(RegisterUserActivity.this, "User Created", Toast.LENGTH_SHORT).show();

                    createUserButton.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });




    }

    void findIds(){
        uid = findViewById(R.id.uid);
        username = findViewById(R.id.username);
        email = findViewById(R.id.userEmail);
        password = findViewById(R.id.userPassword);
        dept = findViewById(R.id.userDept);
        isAdmin = findViewById(R.id.adminSwitch);
        isStaff = findViewById(R.id.staffSwitch);
        progressBar = findViewById(R.id.progressBar);
        createUserButton = findViewById(R.id.SubmitUserRegister);
    }
}