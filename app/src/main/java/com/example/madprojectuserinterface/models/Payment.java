package com.example.madprojectuserinterface.models;

import android.widget.EditText;

public class Payment {

    private String id;
    private String paymentMethod;
    private String methodNumber;
    private String holderName;
    private int totalAmount;

    public Payment(String id, String paymentMethod, String methodNumber, String holderName, String totalAmount) {
    }

    public Payment(String id, String paymentMethod, String methodNumber, String holderName, int totalAmount) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.methodNumber = methodNumber;
        this.holderName = holderName;
        this.totalAmount = totalAmount;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getMethodNumber() {
        return methodNumber;
    }

    public void setMethodNumber(String methodNumber) {
        this.methodNumber = methodNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
