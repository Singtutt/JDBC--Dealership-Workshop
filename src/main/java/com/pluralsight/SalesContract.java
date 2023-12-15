package com.pluralsight;

import static com.pluralsight.UserInterface.df;

public class SalesContract extends Contract{
    double salesTax, recordingFee = 100, processingFee = 295;
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

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}
