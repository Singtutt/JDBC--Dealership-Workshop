package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.contract.SalesContract;
import com.pluralsight.dealership.dao.connect.DataConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesContractDAO {
    public static List<SalesContract> allSalesContracts() {
        return sortBy("1 = 1");
    }

    public static SalesContract byID(int id) {
        List<SalesContract> contracts = sortBy("SaleID = ?", String.valueOf(id));
        return contracts.isEmpty() ? null : contracts.get(0);
    }

    public void saveContract(SalesContract sc) {
        String query = """
                INSERT INTO sales_contracts
                (SaleID, Date, Name, Email, VIN, TotalPrice, MonthlyPrice, Financed)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (Connection con = DataConnect.getConnection();
             PreparedStatement prep = con.prepareStatement(query)) {
            scPrep(prep, sc);
            prep.executeUpdate();
            System.out.println("SUCESS");
        } catch (SQLException e) {
            errorHandling(e, "ENTRY | INSERT ERROR");
        }
    }

    public void deleteContract(int id) {
        String query = """
                DELETE
                FROM sales_contracts
                WHERE SaleID = ?
                """;
        try (Connection con = DataConnect.getConnection();
             PreparedStatement prep = con.prepareStatement(query)) {
            prep.setInt(1, id);
            prep.executeUpdate();
            System.out.println("SUCESS");
        } catch (SQLException e) {
            errorHandling(e, "ENTRY | DELETE ERROR");
        }
    }

    private static List<SalesContract> sortBy(String condition, String... properties) {
        List<SalesContract> sortedSC = new ArrayList<>();
        String query = """
                               SELECT *
                               FROM sales_contracts
                               WHERE
                               """ + condition;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            setProperties(prep, properties);
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    SalesContract newSC = scSet(rs);
                    sortedSC.add(newSC);
                }
                return sortedSC;
            } catch (SQLException e) {
                errorHandling(e, "ENTRY | FILTER ERROR");
            }
        } catch (SQLException e) {
            errorHandling(e, "ERROR | CONNECTION TO DATABASE");
        }
        return sortedSC;
    }

    private static void scPrep(PreparedStatement prep, SalesContract sc) throws SQLException {
        prep.setInt(1, sc.getId());
        prep.setString(2, String.valueOf(sc.getDate()));
        prep.setString(3, sc.getName());
        prep.setString(4, sc.getEmail());
        prep.setString(5, sc.getVehicleVIN());
        prep.setDouble(6, sc.getTotalPrice());
        prep.setDouble(7, sc.getMonthlyPrice());
        prep.setBoolean(8, sc.isFinanced());
    }

    private static SalesContract scSet(ResultSet rs) throws SQLException {
        return new SalesContract(
                rs.getInt("SaleId"),
                rs.getDate("Date"),
                rs.getString("Name"),
                rs.getString("Email"),
                rs.getString("VIN"),
                rs.getDouble("TotalPrice"),
                rs.getDouble("MonthlyPrice"),
                rs.getBoolean("Financed")

        );
    }

    private static void setProperties(PreparedStatement prep, String[] properties) throws SQLException {
        for (int i = 0; i < properties.length; i++) {
            prep.setString(i + 1, properties[i]);
        }
    }

    private static void errorHandling(SQLException e, String display) {
        e.printStackTrace();
        System.out.println(display);
    }
}
