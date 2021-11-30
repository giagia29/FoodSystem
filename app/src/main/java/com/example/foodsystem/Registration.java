package com.example.foodsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    EditText Username, Useremail, Userpassword, Userphonenumber;
    //TextView title, registered;
    Button signin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //title = findViewById(R.id.Title);
        Username = findViewById(R.id.fullname);
        Useremail = (EditText) findViewById(R.id.registeremail);
        Userphonenumber = findViewById(R.id.PhoneNum);
        Userpassword = findViewById(R.id.registerpass);

        //registered = findViewById(R.id.Message);
        signin = findViewById(R.id.SignInBtn);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Useremail.getText().toString().trim();
                String password = Userpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    Useremail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Userpassword.setError("Password is required");
                    return;
                }
                if(password.length() < 5){
                    Userpassword.setError("Password length must be equal or greater than 5 characters");
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Registration.this, "Created successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Payment.class));
                        }
                        else{
                            Toast.makeText(Registration.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}