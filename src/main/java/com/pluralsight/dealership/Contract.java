package com.pluralsight.dealership;

import java.util.ArrayList;

public abstract class Contract {
    public static ArrayList<Contract> contractList = new ArrayList<>();
    String date, name, email;
    Vehicle vehicleSold;

    public Contract(String date, String name, String email, Vehicle vehicleSold) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public Vehicle getVehicleSold(){
        return vehicleSold;
    }
}
