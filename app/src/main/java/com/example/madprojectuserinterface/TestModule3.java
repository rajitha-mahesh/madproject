package com.example.madprojectuserinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestModule3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module3);
    }

    public void selectedEcon(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "COMMERCE");
                        intent.putExtra("subject", "Econ");
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

    public void selectedAccounting(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "COMMERCE");
                        intent.putExtra("subject", "Accounting");
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

    public void selectedBS(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "COMMERCE");
                        intent.putExtra("subject", "Business Studies");
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

    public void selectedIT(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "COMMERCE");
                        intent.putExtra("subject", "Information Technology");
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