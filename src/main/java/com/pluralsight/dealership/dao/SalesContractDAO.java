package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.contract.SalesContract;
import com.pluralsight.dealership.dao.connect.DataConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesContractDAO {
    public static List<SalesContract> getAllSalesContracts() {
        List<SalesContract> contracts = new ArrayList<>();
        String queryAll = "SELECT * FROM Sales_Contracts";
        try (Connection conn = DataConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryAll)) {
            while (rs.next()) {
                contracts.add(scSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
    public static SalesContract byID(int id) {
        String queryID = """
                SELECT *
                FROM Sales_Contracts
                WHERE SaleID=?
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(queryID)) {
            prep.setInt(1, id);
            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    return scSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void saveSC(SalesContract sc) {
        String query = """
                INSERT INTO sales_contracts
                (SaleID, Date, Name, Email, VIN, TotalPrice, MonthlyPrice, Financed)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (Connection con = DataConnect.getConnection();
             PreparedStatement prep = con.prepareStatement(query)) {
            savePrep(prep, sc);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            errorHandling(e, "ENTRY | INSERT ERROR");
        }
    }
    public static void updateSC(SalesContract sc) {
        String queryUpdate = """
                UPDATE Sales_Contracts
                SET Date=?, Email=?, VIN=?, TotalPrice=?, Financed=?, MonthlyPrice=?
                WHERE SaleID=?
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(queryUpdate)) {
            updatePrep(prep, sc);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteSC(int id) {
        String query = """
                DELETE
                FROM sales_contracts
                WHERE SaleID=?
                """;
        try (Connection con = DataConnect.getConnection();
             PreparedStatement prep = con.prepareStatement(query)) {
            prep.setInt(1, id);
            prep.executeUpdate();
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            errorHandling(e, "ENTRY | DELETE ERROR");
        }
    }
    private static void savePrep(PreparedStatement prep, SalesContract sc) throws SQLException {
        prep.setInt(1, sc.getId());
        prep.setString(2, String.valueOf(sc.getDate()));
        prep.setString(3, sc.getName());
        prep.setString(4, sc.getEmail());
        prep.setString(5, sc.getVehicleVIN());
        prep.setDouble(6, sc.getTotalPrice());
        prep.setDouble(7, sc.getMonthlyPrice());
        prep.setBoolean(8, sc.isFinanced());
        prep.executeUpdate();
    }
    private static void updatePrep(PreparedStatement prep, SalesContract sc) throws SQLException {
        prep.setString(1, String.valueOf(sc.getDate()));
        prep.setString(2, sc.getName());
        prep.setString(3, sc.getEmail());
        prep.setString(4, sc.getVehicleVIN());
        prep.setDouble(5, sc.getTotalPrice());
        prep.setDouble(6, sc.getMonthlyPrice());
        prep.setBoolean(7, sc.isFinanced());
        prep.setInt(8, sc.getId());
        prep.executeUpdate();
    }
    private static SalesContract scSet(ResultSet rs) throws SQLException {
        return new SalesContract(
                rs.getInt("SaleId"),
                rs.getTimestamp("Date"),
                rs.getString("Name"),
                rs.getString("Email"),
                rs.getString("VIN"),
                rs.getDouble("TotalPrice"),
                rs.getDouble("MonthlyPrice"),
                rs.getBoolean("Financed")
        );
    }
    private static void errorHandling(SQLException e, String display) {
        e.printStackTrace();
        System.out.println(display);
    }
}
