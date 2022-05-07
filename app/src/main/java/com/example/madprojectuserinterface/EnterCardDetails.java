package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnterCardDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_card_details);


    }

    public void cardPay(View view) {
        Intent i = new Intent(getApplicationContext(), InModule.class);
        startActivity(i);
    }
}