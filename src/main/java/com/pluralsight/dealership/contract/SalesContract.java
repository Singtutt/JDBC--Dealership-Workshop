package com.pluralsight.dealership.contract;

import com.pluralsight.dealership.dao.connect.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class SalesContract extends Contract {
    private double salesTax, recordingFee, processingFee = 295;
    private boolean isFinanced, isSold;
    private static final DecimalFormat df = new DecimalFormat("#.##");
    private double vehicleCost;

    public SalesContract(int saleId, String date, String name, String email, String vehicleVIN, boolean isFinanced, boolean isSold, double vehicleCost) {
        super(saleId, date, name, email, vehicleVIN, 0, 0);
        this.isFinanced = isFinanced;
        this.isSold = isSold;
        this.vehicleCost = vehicleCost;
        fetchCost(vehicleVIN);
        calculations();
    }

    private void fetchCost(String vehicleVIN) {
        try (Connection connection = DataConnect.getConnection()) {
            String query = """
                    SELECT Price
                    FROM Vehicles
                    WHERE VIN = ?""";
            try (PreparedStatement prep = connection.prepareStatement(query)) {
                prep.setString(1, vehicleVIN);
                try (ResultSet rs = prep.executeQuery()) {
                    if (rs.next()) {
                        vehicleCost = rs.getDouble("Price");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void calculations() {
        this.salesTax = vehicleCost * .05;
        this.recordingFee = 100;
        if (vehicleCost > 10000) {
            this.processingFee = 495;
        }
    }
    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        this.isFinanced = financed;
    }
    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
    @Override
    public double getTotalPrice() {
        return Double.parseDouble(df.format((vehicleCost + salesTax + recordingFee + processingFee)));
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment = 0;
        if (isFinanced) {
            if (getTotalPrice() > 10000) {
                monthlyPayment = (getTotalPrice() * 1.0425) / 48;
            } else {
                monthlyPayment = (getTotalPrice() * 1.0525) / 24;
            }
        }
        return Double.parseDouble(df.format(monthlyPayment));
    }


}
