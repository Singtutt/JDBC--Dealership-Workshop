package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.app.ui.UserInterface;
import com.pluralsight.dealership.dao.connect.DataConnect;
import com.pluralsight.dealership.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;

public class VehicleDAO {
//    private static final UserInterface ui = new UserInterface();

    public static ArrayList<Vehicle> byPrice(int lowest, int highest) {
        return sortBy("v.price > ? AND v.price < ?", String.valueOf(lowest), String.valueOf(highest));
    }

    public static ArrayList<Vehicle> byMakeModel(String make, String model) {
        return sortBy("v.make = ? AND v.model = ?", make, model);
    }

    public static ArrayList<Vehicle> byYear(int lowest, int highest) {
        return sortBy("v.year >= ? AND v.year <= ?", String.valueOf(lowest), String.valueOf(highest));
    }

    public static ArrayList<Vehicle> byColor(String color) {
        return sortBy("v.color = ?", color);
    }

    public static ArrayList<Vehicle> byMileage(int lowest, int highest) {
        return sortBy("v.mileage >= ? ANd v.mileage <= ?", String.valueOf(lowest), String.valueOf(highest));
    }

    public static ArrayList<Vehicle> byType(String type) {
        return sortBy("v.type = ?", type);
    }

    private static ArrayList<Vehicle> allVehicles() {
        return sortBy("1 = 1");
    }

