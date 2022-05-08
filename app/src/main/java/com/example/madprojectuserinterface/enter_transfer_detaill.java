package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class enter_transfer_detaill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_transfer_detaill);
    }






/*
    private void enterTD(String acc_no, String name) {

        auth.signInWithEmailAndPassword(acc_no,name).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Login.this, "Paid successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "Paid error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    */

}