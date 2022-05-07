package com.example.madprojectuserinterface.cardView;

public class PaymentCards {

    //model class
    private String ModuleName;
    private int Fee;
    private String Date;
    private String Teacher_name;

    //constructor


    public PaymentCards(String moduleName, int fee, String date, String teacher_name) {
        ModuleName = moduleName;
        Fee = fee;
        Date = date;
        Teacher_name = teacher_name;
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

    public String getTeacher_name() {
        return Teacher_name;
    }
}