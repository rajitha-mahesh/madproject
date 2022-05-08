package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
    }

    public void selectedStream(View view) {
        Intent i = new Intent(getApplicationContext(), Stream.class);
        startActivity(i);
    }

    public void selectedBio(View view) {
    }

    public void selectedFavourites(View view) {
    }

    public void selectedPayments(View view) {
    }

    public void selectedCommerce(View view) {
    }

    public void goToProfile(View view) {
        startActivity(new Intent(getApplicationContext(), UserProfile.class));
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}