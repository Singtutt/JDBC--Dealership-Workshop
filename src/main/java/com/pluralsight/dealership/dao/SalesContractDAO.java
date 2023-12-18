package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.contract.SalesContract;
import com.pluralsight.dealership.dao.connect.DataConnect;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesContractDAO {
//
//    public void saveContract(SalesContract sc) {
//        String query = """
//                INSERT INTO Sales_Contracts
//                (SaleID, Date, Name, Email, VIN, TotalPrice, MonthlyPrice, Financed, Sold)
//                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
//                """;
//        try (Connection con = DataConnect.getConnection();
//             PreparedStatement prep = con.prepareStatement(query)) {
//            prep.setInt(1, sc.getSaleId());
//            prep.setString(2, sc.getDate());
//            prep.setString(3, sc.getName());
//            prep.setString(4, sc.getEmail());
//            prep.setString(5, sc.getVehicleVIN());
//            prep.setBigDecimal(6, BigDecimal.valueOf(sc.getTotalPrice()));
//            prep.setBigDecimal(7, BigDecimal.valueOf(sc.getMonthlyPrice()));
//            prep.setBoolean(8, sc.isFinanced());
//            prep.setBoolean(9, sc.isSold());
//            prep.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<SalesContract> retrieveContracts() {
//        List<SalesContract> scArray = new ArrayList<>();
//        String query = """
//                SELECT *
//                FROM Sales_Contracts
//                """;
//        try (Connection con = DataConnect.getConnection();
//             PreparedStatement prep = con.prepareStatement(query);
//             ResultSet rs = prep.executeQuery()) {
//            while (rs.next()) {
//                scArray.add(contractRS(rs));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return scArray;
//    }
//
//    public SalesContract contractByID(int salesContractID) {
//        SalesContract sc = null;
//        String query = """
//                SELECT *
//                FROM Sales_Contracts
//                WHERE SaleID = ?
//                """;
//        try (Connection con = DataConnect.getConnection();
//             PreparedStatement prep = con.prepareStatement(query)) {
//            prep.setInt(1, salesContractID);
//            try (ResultSet rs = prep.executeQuery()) {
//                if (rs.next()) {
//                    sc = contractRS(rs);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return sc;
//    }
//
//    public void updateContract(SalesContract sc) {
//        String query = """
//                UPDATE Sales_Contracts
//                SET Date = ?, Name = ?, Email = ?, VIN = ?, TotalPrice = ?, MonthlyPrice = ?, Financed = ?
//                WHERE SaleID = ?
//                """;
//
//        try (Connection con = DataConnect.getConnection();
//             PreparedStatement prep = con.prepareStatement(query)) {
//            prep.setString(1, sc.getDate());
//            prep.setString(2, sc.getName());
//            prep.setString(3, sc.getEmail());
//            prep.setString(4, sc.getVehicleVIN());
//            prep.setBigDecimal(5, BigDecimal.valueOf(sc.getTotalPrice()));
//            prep.setBigDecimal(6, BigDecimal.valueOf(sc.getMonthlyPrice()));
//            prep.setBoolean(7, sc.isFinanced());
//            prep.setBoolean(8, sc.isSold());
//            prep.setInt(9, sc.getSaleId());
//            prep.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteContract(int salesContractId) {
//        String query = """
//                DELETE
//                FROM Sales_Contracts
//                WHERE SaleID = ?
//                """;
//        try (Connection con = DataConnect.getConnection();
//             PreparedStatement prep = con.prepareStatement(query)) {
//            prep.setInt(1, salesContractId);
//            prep.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    // Running into a problem I think we need to update the database to record dates in contract tables
//    private SalesContract contractRS(ResultSet rs) throws SQLException {
//        int saleId = rs.getInt("SaleId");
//        String stringDate = rs.getString("Date");
//        String name = rs.getString("Name");
//        String email = rs.getString("Email");
//        String vin = rs.getString("VIN");
//        double vehicleCost = rs.getDouble("TotalPrice");
//        boolean isFinanced = rs.getBoolean("Financed");
//        boolean isSold = rs.getBoolean("Sold");
//        double monthlyPrice = rs.getDouble("MonthlyPrice");
//        Date date = new Date();
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            date = format.parse(stringDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return new SalesContract(saleId, date, name, email, vin, isFinanced, isSold, vehicleCost, monthlyPrice);
//    }

}
//    private static double fetchVehiclePrice(String vehicleVIN) throws SQLException {
//        double vehicleCost = 0;
//        String query = """
//                SELECT Price
//                FROM Vehicles
//                WHERE VIN = ?
//                """;
//        try(Connection con = DataConnect.getConnection();
//        PreparedStatement prep = con.prepareStatement(query)) {
//            prep.setString(1, vehicleVIN);
//            try (ResultSet rs = prep.executeQuery()) {
//                if (rs.next()) {
//                    vehicleCost = rs.getDouble("Price");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e;
//        }
//        return vehicleCost;
//    }