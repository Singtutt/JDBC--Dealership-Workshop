package com.pluralsight.dealership.model.contract;

import java.sql.Date;
import java.sql.Timestamp;

public class LeaseContract extends BaseContract {
    private double expectedEndValue, leaseFee;

    public LeaseContract(int id, Timestamp date, String name, String email, String vin, double totalPrice, double monthlyPrice) {
        super(id, date, name, email, vin, totalPrice, monthlyPrice);
        this.expectedEndValue = totalPrice * 0.5;
        this.leaseFee = totalPrice * 0.07;
    }

    public String getDateFormat() {
        return formatD(date);
    }

    @Override
    public double getMonthlyPrice() {
        return Double.parseDouble(decimalF.format((getTotalPrice() * 1.04) / 36));
    }
    @Override
    public double getTotalPrice() {
        return Double.parseDouble(decimalF.format(expectedEndValue + leaseFee));
    }
}
