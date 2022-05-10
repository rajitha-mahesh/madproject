package com.example.madprojectuserinterface.models;


import com.google.firebase.firestore.Exclude;

import java.util.Date;


//user model
public class User {

    @Exclude
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String age;
    private boolean isMaths = false;
    private boolean isPhysics = false;


    public User() {

    }

    public User(String id, String name, String email, String phoneNumber, String gender, String age, boolean isMaths, boolean isPhysics) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.isMaths = isMaths;
        this.isPhysics = isPhysics;
    }

    public boolean isMaths() {
        return isMaths;
    }

    public void setMaths(boolean maths) {
        isMaths = maths;
    }

    public boolean isPhysics() {
        return isPhysics;
    }

    public void setPhysics(boolean physics) {
        isPhysics = physics;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
