package com.example.madprojectuserinterface.models;

import android.widget.EditText;

import java.util.Date;
//model to access data to getters  and setters data
public class Payment {

    private String id;
    private String userId;
    private String paymentMethod;
    private String stream;
    private String subject;
    private String methodNumber;
    private String holderName;
    private long totalAmount;
    private Date paymentDate;

    public Payment() {
    }

    public Payment(String id, String userId, String paymentMethod, String stream, String subject, String methodNumber, String holderName, long totalAmount, Date paymentDate) {
        this.id = id;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.stream = stream;
        this.subject = subject;
        this.methodNumber = methodNumber;
        this.holderName = holderName;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
