package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private View app_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        app_logo = findViewById(R.id.app_logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onStartFun();
            }
        }, 3000);
    }

    protected void onStartFun(){
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        Intent intent;
        if (user == null){
            intent = new Intent(getApplicationContext(), Login.class);
        }
        else{
            intent = new Intent(getApplicationContext(), MainHome.class);
        }
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,
                Pair.create(app_logo, "logo"),
                Pair.create(app_logo, "logo_text"));
        startActivity(intent, options.toBundle());
    }
}