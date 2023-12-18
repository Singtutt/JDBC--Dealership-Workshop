package com.pluralsight.dealership.model.contract;

import java.sql.Date;
import java.text.SimpleDateFormat;

public abstract class baseContract {
    private int id;
    private Date date;
    private String name, email, vehicleVIN;
    private double totalPrice, monthlyPrice;

    public baseContract(int id, Date date, String name, String email, String vin, double totalPrice, double monthlyPrice) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicleVIN = vin;
        this.totalPrice = totalPrice;
        this.monthlyPrice = monthlyPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getVehicleVIN() {
        return vehicleVIN;
    }

    public void setVehicleVIN(String vehicleVIN) {
        this.vehicleVIN = vehicleVIN;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public String formatDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
