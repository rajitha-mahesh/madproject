package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button changeToCardPay;
    private Button changeToBankTransfer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Button changeToCardPay =  findViewById(R.id.cardbtn);
        changeToCardPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                open_activity_enter_cd();
            }
        });

    }*/
   /* public void open_activity_enter_cd(){
        Intent intent = new Intent(this, EnterCardDetails.class);
        startActivity(intent);
    }
*/

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
}