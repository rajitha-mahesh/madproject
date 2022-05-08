package com.example.madprojectuserinterface.cardView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.madprojectuserinterface.R;

import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.PaymentHolder2> {

    //CardAdapter Class
    private Context context2;
    private ArrayList<PaymentCards> payments;


    //Constructor

    public CardAdapter(Context context2, ArrayList<PaymentCards> payments) {
        this.context2 = context2;
        this.payments = payments;
    }

    @NonNull
    @Override
    public PaymentHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context2).inflate(R.layout.item_card,parent, false);
       return new PaymentHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentHolder2 holder, int position) {
        PaymentCards payment = payments.get(position);
        holder.setDetails(payment);

    }

    @Override
    public int getItemCount() {
        return payments.size();
    }


    //View Holder : PlanetHolder2

    class PaymentHolder2 extends RecyclerView.ViewHolder{
        private TextView txtModuleCard, txtFeeCard, txtDateCard, txtTeacherNameCard;



        PaymentHolder2(View itemView){
            super(itemView);
            txtModuleCard = itemView.findViewById(R.id.txtModuleCard);
            txtFeeCard = itemView.findViewById(R.id.txtFeeCard);
            txtDateCard = itemView.findViewById(R.id.txtDateCard);
            txtTeacherNameCard = itemView.findViewById(R.id.txtTeacherNameCard);

        }

        void setDetails(PaymentCards payment){
            txtModuleCard.setText(payment.getModuleName());
            txtFeeCard.setText(String.format(Locale.US,
                    "Fee :Rs. %d ",payment.getFee()));
            txtDateCard.setText(String.format(Locale.US,
                    "Month %d",payment.getDate()));
            txtTeacherNameCard.setText(String.format(Locale.US,
                    "Name : %d ",payment.getTeacher_name()));
        }

    }



}
