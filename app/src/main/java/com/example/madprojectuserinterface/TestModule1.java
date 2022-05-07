package com.example.madprojectuserinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TestModule1 extends AppCompatActivity {

    private Button ShowDialog1;
    private Button ShowDialog2;
    private Button ShowDialog3;
    private Button ShowDialog4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module1);


//        ShowDialog1 = findViewById(R.id.com_mths_btn);
//        ShowDialog2 = findViewById(R.id.phy_btn);
//        ShowDialog3 = findViewById(R.id.chem_btn);
//        ShowDialog4 = findViewById(R.id.it_btn);







        //Create the Dialog here
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.activity_test_module1);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
//        }
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false); //Optional
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

//        Button pay = dialog.findViewById(R.id.btn_pay);
//        Button Cancel = dialog.findViewById(R.id.btn_cancel);

//        pay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(TestModule1.this, "pay", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });

//        Cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(TestModule1.this, "Cancel", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });


//        ShowDialog1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.show(); // Showing the dialog here
//            }
//        });
//
//        ShowDialog2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.show(); // Showing the dialog here
//            }
//        });
//
//        ShowDialog3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.show(); // Showing the dialog here
//            }
//        });
//
//        ShowDialog4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.show(); // Showing the dialog here
//            }
//        });

        
    }

    public void selectedIT(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(getApplicationContext(), PaymentType.class);
                        startActivity(i);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                .setNegativeButton("Cancel", dialogClickListener).show();

    }

    public void selectedComMaths(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(getApplicationContext(), PaymentType.class);
                        startActivity(i);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                .setNegativeButton("Cancel", dialogClickListener).show();
    }

    public void selectedPhy(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(getApplicationContext(), PaymentType.class);
                        startActivity(i);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                .setNegativeButton("Cancel", dialogClickListener).show();
    }

    public void selectedChe(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(getApplicationContext(), PaymentType.class);
                        startActivity(i);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Are You Sure To Follow the Module?").setPositiveButton("Pay", dialogClickListener)
                .setNegativeButton("Cancel", dialogClickListener).show();
    }
}