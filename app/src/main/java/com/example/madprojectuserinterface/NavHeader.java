package com.example.madprojectuserinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class NavHeader extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header);
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
}