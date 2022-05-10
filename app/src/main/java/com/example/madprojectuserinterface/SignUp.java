package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madprojectuserinterface.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {

    private Button register;
    private TextView txtSignIn;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        register = findViewById(R.id.sign_up);
        txtSignIn = findViewById(R.id.txt_login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById(R.id.email);
                EditText phoneNumber = (EditText) findViewById(R.id.phone_number);
                EditText age = (EditText) findViewById(R.id.age);
                EditText gender = (EditText) findViewById(R.id.gender);
                EditText password = (EditText) findViewById(R.id.password);
                EditText confirmPassword = (EditText) findViewById(R.id.confirm_password);

                if (TextUtils.isEmpty(name.getText().toString())) {
                    Toast.makeText(SignUp.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(SignUp.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }  else if (TextUtils.isEmpty(phoneNumber.getText().toString())) {
                    Toast.makeText(SignUp.this, "Mobile number cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(age.getText().toString())) {
                    Toast.makeText(SignUp.this, "Age cannot be empty", Toast.LENGTH_SHORT).show();
                }  else if (TextUtils.isEmpty(gender.getText().toString())) {
                    Toast.makeText(SignUp.this, "Gender cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(SignUp.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(confirmPassword.getText().toString())) {
                    Toast.makeText(SignUp.this, "Confirm password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                    Toast.makeText(SignUp.this, "Password didn't match.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    signUpUser(email.getText().toString(), password.getText().toString());
                }
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    private void signUpUser(String txt_email, String txt_password) {

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(txt_email, txt_password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(SignUp.this, "Authentication Success.",
                            Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(SignUp.this, MainHome.class));
//                    finish();
                    saveUserDetails(txt_email, mAuth.getCurrentUser().getUid());
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(SignUp.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void saveUserDetails(String email, String userId) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText phoneNumber = (EditText) findViewById(R.id.phone_number);
        EditText age = (EditText) findViewById(R.id.age);
        EditText gender = (EditText) findViewById(R.id.gender);

        User user = new User();
        user.setId(userId);
        user.setName(name.getText().toString());
        user.setPhoneNumber(phoneNumber.getText().toString());
        user.setAge(age.getText().toString());
        user.setGender(gender.getText().toString());
        user.setEmail(email.trim());
        user.setMaths(false);
        user.setPhysics(false);

        DocumentReference documentReference = db.collection("users").document(userId);

        documentReference.set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        startActivity(new Intent(getApplicationContext(), MainHome.class));
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUp.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}