package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.dao.connect.DataConnect;
import com.pluralsight.dealership.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public static List<Vehicle> byVIN(String vin) {
        return sortBy("v.vin = ?", vin);
    }
    public static List<Vehicle> byPrice(double lowest, double highest) {
        return sortBy("v.price > ? AND v.price < ?", String.valueOf(lowest), String.valueOf(highest));
    }
    public static List<Vehicle> byMakeModel(String make, String model) {
        return sortBy("v.make = ? AND v.model = ?", make, model);
    }
    public static List<Vehicle> byYear(int lowest, int highest) {
        return sortBy("v.year >= ? AND v.year <= ?", String.valueOf(lowest), String.valueOf(highest));
    }
    public static List<Vehicle> byColor(String color) {
        return sortBy("v.color = ?", color);
    }
    public static List<Vehicle> byMileage(int lowest, int highest) {
        return sortBy("v.mileage >= ? ANd v.mileage <= ?", String.valueOf(lowest), String.valueOf(highest));
    }
    public static List<Vehicle> byType(String type) {
        return sortBy("v.type = ?", type);
    }
    public static List<Vehicle> allVehicles() {
        return sortBy("1 = 1");
    }

    private static List<Vehicle> sortBy(String condition, String... properties) {
        List<Vehicle> sortedVehicles = new ArrayList<>();
        String query = """
                               SELECT *
                               FROM vehicles v
                               WHERE
                               """ + condition;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            setProperties(prep, properties);
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = vehicleResultSet(rs);
                    sortedVehicles.add(newVehicle);
                }
                return sortedVehicles;
            } catch (SQLException e) {
                sqlErrorHandling(e, "ENTRY | FILTER ERROR");
            }
        } catch (SQLException e) {
            sqlErrorHandling(e);
        }
        return sortedVehicles;
    }
    public static void addVehicle(Vehicle vehicle) {
        String query = """
                INSERT INTO vehicles (VIN, Make, Model, Year, Type, Color, Mileage, Price, Sold)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            vehiclePreparedStatement(prep, vehicle);
            prep.setBoolean(9, vehicle.isSold());
            prep.executeUpdate();
            System.out.println("Vehicle added successfully!");
        } catch (SQLException e) {
            sqlErrorHandling(e, "Error while adding a new vehicle");
        }
    }
    public static void removeVehicle(String vin) {
        String query = """
                DELETE FROM vehicles
                WHERE VIN = ?""";
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, vin);
            prep.executeUpdate();
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            sqlErrorHandling(e, "ENTRY | DELETE ERROR");
        }
    }
    private static void vehiclePreparedStatement(PreparedStatement prep, Vehicle vehicle) throws SQLException {
        prep.setString(1, vehicle.getVin());
        prep.setString(2, vehicle.getMake());
        prep.setString(3, vehicle.getModel());
        prep.setInt(4, vehicle.getYear());
        prep.setString(5, vehicle.getType());
        prep.setString(6, vehicle.getColor());
        prep.setInt(7, vehicle.getMileage());
        prep.setDouble(8, vehicle.getPrice());
    }
    private static Vehicle vehicleResultSet(ResultSet rs) throws SQLException {
        return new Vehicle(
                rs.getString("VIN"),
                rs.getString("Make"),
                rs.getString("Model"),
                rs.getString("Type"),
                rs.getString("Color"),
                rs.getInt("Year"),
                rs.getInt("Mileage"),
                rs.getDouble("Price"),
                rs.getBoolean("Sold")
        );
    }
    private static void setProperties(PreparedStatement prep, String[] properties) throws SQLException {
        for (int i = 0; i < properties.length; i++) {
            prep.setString(i + 1, properties[i]);
        }
    }
    private static void sqlErrorHandling(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    private static void sqlErrorHandling(SQLException e, String display) {
        e.printStackTrace();
        System.out.println(display);
    }
}
