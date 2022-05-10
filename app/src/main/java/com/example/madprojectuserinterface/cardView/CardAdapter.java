package com.example.madprojectuserinterface.cardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.madprojectuserinterface.R;
import com.example.madprojectuserinterface.models.Payment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.PaymentHolder2> {

    //CardAdapter Class
    private Context context2;
    private List<?> paymentList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //Constructor

    public CardAdapter(Context context2, List<?> paymentList) {
        this.context2 = context2;
        this.paymentList = paymentList;
    }

    @NonNull
    @Override
    public PaymentHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context2).inflate(R.layout.item_card,parent, false);
       return new PaymentHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentHolder2 holder, int position) {
        Payment payment = (Payment) paymentList.get(position);


        DocumentReference documentReference = db.collection("payment").document(payment.getId());
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Payment data = new Payment(
                        documentSnapshot.getString("id"),
                        documentSnapshot.getString("userId"),
                        documentSnapshot.getString("paymentMethod"),
                        documentSnapshot.getString("stream"),
                        documentSnapshot.getString("subject"),
                        documentSnapshot.getString("methodNumber"),
                        documentSnapshot.getString("holderName"),
                        documentSnapshot.getLong("totalAmount"),
                        documentSnapshot.getDate("paymentDate")
                );

                @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                holder.txtModuleCard.setText(data.getStream() + " - " + data.getSubject());
                holder.txtFeeCard.setText(data.getTotalAmount() + " LKR");
                holder.txtDateCard.setText(dateFormat.format(data.getPaymentDate()));
                holder.txtStudentName.setText(data.getHolderName());

            }
        });


    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }


    //View Holder : PlanetHolder2

    class PaymentHolder2 extends RecyclerView.ViewHolder{
        TextView txtModuleCard, txtFeeCard, txtDateCard, txtStudentName;



        public PaymentHolder2(View itemView){
            super(itemView);
            txtModuleCard = itemView.findViewById(R.id.txtModuleCard);
            txtFeeCard = itemView.findViewById(R.id.txtFeeCard);
            txtDateCard = itemView.findViewById(R.id.txtDateCard);
            txtStudentName = itemView.findViewById(R.id.txtTeacherNameCard);

        }

        void setDetails(PaymentCards payment){
            txtModuleCard.setText(payment.getModuleName());
            txtFeeCard.setText(String.format(Locale.US,
                    "Fee :Rs. %d ",payment.getFee()));
            txtDateCard.setText(String.format(Locale.US,
                    "Month %d",payment.getDate()));
            txtStudentName.setText(String.format(Locale.US,
                    "Name : %d ",payment.getStudent_name()));
        }

    }



}