    public static void addNewVehicles(String vin, String make, String model, int year, String type, String color, int mileage, double price) {
        String query = """
                INSERT INTO vehicles (VIN, Make, Model, Year, Type, Color, Mileage, Price)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)""";
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, vin);
            prep.setString(2, make);
            prep.setString(3, model);
            prep.setInt(4, year);
            prep.setString(5, type);
            prep.setString(6, color);
            prep.setInt(7, mileage);
            prep.setDouble(8, price);
            prep.executeUpdate();
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("UPDATE ERROR");
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
            e.printStackTrace();
            System.out.println("UPDATE ERROR");
        }

    }

    private static ArrayList<Vehicle> sortBy(String condition, String... parameters) {
        ArrayList<Vehicle> sortedVehicles = new ArrayList<>();
        String query = """
                               SELECT *
                               FROM vehicles v
                               WHERE
                               """ + condition;
        try (Connection conn = DataConnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(query)) {
            int temp = 1;
            for (String instance : parameters) {
                prep.setString(temp++, instance);
            }
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle(
                            rs.getString("VIN"),
                            rs.getInt("Year"),
                            rs.getString("Make"),
                            rs.getString("Model"),
                            rs.getString("Type"),
                            rs.getString("Color"),
                            rs.getInt("Mileage"),
                            rs.getDouble("Price"),
                            rs.getBoolean("Sold")
                    );
                    sortedVehicles.add(newVehicle);
                }
                return sortedVehicles;
            } catch (Exception sortError) {
                sortError.printStackTrace();
                System.out.println("SORT ERROR");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
//    private static ArrayList<Vehicle> sortBy(String q, Object... arrays) {
//        ArrayList<Vehicle> sortedVehicles = new ArrayList<>();
//        try (Connection conn = DataConnect.getConnection();
//        PreparedStatement prep = conn.prepareStatement(q)) {
//            int temp = 1;
//            for (Object array : arrays) {
//                if (array instanceof String) {
//                    prep.setString(temp++, (String) array);
//                } else if (array instanceof Integer) {
//                    prep.setInt(temp++, (Integer) array);
//                } else if (array instanceof  Double) {
//                    prep.setDouble(temp++, (Double) array);
//                }
//            }
//            try (ResultSet rs = prep.executeQuery()){
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicl
//                    );
//
//                    )
//                }
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    public static ArrayList<Vehicle> sortByPrice(double lowest, double highest) {
//        ArrayList<Vehicle> priceSortedVehicles = new ArrayList<>();
//        try (Connection conn = DataConnect.getConnection();
//             PreparedStatement prep = conn.prepareStatement(query)) {
//            prep.setDouble(1, lowest);
//            prep.setDouble(2, highest);
//            try (ResultSet rs = prep.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN");
//                    priceSortedVehicles.add(newVehicle);
//                }
//                return priceSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//        public static ArrayList<Vehicle> sortByMakeModel (String make, String model){
//            ArrayList<Vehicle> makeModelSortedVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "WHERE v.make = \"" + make + "\" AND " +
//                           "v.model = \"" + model + "\"";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                    makeModelSortedVehicles.add(newVehicle);
//                }
//                return makeModelSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
//
//        public static ArrayList<Vehicle> sortByMakeModel (String makeOrModel){
//            ArrayList<Vehicle> makeModelSortedVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "WHERE v.make = \"" + makeOrModel + "\" OR " +
//                           "v.model = \"" + makeOrModel + "\"";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                            rs.getInt("Year"),
//                            rs.getString("Make"),
//                            rs.getString("Model"),
//                            rs.getString("Type"),
//                            rs.getString("Color"),
//                            rs.getInt("Mileage"),
//                            rs.getDouble("Price"));
//                    makeModelSortedVehicles.add(newVehicle);
//                }
//                return makeModelSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
//
//        public static ArrayList<Vehicle> sortByYear ( int lowest, int highest){
//            ArrayList<Vehicle> yearSortedVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "WHERE v.year < " + highest + " AND " +
//                           "v.year > " + lowest;
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                            rs.getInt("Year"),
//                            rs.getString("Make"),
//                            rs.getString("Model"),
//                            rs.getString("Type"),
//                            rs.getString("Color"),
//                            rs.getInt("Mileage"),
//                            rs.getDouble("Price"));
//                    yearSortedVehicles.add(newVehicle);
//                }
//                return yearSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
//
//        public static ArrayList<Vehicle> sortByColor (String color){
//            ArrayList<Vehicle> colorSortedVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "WHERE v.color = \"" + color + "\"";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                            rs.getInt("Year"),
//                            rs.getString("Make"),
//                            rs.getString("Model"),
//                            rs.getString("Type"),
//                            rs.getString("Color"),
//                            rs.getInt("Mileage"),
//                            rs.getDouble("Price"));
//                    colorSortedVehicles.add(newVehicle);
//                }
//                return colorSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
//
//        public static ArrayList<Vehicle> sortByMileage ( int lowest, int highest){
//            ArrayList<Vehicle> mileageSortedVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "WHERE v.mileage < " + highest + " AND " +
//                           "v.mileage > " + lowest;
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                            rs.getInt("Year"),
//                            rs.getString("Make"),
//                            rs.getString("Model"),
//                            rs.getString("Type"),
//                            rs.getString("Color"),
//                            rs.getInt("Mileage"),
//                            rs.getDouble("Price"));
//                    mileageSortedVehicles.add(newVehicle);
//                }
//                return mileageSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
//
//        public static ArrayList<Vehicle> sortByType (String type){
//            ArrayList<Vehicle> typeSortedVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "WHERE v.type = \"" + type + "\"";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                            rs.getInt("Year"),
//                            rs.getString("Make"),
//                            rs.getString("Model"),
//                            rs.getString("Type"),
//                            rs.getString("Color"),
//                            rs.getInt("Mileage"),
//                            rs.getDouble("Price"));
//                    typeSortedVehicles.add(newVehicle);
//                }
//                return typeSortedVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
//
//        public static void addNewVehicle (String vin, String make, String model,int year, String type, String color,
//        int mileage, double price){
//            //CHECK IF ADMIN
//            String query = "INSERT INTO vehicles (VIN, Make, Model, Year, Type, Color, Mileage, Price)" +
//                           "VALUES (\"" + vin + "\", \"" + make + "\", \"" + model + "\", " + year + ",\"" + type + "\", \"" + color + "\", " + mileage + ", " + df.format(price) + ")";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query)) {
//                preparedStatement.executeUpdate();
//                System.out.println("SUCCESS");
//            } catch (Exception updateError) {
//                System.out.println("UPDATE ERROR");
//                updateError.printStackTrace();
//            }
//        }
//
//        public static void removeVehicle (String vin){
//            //CHECK IF ADMIN
//            String query = "DELETE FROM vehicles WHERE VIN = \"" + vin + "\"";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query)) {
//                preparedStatement.executeUpdate();
//                System.out.println("SUCCESS");
//            } catch (Exception updateError) {
//                System.out.println("UPDATE ERROR");
//                updateError.printStackTrace();
//            }
//        }
//
//        public static ArrayList<Vehicle> allVehicles () {
//            ArrayList<Vehicle> allVehicles = new ArrayList<>();
//            String query = "SELECT * " +
//                           "FROM vehicles AS v " +
//                           "ORDER BY v.Make";
//            try (Connection conn = getConnection();
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 ResultSet rs = preparedStatement.executeQuery()) {
//                while (rs.next()) {
//                    Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
//                            rs.getInt("Year"),
//                            rs.getString("Make"),
//                            rs.getString("Model"),
//                            rs.getString("Type"),
//                            rs.getString("Color"),
//                            rs.getInt("Mileage"),
//                            rs.getDouble("Price"));
//                    allVehicles.add(newVehicle);
//                }
//                return allVehicles;
//            } catch (Exception sortError) {
//                System.out.println("SORT ERROR");
//                sortError.printStackTrace();
//                return null;
//            }
//        }
