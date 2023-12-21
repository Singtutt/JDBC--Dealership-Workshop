package com.pluralsight.dealership.model.contract;

import java.sql.*;

public class SalesContract extends BaseContract {
    double salesTax, recordingFee = 100, processingFee = 295;
    boolean isFinanced;

    public SalesContract(int id, Timestamp date, String name, String email, String vin, double totalPrice, double monthlyPrice, boolean isFinanced) {
        super(id, date, name, email, vin, totalPrice, monthlyPrice);
        this.salesTax = totalPrice * .05;
        this.isFinanced = isFinanced;
        if(totalPrice > 10000){
            this.processingFee = 495;
        }
    }

    public String getDateFormat() {
        return formatD(date);
    }
    public boolean isFinanced() {
        return isFinanced;
    }
    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice(){
        return Double.parseDouble(decimalF.format((this.totalPrice + salesTax + recordingFee + processingFee)));
    }
    @Override
    public double getMonthlyPrice(){
        double monthlyPayment = 0;
        if(isFinanced){
            if(getTotalPrice() > 10000){
                monthlyPayment = (getTotalPrice() * 1.0425) / 48;
            }
            else{
                monthlyPayment = (getTotalPrice() * 1.0525) / 24;
            }
        }
        return Double.parseDouble(decimalF.format(monthlyPayment));
    }
}
