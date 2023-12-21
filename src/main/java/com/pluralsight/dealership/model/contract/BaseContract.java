package com.pluralsight.dealership.model.contract;

import java.sql.Date;
import java.text.DecimalFormat;

public abstract class BaseContract {
    protected int id;
    protected Date date;
    protected String name, email, vehicleVIN;
    protected double totalPrice, monthlyPrice;
    protected static final DecimalFormat df = new DecimalFormat("#.##");

    public BaseContract(int id, Date date, String name, String email, String vin, double totalPrice, double monthlyPrice) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Minor adjustment needed to format date.