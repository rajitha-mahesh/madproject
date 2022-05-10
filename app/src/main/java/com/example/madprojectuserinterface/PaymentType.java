package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentType extends AppCompatActivity {

    private Button changeToCardPay;
    private Button changeToBankTransfer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_type);


        changeToCardPay = findViewById(R.id.cardbtn);
        changeToBankTransfer = findViewById(R.id.banktransferbtn);

        changeToCardPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentType.this, EnterCardDetails.class);
                System.out.println("----------------------------------- stream : " + getIntent().getStringExtra("stream"));
                System.out.println("----------------------------------- subject : " + getIntent().getStringExtra("subject"));
                //get details from previous activity
                intent.putExtra("stream", getIntent().getStringExtra("stream"));
                intent.putExtra("subject", getIntent().getStringExtra("subject"));
                intent.putExtra("paymentMethod", "Card");
                startActivity(intent);
            }
        });

        changeToBankTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentType.this, EnterTransferDetaill.class);
                startActivity(intent);
            }
        });

    }

    public void selectedBankTransfer(View view) {
        Intent i = new Intent(getApplicationContext(), EnterTransferDetaill.class);
        startActivity(i);
    }

}
