package com.techcos.notesbro.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.techcos.notesbro.R;
import com.techcos.notesbro.admin.AdminInterfaceActivity;

public class AdminLoginActivity extends AppCompatActivity {

    EditText email,pass;
    AppCompatButton login;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        findIDs();

        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInUser();
            }
        });


    }

    private void logInUser()
    {
        progressBar.setVisibility(View.VISIBLE);

        String emailStr, passwordStr;
        emailStr = email.getText().toString();
        passwordStr = pass.getText().toString();

        if (TextUtils.isEmpty(emailStr)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(passwordStr)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(emailStr, passwordStr)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                                    "Login successful!!",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressBar.setVisibility(View.GONE);

                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(AdminLoginActivity.this,
                                            LoginActivity.class);
                                    startActivity(intent);
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!!",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
    }

     void  findIDs(){
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar);

     }
}




//package com.geeksforgeeks.firebaseuserauthentication;
//
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.content.Intent;
//        import android.view.View;
//        import android.widget.Toast;
//        import android.widget.EditText;
//        import android.widget.TextView;
//        import android.widget.Button;
//
//        import com.google.firebase.auth.FirebaseAuth;
//        import com.google.firebase.auth.AuthResult;
//        import com.google.android.gms.tasks.OnCompleteListener;
//        import com.google.android.gms.tasks.Task;
//
//public class LoginActivity extends AppCompatActivity {
//
//    private EditText emailTextView, passwordTextView;
//    private Button Btn;
//    private ProgressBar progressbar;
//
//    private FirebaseAuth mAuth;
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        // taking instance of FirebaseAuth
//        mAuth = FirebaseAuth.getInstance();
//
//        // initialising all views through id defined above
//        emailTextView = findViewById(R.id.email);
//        passwordTextView = findViewById(R.id.password);
//        Btn = findViewById(R.id.login);
//        progressbar = findViewById(R.id.progressBar);
//
//        // Set on Click Listener on Sign-in button
//        Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                loginUserAccount();
//            }
//        });
//    }
//
//    private void loginUserAccount()
//    {
//
//        // show the visibility of progress bar to show loading
//        progressbar.setVisibility(View.VISIBLE);
//
//        // Take the value of two edit texts in Strings
//        String email, password;
//        email = emailTextView.getText().toString();
//        password = passwordTextView.getText().toString();
//
//        // validations for input email and password
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(getApplicationContext(),
//                            "Please enter email!!",
//                            Toast.LENGTH_LONG)
//                    .show();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(getApplicationContext(),
//                            "Please enter password!!",
//                            Toast.LENGTH_LONG)
//                    .show();
//            return;
//        }
//
//        // signin existing user
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(
//                        new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(
//                                    @NonNull Task<AuthResult> task)
//                            {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(getApplicationContext(),
//                                                    "Login successful!!",
//                                                    Toast.LENGTH_LONG)
//                                            .show();
//
//                                    // hide the progress bar
//                                    progressBar.setVisibility(View.GONE);
//
//                                    // if sign-in is successful
//                                    // intent to home activity
//                                    Intent intent
//                                            = new Intent(LoginActivity.this,
//                                            MainActivity.class);
//                                    startActivity(intent);
//                                }
//
//                                else {
//
//                                    // sign-in failed
//                                    Toast.makeText(getApplicationContext(),
//                                                    "Login failed!!",
//                                                    Toast.LENGTH_LONG)
//                                            .show();
//
//                                    // hide the progress bar
//                                    progressbar.setVisibility(View.GONE);
//                                }
//                            }
//                        });
//    }
//}
