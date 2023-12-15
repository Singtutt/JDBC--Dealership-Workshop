package com.pluralsight.dealership;

import static com.pluralsight.dealership.UserInterface.df;

public class SalesContract extends Contract {
    double salesTax, recordingFee, processingFee = 295;
    boolean isFinanced;

    public SalesContract(String date, String name, String email, Vehicle vehicleSold, boolean isFinanced) {
        super(date, name, email, vehicleSold);
        this.salesTax = vehicleSold.getPrice() * .05;
        this.recordingFee = 100;
        this.isFinanced = isFinanced;
        if(vehicleSold.getPrice() > 10000){
            this.processingFee = 495;
        }
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice(){
        return Double.parseDouble(df.format((vehicleSold.getPrice() + salesTax + recordingFee + processingFee)));
    }

    @Override
    public double getMonthlyPayment(){
        double monthlyPayment = 0;
        if(isFinanced){
            if(getTotalPrice() > 10000){
                monthlyPayment = (getTotalPrice() * 1.0425) / 48;
            }
            else{
                monthlyPayment = (getTotalPrice() * 1.0525) / 24;
            }
        }
        return Double.parseDouble(df.format(monthlyPayment));
    }

}
