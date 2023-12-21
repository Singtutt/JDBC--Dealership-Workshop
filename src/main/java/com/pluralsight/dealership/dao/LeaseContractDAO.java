package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.dao.connect.DataConnect;
import com.pluralsight.dealership.model.contract.LeaseContract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaseContractDAO {
    public static List<LeaseContract> getAllLeaseContracts() {
        List<LeaseContract> contracts = new ArrayList<>();
        String queryAll = "SELECT * FROM Lease_Contracts";
        try (Connection conn = DataConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryAll)) {
            while (rs.next()) {
                contracts.add(lcSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
    public static LeaseContract byID(int id) {
        String queryID = """
                SELECT *
                FROM Lease_Contracts
                WHERE LeaseID = ?
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(queryID)) {
            prep.setInt(1, id);
            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    return lcSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void saveLC(LeaseContract lc) {
        String querySave = """
                INSERT INTO Lease_Contracts
                (Date, Name, Email, VIN, TotalPrice, MonthlyPrice)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(querySave)) {
            savePrep(prep, lc);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateLC(LeaseContract lc) {
        String queryUpdate = """
                UPDATE Lease_Contracts
                SET Date=?, Name=?, Email=?, VIN=?, TotalPrice=?, MonthlyPrice=?
                WHERE LeaseID=?
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(queryUpdate)) {
            updatePrep(prep, lc);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteLC(int id) {
        String queryDelete = """
                DELETE
                FROM Lease_Contracts
                WHERE LeaseID=?
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(queryDelete)) {
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePrep(PreparedStatement prep, LeaseContract lc) throws SQLException {
        prep.setTimestamp(1, lc.getDate());
        prep.setString(2, lc.getName());
        prep.setString(3, lc.getEmail());
        prep.setString(4, lc.getVehicleVIN());
        prep.setDouble(5, lc.getTotalPrice());
        prep.setDouble(6, lc.getMonthlyPrice());
        prep.setInt(7, lc.getId());
        prep.executeUpdate();
    }
    public static void savePrep(PreparedStatement prep, LeaseContract lc) throws SQLException {
        prep.setTimestamp(1, lc.getDate());
        prep.setString(2, lc.getName());
        prep.setString(3, lc.getEmail());
        prep.setString(4, lc.getVehicleVIN());
        prep.setDouble(5, lc.getTotalPrice());
        prep.setDouble(6, lc.getMonthlyPrice());
        prep.executeUpdate();
    }
    public static LeaseContract lcSet(ResultSet rs) throws SQLException {
        return new LeaseContract(
                rs.getInt("LeaseID"),
                rs.getTimestamp("Date"),
                rs.getString("Name"),
                rs.getString("Email"),
                rs.getString("VIN"),
                rs.getDouble("TotalPrice"),
                rs.getDouble("MonthlyPrice")
        );
    }
}
