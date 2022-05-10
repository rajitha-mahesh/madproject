package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.madprojectuserinterface.models.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserUpdate extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    User authUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAuthUser();
    }

    //Get user details for the db
    private void getAuthUser() {
        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = new User();
                user.setId(userId);
                user.setName(documentSnapshot.getString("name"));
                user.setPhoneNumber(documentSnapshot.getString("phoneNumber"));
                user.setEmail(documentSnapshot.getString("email"));
                user.setAge(documentSnapshot.getString("age"));
                user.setGender(documentSnapshot.getString("gender"));

                authUser = user;

                TextInputEditText fullNameTextField = (TextInputEditText) findViewById(R.id.full_name);
                fullNameTextField.setText(authUser.getName());

                TextInputEditText phoneNumberTextField = (TextInputEditText) findViewById(R.id.phone_number);
                phoneNumberTextField.setText(authUser.getPhoneNumber());

                TextInputEditText genderTextField = (TextInputEditText) findViewById(R.id.gender);
                genderTextField.setText(authUser.getGender());

                TextInputEditText age = (TextInputEditText) findViewById(R.id.age);
                age.setText(authUser.getAge());

            }
        });
    }

    //Update user validation
    public void updateProfile(View view) {
        TextInputEditText fullNameEditText = (TextInputEditText) findViewById(R.id.full_name);
        TextInputEditText mobileEditText = (TextInputEditText) findViewById(R.id.phone_number);
        TextInputEditText age = (TextInputEditText) findViewById(R.id.age);
        TextInputEditText gender = (TextInputEditText) findViewById(R.id.gender);

        //User update validate section - if some data is empty, a toast message is visible to the user
        if (TextUtils.isEmpty(fullNameEditText.getText().toString())) {
            Toast.makeText(UserUpdate.this, "First name cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(gender.getText().toString())) {
            Toast.makeText(UserUpdate.this, "Gender cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(age.getText().toString())) {
            Toast.makeText(UserUpdate.this, "Age cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mobileEditText.getText().toString())) {
            Toast.makeText(UserUpdate.this, "Mobile number cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            update();
        }

    }

    //Update user data
    private void update() {

        TextInputEditText fullNameEditText = (TextInputEditText) findViewById(R.id.full_name);
        TextInputEditText mobileEditText = (TextInputEditText) findViewById(R.id.phone_number);
        TextInputEditText gender = (TextInputEditText) findViewById(R.id.gender);
        TextInputEditText age = (TextInputEditText) findViewById(R.id.age);

        //assign the obejcts
        Map<String, Object> data = new HashMap<>();
        data.put("name", fullNameEditText.getText().toString());
        data.put("phoneNumber", mobileEditText.getText().toString());
        data.put("age", age.getText().toString());
        data.put("gender", gender.getText().toString());

        //make data reference after going to the collection
        String userId = mAuth.getCurrentUser().getUid();
        //store/update the database by the former document
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            //generate a toast message if update is succussful
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(UserUpdate.this, "Profile Details Updated Successfully!", Toast.LENGTH_SHORT).show();
                //back to the user profile
                startActivity(new Intent(getApplicationContext(), UserProfile.class));
            }
        });
    }


    //User Delete
    public void userDelete(View view) {
        //after sign out delete the user data
        db.collection("users")
                .document(authUser.getId())
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        //first the user get sign out from the account
                        mAuth.signOut();
                        if (user != null) user.delete();
                        //if delete is success a toast message is generated
                        Toast.makeText(UserUpdate.this, "Profile Details Deleted Successfully.", Toast.LENGTH_SHORT).show();
                        //then navigate into sign up page
                        startActivity(new Intent(getApplicationContext(), SignUp.class));
                    }
                });
    }
}