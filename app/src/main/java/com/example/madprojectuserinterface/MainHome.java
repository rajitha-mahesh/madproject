package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainHome extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;


    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);


//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.navigationView);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.menu_open, R.string.menu_close);
//        drawerLayout.addDrawerListener(toggle);
//        actionBarDrawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()) {
//                    case R.id.nav_home:
//                        Log.i("MENU_DRAWER_TAG", "Home item is clicked");
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                    case R.id.nav_profile:
//                        Log.i("MENU_DRAWER_TAG", "profile item is clicked");
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                }
//
//                return true;
//            }
//        });





    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAuthUser();
    }

    private void getAuthUser(){
        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                TextView fullName = (TextView) findViewById(R.id.nav_full_name);
                TextView navMail = (TextView) findViewById(R.id.nav_mail);

                fullName.setText(documentSnapshot.getString("name"));
                navMail.setText(documentSnapshot.getString("email"));
            }
        });
    }

    public void selectedMaths(View view) {
        Intent i = new Intent(getApplicationContext(), TestModule1.class);
        startActivity(i);
    }

    public void selectPassPapers(View view) {
        Intent i = new Intent(getApplicationContext(), PastPapers.class);
        startActivity(i);
    }

    public void selectedEBook(View view) {
        Intent i = new Intent(getApplicationContext(), EBooks.class);
        startActivity(i);
    }

}