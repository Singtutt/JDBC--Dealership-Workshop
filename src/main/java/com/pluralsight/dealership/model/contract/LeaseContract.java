package com.pluralsight.dealership.model.contract;

import java.text.DecimalFormat;
import java.util.Date;

public class LeaseContract {
    private int leaseID;
    private String name, email, vin;
    private double totalPrice, monthlyPrice, expectedEndValue, leaseFee;
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public LeaseContract(int leaseID, Date date, String name, String email, String vin, double totalPrice, double monthlyPrice) {
        this.leaseID = leaseID;
        this.name = name;
        this.email = email;
        this.vin = vin;
        this.totalPrice = totalPrice;
        this.monthlyPrice = monthlyPrice;
        this.expectedEndValue = totalPrice * 0.5;
        this.leaseFee = totalPrice * 0.07;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getTotalPrice() {
        return Double.parseDouble(df.format(expectedEndValue + leaseFee));
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMonthlyPrice() {
        return Double.parseDouble(df.format((getTotalPrice() * 1.04) / 36));
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }
}
//    public double getExpectedEndValue() {
//        return expectedEndValue;
//    }
//
//    public void setExpectedEndValue(double expectedEndValue) {
//        this.expectedEndValue = expectedEndValue;
//    }
//
//    public double getLeaseFee() {
//        return leaseFee;
//    }
//
//    public void setLeaseFee(double leaseFee) {
//        this.leaseFee = leaseFee;
//    }
//        this.expectedEndValue = vehicleSold.price() * .5;
//        this.leaseFee = vehicleSold.price() * .07;
//    @Override
//    public double getTotalPrice(){
//        return Double.parseDouble(df.format(expectedEndValue + leaseFee));
//    }
//
//    @Override
//    public double getMonthlyPayment(){
//        return Double.parseDouble(df.format((getTotalPrice() * 1.04) / 36));
//    }