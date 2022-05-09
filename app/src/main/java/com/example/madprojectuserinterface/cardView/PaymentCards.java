package com.example.madprojectuserinterface.cardView;

public class PaymentCards {

    //model class
    private String ModuleName;
    private int Fee;
    private String Date;
    private String Student_name;

    //constructor


    public PaymentCards(String moduleName, int fee, String date, String student_name) {
        ModuleName = moduleName;
        Fee = fee;
        Date = date;
        Student_name = student_name;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public int getFee() {
        return Fee;
    }

    public String getDate() {
        return Date;
    }

    public String getStudent_name() {
        return Student_name;
    }
}