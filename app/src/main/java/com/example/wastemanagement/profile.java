package com.example.wastemanagement;

import org.jetbrains.annotations.Contract;

public class profile {
    String name,email,phone,pass,address;


    public profile(String name, String email, String phone, String pass, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.address = address;
    }

    public profile()
    {

    }

    public String getName() {
        return name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
