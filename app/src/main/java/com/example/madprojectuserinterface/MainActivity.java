package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CardView adapter;

    String modules[]={"mathematics","physics","chemistry","Biology"};


    private Button changeToCardPay;
    private Button changeToBankTransfer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeToCardPay =  findViewById(R.id.cardbtn);
        changeToBankTransfer =  findViewById(R.id.banktransferbtn);

        changeToCardPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterCardDetails.class);
                startActivity(intent);
            }
        });

        changeToBankTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, enter_transfer_detaill.class);
                startActivity(intent);
            }
        });

    }


    }
