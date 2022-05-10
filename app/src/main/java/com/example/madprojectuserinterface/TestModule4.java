package com.example.madprojectuserinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestModule4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module4);
    }

    public void selectedSinhala(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "ARTS");
                        intent.putExtra("subject", "Sinhala");
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

    public void selectedGeography(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "ARTS");
                        intent.putExtra("subject", "Geography");
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

    public void selectedPolitics(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "ARTS");
                        intent.putExtra("subject", "Politics");
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

    public void selectedLogic(View view) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(getApplicationContext(), PaymentType.class);
                        intent.putExtra("stream", "ARTS");
                        intent.putExtra("subject", "Logic");
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