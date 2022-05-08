package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddSubjects extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText subject1,subject2,subject3,subject4;
    int maxid = 0;
    SubjectPay subjectPay;
    Button paysub;
    Button cansel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subjects);

        subject1 = findViewById(R.id.et_subject1);
        subject2 = findViewById(R.id.et_subject2);
        subject3 = findViewById(R.id.et_subject3);
        subject4 = findViewById(R.id.et_subject4);
        paysub = findViewById(R.id.paysub);
        cansel = findViewById(R.id.cansel);

        subjectPay = new SubjectPay();
        ref = database.getInstance().getReference().child("user");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (int) snapshot.getChildrenCount();
                }else{
                    ///////////
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        paysub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                subjectPay.setSubject1(subject1.getText().toString());
                subjectPay.setSubject2(subject2.getText().toString());
                subjectPay.setSubject3(subject3.getText().toString());
                subjectPay.setSubject4(subject4.getText().toString());

                ref.child(string.valueOf(maxid+1)).setValue (subjectPay);
            }
        });

    }
}