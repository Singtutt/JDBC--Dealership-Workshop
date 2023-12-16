package com.pluralsight.dealership.contract;

import com.pluralsight.dealership.model.Vehicle;

import static com.pluralsight.dealership.app.ui.UserInterface.df;

public class LeaseContract extends Contract {
    double expectedEndValue, leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold) {
        super(date, name, email, vehicleSold);
        this.expectedEndValue = vehicleSold.price() * .5;
        this.leaseFee = vehicleSold.price() * .07;
    }

    @Override
    public double getTotalPrice(){
        return Double.parseDouble(df.format(expectedEndValue + leaseFee));
    }

    @Override
    public double getMonthlyPayment(){
        return Double.parseDouble(df.format((getTotalPrice() * 1.04) / 36));
    }
}