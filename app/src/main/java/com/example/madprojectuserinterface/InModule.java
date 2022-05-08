package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InModule extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_module);

        Button button = findViewById(R.id.measurment_btn);

     /*  backBtn = findViewById(R.id.back_pressed);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InModule.this, PdfActivity.class);
                startActivity(intent);
            }
        });

       /* //Hooks
        backBtn = findViewById(R.id.back_pressed);
         backBtn.setOnClickListener(new View.onClickListner() {
            @Override
            public void onClick(View view) {
                InModule.super.onBackPressed();
            }
        }); */
    }
}