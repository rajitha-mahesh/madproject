package com.example.madprojectuserinterface.cardView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.madprojectuserinterface.R;

import java.util.ArrayList;

public class CardViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<PaymentCards> paymentCardsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);


        InitializeCardView();

    }
    private void InitializeCardView(){
        recyclerView = findViewById(R.id.recyclerViewCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        paymentCardsArrayList = new ArrayList<>();

        adapter = new CardAdapter(this, paymentCardsArrayList);
        recyclerView.setAdapter(adapter);

        CreateDataForCards();

    }

    private void CreateDataForCards(){
        //this method is for adding the data to recyclerView
        //let's make adapter and planet model class

        PaymentCards payment = new PaymentCards("Chemistry",1700,"12","namila");

        //adding some other info
        payment = new PaymentCards("Chemistry",1700,"04","namila");
        paymentCardsArrayList.add(payment);
        payment = new PaymentCards("Mathematics",1500,"04","rajitha");
        paymentCardsArrayList.add(payment);
        payment = new PaymentCards("Biology",2100,"05","raj");
        paymentCardsArrayList.add(payment);
        payment = new PaymentCards("Physics",1800,"06","pasi");
        paymentCardsArrayList.add(payment);

        adapter.notifyDataSetChanged();

    }
}