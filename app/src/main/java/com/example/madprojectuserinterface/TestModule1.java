package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.Collections;

public class TestModule1 extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module1);


    }

    public void selectedIT(View view) {

        System.out.println("-------------------------------------- " + mAuth.getCurrentUser().getUid());

        db.collection("payment")
                .whereEqualTo("userId", mAuth.getCurrentUser().getUid())
                .whereEqualTo("stream", "Mathematics")
                .whereEqualTo("subject", "Information Technology")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    System.out.println("--------------------------------------- " + "sucsess");
                } else {
                    System.out.println("--------------------------------------- " + "Faild");
                }
            }
        });

        db.collection("payment")
                .whereEqualTo("userId", mAuth.getCurrentUser().getUid())
                .whereEqualTo("stream", "Mathematics")
                .whereEqualTo("subject", "Information Technology")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                System.out.println("--------------------------------------- " + "sucsess");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("--------------------------------------- " + "Faild");
            }
        });


//        db.collection("payment")
//                .whereEqualTo("userId", mAuth.getCurrentUser().getUid())
//                .whereEqualTo("stream", "Mathematics")
//                .whereEqualTo("subject", "Information Technology")
//                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which) {
//                            case DialogInterface.BUTTON_POSITIVE:
//                                Intent intent = new Intent(getApplicationContext(), PaymentType.class);
//                                intent.putExtra("stream", "Mathematics");
//                                intent.putExtra("subject", "Information Technology");
//                                startActivity(intent);
//                                break;
//
//                            case DialogInterface.BUTTON_NEGATIVE:
//                                intent = new Intent(getApplicationContext(), Stream.class);
//                                startActivity(intent);
//                                break;
//                        }
//                    }
//                };
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
//                        .setNegativeButton("Cancel", dialogClickListener).show();
//            }
//
//        });


//        if (true){
//            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    switch (which){
//                        case DialogInterface.BUTTON_POSITIVE:
//                            Intent intent = new Intent(getApplicationContext(), PaymentType.class);
//                            intent.putExtra("stream", "Mathematics");
//                            intent.putExtra("subject", "Information Technology");
//                            startActivity(intent);
//                            break;
//
//                        case DialogInterface.BUTTON_NEGATIVE:
//                            intent = new Intent(getApplicationContext(), Stream.class);
//                            startActivity(intent);
//                            break;
//                    }
//                }
//            };
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//            builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
//                    .setNegativeButton("Cancel", dialogClickListener).show();
//        }else {
//            startActivity(new Intent(TestModule1.this, InModule.class));
//        }


    }

    public void selectedComMaths(View view) {

        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.getBoolean("isMaths")){
                    startActivity(new Intent(TestModule1.this, InModule.class));
                }else {
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                                    intent.putExtra("stream", "Mathematics");
                                    intent.putExtra("subject", "Combined Maths");
                                    startActivity(intent);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    intent = new Intent(getApplicationContext(), Stream.class);
                                    startActivity(intent);
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                            .setNegativeButton("Cancel", dialogClickListener).show();
                }
            }

        });


    }

    public void selectedPhy(View view) {

        String userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.getBoolean("isPhysics")){
                    startActivity(new Intent(TestModule1.this, InModule.class));
                }else {
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                                    intent.putExtra("stream", "Mathematics");
                                    intent.putExtra("subject", "Physics");
                                    startActivity(intent);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    intent = new Intent(getApplicationContext(), Stream.class);
                                    startActivity(intent);
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                            .setNegativeButton("Cancel", dialogClickListener).show();
                }
            }

        });
    }

    public void selectedChe(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "Mathematics");
                        intent.putExtra("subject", "Chemistry");
                        startActivity(intent);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        intent = new Intent(getApplicationContext(), Stream.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                .setNegativeButton("Cancel", dialogClickListener).show();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), Stream.class);
        startActivity(i);
    }
}