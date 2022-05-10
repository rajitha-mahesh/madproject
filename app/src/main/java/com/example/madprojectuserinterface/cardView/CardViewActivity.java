package com.example.madprojectuserinterface.cardView;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madprojectuserinterface.R;
import com.example.madprojectuserinterface.models.Payment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<PaymentCards> paymentCardsArrayList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        recyclerView = findViewById(R.id.recyclerViewCard);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    private void InitializeCardView(){

        paymentCardsArrayList = new ArrayList<>();

        adapter = new CardAdapter(this, paymentCardsArrayList);
        recyclerView.setAdapter(adapter);

//        CreateDataForCards();

    }

    @Override
    protected void onStart() {
        super.onStart();
        getUserPayment(mAuth.getCurrentUser().getUid());
    }
    //user data retrieve (crud)
    private void getUserPayment(String currentUser) {
        //access database to payment
        db.collection("payment")
                .whereEqualTo("userId", currentUser)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        List<Payment> resCardList = new ArrayList<>();
                        for (QueryDocumentSnapshot payment : value) {
                            System.out.println("-------------------------------------- " + payment.getString("paymentMethod"));
                            Payment paymentobj = new Payment(
                                    payment.getString("id"),
                                    payment.getString("userId"),
                                    payment.getString("paymentMethod"),
                                    payment.getString("stream"),
                                    payment.getString("subject"),
                                    payment.getString("methodNumber"),
                                    payment.getString("holderName"),
                                    payment.getLong("totalAmount"),
                                    payment.getDate("paymentDate")

                            );
                            resCardList.add(paymentobj);
                        }
                        CardAdapter adapter = new CardAdapter(CardViewActivity.this, resCardList);
                        recyclerView.setAdapter(adapter);
                    }
                });

    }

}