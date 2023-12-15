package com.pluralsight;

import static com.pluralsight.UserInterface.df;

public class LeaseContract extends Contract{
    double expectedEndValue, leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold) {
        super(date, name, email, vehicleSold);
        this.expectedEndValue = vehicleSold.getPrice() * .5;
        this.leaseFee = vehicleSold.getPrice() * .07;
    }

    @Override
    public double getTotalPrice(){
        return Double.parseDouble(df.format(expectedEndValue + leaseFee));
    }

    @Override
    public double getMonthlyPayment(){
        return Double.parseDouble(df.format((getTotalPrice() * 1.04) / 36));
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
}