package com.example.foodsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class Login extends AppCompatActivity {

    TextView logintitle, newuser;
    EditText Login_Email, Login_Password;
    Button LoginBtn, CreateNew;
    FirebaseAuth mAuth;
    private static final String TAG = "My application";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logintitle = findViewById(R.id.LoginTitle);
        newuser = findViewById(R.id.Message);
        Login_Email = (EditText) findViewById(R.id.LoginEmail);
        Login_Password = findViewById(R.id.LoginPassword);
        LoginBtn = findViewById(R.id.LoginBtn);
        CreateNew = findViewById(R.id.CreateNew);

        mAuth = FirebaseAuth.getInstance();

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Login_Email.getText().toString().trim();
                String password = Login_Password.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful())
                        {
                            try {
                                throw task.getException();
                            }
                            catch (FirebaseAuthInvalidUserException wrong_email){
                                Log.d(TAG, "User does not exist. Please re-enter or create new one");
                            }
                            catch (FirebaseAuthInvalidCredentialsException wrong_password){
                                Log.d(TAG, "Password is wrong");
                            }
                            catch (Exception e) {
                                Log.d(TAG, "onComplete: " + e.getMessage());
                            }

                        }
                        else
                        {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                    }
                });
            }
        });
    }
    public void Register(View view){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}