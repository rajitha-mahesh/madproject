package com.example.madprojectuserinterface.cardView;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madprojectuserinterface.MainHome;
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
        getRoomReservation(mAuth.getCurrentUser().getUid());
    }
    private void getRoomReservation(String currentUser) {

        db.collection("payment")
                .whereEqualTo("userId", currentUser)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        List<Payment> resCardList = new ArrayList<>();
                        for (QueryDocumentSnapshot roomRes : value) {
                            System.out.println("-------------------------------------- " + roomRes.getString("paymentMethod"));
                            Payment hallObj = new Payment(
                                    roomRes.getString("id"),
                                    roomRes.getString("userId"),
                                    roomRes.getString("paymentMethod"),
                                    roomRes.getString("stream"),
                                    roomRes.getString("subject"),
                                    roomRes.getString("methodNumber"),
                                    roomRes.getString("holderName"),
                                    roomRes.getLong("totalAmount"),
                                    roomRes.getDate("paymentDate")

                            );
                            resCardList.add(hallObj);
                        }
                        CardAdapter adapter = new CardAdapter(CardViewActivity.this, resCardList);
                        recyclerView.setAdapter(adapter);
                    }
                });

    }

}