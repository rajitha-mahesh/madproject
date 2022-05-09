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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class EnterCardDetails extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_card_details);

//        getAllPayments();
//        Button registerButton = (Button) findViewById(R.id.paycd);
//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText paymentMethod = (EditText) findViewById(R.id.paymentMethod);
//                EditText cardNo = (EditText) findViewById(R.id.cardno);
//                EditText holderName = (EditText) findViewById(R.id.cdholdername);
//                EditText totalAmount = (EditText) findViewById(R.id.amount);
//                if (TextUtils.isEmpty(paymentMethod.getText().toString())) {
//                    Toast.makeText(EnterCardDetails.this, "Payment Method cannot be empty", Toast.LENGTH_SHORT).show();
//                } else if (TextUtils.isEmpty(cardNo.getText().toString())) {
//                    Toast.makeText(EnterCardDetails.this, "Card Number cannot be empty", Toast.LENGTH_SHORT).show();
//                } else if (TextUtils.isEmpty(holderName.getText().toString())) {
//                    Toast.makeText(EnterCardDetails.this, "Holder Name cannot be empty", Toast.LENGTH_SHORT).show();
//                } else if (TextUtils.isEmpty(totalAmount.getText().toString())) {
//                    Toast.makeText(EnterCardDetails.this, "Total Amount cannot be empty", Toast.LENGTH_SHORT).show();
//                } else {
//                    Payment payment = new Payment();
//                    payment.setPaymentMethod(paymentMethod.getText().toString());
//                    payment.setMethodNumber(cardNo.getText().toString());
//                    payment.setHolderName(holderName.getText().toString());
//                    payment.setTotalAmount(totalAmount);
//                    DocumentReference documentReference = db.collection("payment").document(payment.getId());
//                    documentReference.set(payment)
//                            .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Toast.makeText(EnterCardDetails.this, "Reservation Saved Successfully!",
//                                            Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(EnterCardDetails.this, Payment.class));
//                                }
//                            })
//
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(FoodResDetails.this, "Reservation Saved Failed!",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                }
//            }
//        });

    }

    private void getAllPayments() {
        db.collection("payment")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        List<Payment> customCards = new ArrayList<>();
                        for (QueryDocumentSnapshot vehicle : value) {
                            Payment vehicleObj = new Payment(
                                    vehicle.getString("id"),
                                    vehicle.getString("paymentMethod"),
                                    vehicle.getString("methodNumber"),
                                    vehicle.getString("holderName"),
                                    vehicle.getString("totalAmount")
                            );
                            customCards.add(vehicleObj);
                        }
                    }
                });
    }




    public void cardPay(View view) {
        Intent i = new Intent(getApplicationContext(), InModule.class);
        startActivity(i);
    }








    /*
    private void enterTD(String cd_no, String cd_holder_name, String cvv) {

        auth.signInWithEmailAndPassword(cd_no,cd_holder_name,cvv).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Login.this, "Paid successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "Paid error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    */
}