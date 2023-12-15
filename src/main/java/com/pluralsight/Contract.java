package com.pluralsight;

import java.util.ArrayList;

public abstract class Contract {
    public static ArrayList<Contract> contractList = new ArrayList<Contract>();
    String date, name, email;
    Vehicle vehicleSold;
    double totalPrice, monthlyPayment;

    public Contract(String date, String name, String email, Vehicle vehicleSold) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public Vehicle getVehicleSold(){
        return vehicleSold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Vehicle isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
