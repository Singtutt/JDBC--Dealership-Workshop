package com.pluralsight.dealership.model.contract;

import java.sql.*;

public class SalesContract extends BaseContract {
    double salesTax, recordingFee = 100, processingFee = 295;
    boolean isFinanced;

    public SalesContract(int id, Date date, String name, String email, String vin, double totalPrice, double monthlyPrice, boolean isFinanced) {
        super(id, date, name, email, vin, totalPrice, monthlyPrice);
        this.salesTax = totalPrice * .05;
        this.isFinanced = isFinanced;
        if(totalPrice > 10000){
            this.processingFee = 495;
        }
    }

    @Override
    public double getTotalPrice(){
        return Double.parseDouble(df.format((this.totalPrice + salesTax + recordingFee + processingFee)));
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




//    private void fetchDBCost(String vehicleVIN) {
//        try {
//            this.vehicleCost = SalesContractDAO.fetchVehicleCost(vehicleVIN);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private void calculateFees() {
//        this.salesTax = vehicleCost * .05;
//        this.recordingFee = 100;
//        if (vehicleCost > 10000) {
//            this.processingFee = 495;
//        }
//    }
//            String query = """(Connection connection = DataConnect.getConnection())
//                    SELECT Price
//                    FROM Vehicles
//                    WHERE VIN = ?""";
//            try (PreparedStatement prep = connection.prepareStatement(query)) {
//                prep.setString(1, vehicleVIN);
//                try (ResultSet rs = prep.executeQuery()) {
//                    if (rs.next()) {
//                        vehicleCost = rs.getDouble("Price");
//                    }
//                }
//            }