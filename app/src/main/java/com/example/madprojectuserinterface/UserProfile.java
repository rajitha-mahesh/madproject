package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfile extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
    }

    public void logOut(View view) {
        mAuth.signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
    }
    @Override
    protected void onStart() {
        super.onStart();
        getAuthUser();
    }

    //read user data from db
    private void getAuthUser(){
        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                TextView fullName = (TextView) findViewById(R.id.full_name);
                TextView email = (TextView) findViewById(R.id.email);
                TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
                TextView gender = (TextView) findViewById(R.id.gender);
                TextView age = (TextView) findViewById(R.id.age);

                fullName.setText(documentSnapshot.getString("name"));
                email.setText(documentSnapshot.getString("email"));
                age.setText(documentSnapshot.getString("age"));
                gender.setText(documentSnapshot.getString("gender"));
                phoneNumber.setText(documentSnapshot.getString("phoneNumber"));
            }
        });
    }

    public void editProfile(View view) {
        Intent i = new Intent(getApplicationContext(), UserUpdate.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainHome.class);
        startActivity(i);
    }
}