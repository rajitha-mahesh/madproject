package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EnterCardDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_card_details);
    }








    /*
    private void enterTD(String cd_no, String cd_holder_name, String cvv) {

        auth.signInWithEmailAndPassword(cd_no,cd_holder_name,cvv).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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