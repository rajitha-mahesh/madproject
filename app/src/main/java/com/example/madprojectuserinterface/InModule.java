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


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), TestModule1.class);
        startActivity(i);
    }

    public void selectTest(View view) {
        Intent i = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(i);
    }
}