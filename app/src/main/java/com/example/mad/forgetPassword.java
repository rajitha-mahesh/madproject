package com.example.mad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgetPassword extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foget_password);

        passwordEmail = (EditText) findViewById(R.id.etPasswordEmail);
        resetPassword = (Button) findViewById(R.id.btnPasswordReset);
        firebaseAuth = FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = passwordEmail.getText().toString().trim();
                if(useremail.equals("")){
                    Toast.makeText(forgetPassword.this,"please enter your registered email ID", Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListner(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task){
                                if (task.isSuccssful()){
                                    Toast.makeText(forgetPassword.this, "password reset email sent!", Toast.LENGTH_SHORT).show();
                                    finish();
                                    startActivity(new Intent(forgetPassword.this, MainActivity.class));
                                }else{
                                    Toast.makeText(forgetPassword.this, "Error in sending password reset email", Toast.LENGTH_SHORT).show();

                                }

                            }

                    });
                }

            }

        });
    }

}