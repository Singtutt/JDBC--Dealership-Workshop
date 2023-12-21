package com.pluralsight.dealership.model.contract;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public abstract class BaseContract {
    protected int id;
    protected Timestamp date;
    protected String name, email, vehicleVIN;
    protected double totalPrice, monthlyPrice;
    protected static final DecimalFormat decimalF = new DecimalFormat("#.##");
    protected String formatD(Timestamp ts) {
        SimpleDateFormat dateF= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateF.format(ts);
    }

    public BaseContract(int id, Timestamp date, String name, String email, String vin, double totalPrice, double monthlyPrice) {
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPrice();
}
