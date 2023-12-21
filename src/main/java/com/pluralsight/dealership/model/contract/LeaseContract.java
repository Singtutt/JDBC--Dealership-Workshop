package com.pluralsight.dealership.model.contract;

import java.sql.Date;

public class LeaseContract extends BaseContract {
    private double expectedEndValue, leaseFee;

    public LeaseContract(int id, Date date, String name, String email, String vin, double totalPrice, double monthlyPrice) {
        super(id, date, name, email, vin, totalPrice, monthlyPrice);
        this.expectedEndValue = totalPrice * 0.5;
        this.leaseFee = totalPrice * 0.07;
    }

    public double getExpectedEndValue() {
        return expectedEndValue;
    }

    public void setExpectedEndValue(double expectedEndValue) {
        this.expectedEndValue = expectedEndValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getMonthlyPrice() {
        return Double.parseDouble(df.format((getTotalPrice() * 1.04) / 36));
    }
    @Override
    public double getTotalPrice() {
        return Double.parseDouble(df.format(expectedEndValue + leaseFee));
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