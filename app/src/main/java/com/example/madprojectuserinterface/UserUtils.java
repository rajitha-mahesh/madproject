package com.example.madprojectuserinterface;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.madprojectuserinterface.models.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserUtils {

    public FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public FirebaseFirestore db = FirebaseFirestore.getInstance();
    private User currentUser;

    public void getAuthUser(){
        String userId= mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = new User();
                user.setId(userId);
                user.setName(documentSnapshot.getString("name"));
                user.setEmail(documentSnapshot.getString("email"));
                user.setAge(documentSnapshot.getString("age"));
                user.setGender(documentSnapshot.getString("gender"));
                user.setPhoneNumber(documentSnapshot.getString("phoneNumber"));
                user.setMaths(documentSnapshot.getBoolean("isMaths"));
                user.setPhysics(documentSnapshot.getBoolean("isPhysics"));
                setCurrentUser(user);
            }
        });
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


}