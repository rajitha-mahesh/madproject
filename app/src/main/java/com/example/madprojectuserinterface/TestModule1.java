package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class TestModule1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module1);


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem)

                switch (item.getItemId()) {
                    case R.id.nav_in_module;
                    startActivity(new Intent(getApplicationContext(), InModule.class));
                    break;


                }

                return true;
    }


}