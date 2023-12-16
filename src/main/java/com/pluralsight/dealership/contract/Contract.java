package com.pluralsight.dealership.contract;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Contract {
    public static ArrayList<Contract> contractList = new ArrayList<>();
    private int saleId;
    private String date, name, email, vehicleVIN;
    private double totalPrice, monthlyPrice;

    public Contract(int saleId, String date, String name, String email, String vehicleVIN, double totalPrice, double monthlyPrice) {
        this.saleId = saleId;
        this.date = formatDate(new Date());
        this.name = name;
        this.email = email;
        this.vehicleVIN = vehicleVIN;
        this.totalPrice = totalPrice;
        this.monthlyPrice = monthlyPrice;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public int getSaleId() {
        return saleId;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getVehicleVIN() {
        return vehicleVIN;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
