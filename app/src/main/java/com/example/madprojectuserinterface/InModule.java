package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InModule extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_module);


     /*  backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.onClickListner() {
            @Override
            public void onClick(View view) {
                InModule.super.onBackPressed();
            }
        }); */
    }
}