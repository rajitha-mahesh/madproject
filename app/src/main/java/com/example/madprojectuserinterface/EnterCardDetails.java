package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madprojectuserinterface.models.Payment;
import com.example.madprojectuserinterface.models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EnterCardDetails extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    UserUtils userUtils = new UserUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_card_details);

        Button registerButton = (Button) findViewById(R.id.paycd);

        //Payment Create
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cardNo = (EditText) findViewById(R.id.cardno);
                EditText holderName = (EditText) findViewById(R.id.cdholdername);
                EditText totalAmount = (EditText) findViewById(R.id.amount);
                EditText monthYear = (EditText) findViewById(R.id.month_year);
                EditText cvv = (EditText) findViewById(R.id.cvv);
                if (TextUtils.isEmpty(cardNo.getText().toString())) {
                    Toast.makeText(EnterCardDetails.this, "Card Number cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(holderName.getText().toString())) {
                    Toast.makeText(EnterCardDetails.this, "Holder Name cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(monthYear.getText().toString())) {
                    Toast.makeText(EnterCardDetails.this, "Expire date cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cvv.getText().toString())) {
                    Toast.makeText(EnterCardDetails.this, "CVV cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    //payment do part (in crud)
                    Payment payment = new Payment();
//                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date date = new Date();

                    payment.setId(UUID.randomUUID().toString());
                    payment.setStream(getIntent().getStringExtra("stream"));
                    payment.setSubject(getIntent().getStringExtra("subject"));
                    payment.setPaymentMethod(getIntent().getStringExtra("paymentMethod"));
                    payment.setUserId(mAuth.getCurrentUser().getUid());
                    payment.setMethodNumber(cardNo.getText().toString());
                    payment.setHolderName(holderName.getText().toString());
                    payment.setPaymentDate(date);
                    payment.setTotalAmount(2000);
                    DocumentReference documentReference = db.collection("payment").document(payment.getId());
                    documentReference.set(payment)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(EnterCardDetails.this, "Payment Successfully!",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(EnterCardDetails.this, InModule.class));
                                }
                            })

                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(EnterCardDetails.this, "Payment Failed!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //update user is maths and is physics


                    User currentUser = new User();
                    System.out.println("--------------------------------- "+ currentUser.isMaths());
                    Map<String, Object> data = new HashMap<>();
                    if (getIntent().getStringExtra("subject").equals("Combined Maths")){
                        currentUser.setMaths(true);
                        data.put("isMaths", currentUser.isMaths());
                    }else if (getIntent().getStringExtra("subject").equals("Physics")){
                        currentUser.setPhysics(true);
                        data.put("isPhysics", currentUser.isPhysics());
                    }


                    DocumentReference documentReference1 = db.collection("users").document(mAuth.getCurrentUser().getUid());
                    documentReference1.update(data);
                }
            }
        });

    }


    public void cardPay(View view) {
        Intent i = new Intent(getApplicationContext(), InModule.class);
        startActivity(i);
    }

}