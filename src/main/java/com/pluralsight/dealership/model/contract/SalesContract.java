package com.pluralsight.dealership.model.contract;

import java.sql.*;
import java.text.DecimalFormat;

public class SalesContract extends baseContract {
    private int id;
    private Date date;
    private String name, email, vehicleVIN;
    private double totalPrice, monthlyPrice;
    private boolean financed, Sold;
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public SalesContract(int id, Date date, String name, String email, String vin, double totalPrice, double monthlyPrice, int saleID, Date date1, String name1, String email1, String vehicleVIN, double totalPrice1, double monthlyPrice1, boolean financed, boolean sold) {
        super(id, date, name, email, vin, totalPrice, monthlyPrice);
        this.id = saleID;
        this.date = date1;
        this.name = name1;
        this.email = email1;
        this.vehicleVIN = vehicleVIN;
        this.totalPrice = totalPrice1;
        this.monthlyPrice = monthlyPrice1;
        this.financed = financed;
        Sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getVehicleVIN() {
        return vehicleVIN;
    }

    public void setVehicleVIN(String vehicleVIN) {
        this.vehicleVIN = vehicleVIN;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    public boolean isSold() {
        return Sold;
    }

    public void setSold(boolean sold) {
        Sold = sold;
    }

    @Override
    public double getTotalPrice() {
        double salesTax = totalPrice * 0.05;
        double recordingFee = 100;
        double processingFee = (totalPrice > 10000) ? 495 : 295;
        return Double.parseDouble(df.format((totalPrice + salesTax + recordingFee + processingFee)));
    }
    @Override
    public double getMonthlyPayment() {
        double monthlyPayment = 0;
        if (financed) {
            if (getTotalPrice() > 10000) {
                monthlyPayment = (getTotalPrice() * 1.0425) / 48;
            } else {
                monthlyPayment = (getTotalPrice() * 1.0525) / 24;
            }
        }
        return Double.parseDouble(df.format(monthlyPayment));
    }
}
//    private double salesTax, recordingFee, processingFee = 295;
//    private double vehicleCost;

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