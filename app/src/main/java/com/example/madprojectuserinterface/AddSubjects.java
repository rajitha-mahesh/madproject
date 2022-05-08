package com.example.madprojectuserinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

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

        ref addValueeventlistener(new.valueeventlistener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                if (dataSnapshot.exists()){
                    maxid = (int) dataSnapshot.getChildrenCount();
                }else{
                    ///////////
                }
            }

            @Override
                    public void onCancelled(@NonNull DatabaseError databaseError){

            }
        });
        paysub.setOnClickListener(new view.OnClickListener (){
            @Override
            public void onClick(View view){

                subjectPay.setSubject1(subject1.getText().toString());
                subjectPay.setSubject2(subject2.getText().toString());
                subjectPay.setSubject3(subject3.getText().toString());
                subjectPay.setSubject4(subject4.getText().toString());

                ref.child(string.valueOf(maxid+1)).setValue (subjectPay);
            }

        });
    }
}