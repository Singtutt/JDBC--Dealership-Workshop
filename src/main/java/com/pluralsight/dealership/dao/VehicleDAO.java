package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;

import static com.pluralsight.dealership.app.UserInterface.df;
import static com.pluralsight.dealership.dao.connect.DataConnect.getConnection;

public class VehicleDAO {
    public static ArrayList<Vehicle> sortByPrice(double lowest, double highest){
        ArrayList<Vehicle> priceSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.price > " + lowest  + " AND " +
                "v.price < " + highest;
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                priceSortedVehicles.add(newVehicle);
            }
            return priceSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Vehicle> sortByMakeModel(String make, String model){
        ArrayList<Vehicle> makeModelSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.make = \"" + make + "\" AND " +
                "v.model = \"" + model + "\"";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                makeModelSortedVehicles.add(newVehicle);
            }
            return makeModelSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Vehicle> sortByMakeModel(String makeOrModel){
        ArrayList<Vehicle> makeModelSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.make = \"" + makeOrModel + "\" OR " +
                "v.model = \"" + makeOrModel + "\"";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                makeModelSortedVehicles.add(newVehicle);
            }
            return makeModelSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Vehicle> sortByYear(int lowest, int highest){
        ArrayList<Vehicle> yearSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.year < " + highest  + " AND " +
                "v.year > " + lowest;
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                yearSortedVehicles.add(newVehicle);
            }
            return yearSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Vehicle> sortByColor(String color){
        ArrayList<Vehicle> colorSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.color = \"" + color + "\"";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                colorSortedVehicles.add(newVehicle);
            }
            return colorSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Vehicle> sortByMileage(int lowest, int highest){
        ArrayList<Vehicle> mileageSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.mileage < " + highest  + " AND " +
                "v.mileage > " + lowest;
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                mileageSortedVehicles.add(newVehicle);
            }
            return mileageSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Vehicle> sortByType(String type){
        ArrayList<Vehicle> typeSortedVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "WHERE v.type = \"" + type + "\"";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                typeSortedVehicles.add(newVehicle);
            }
            return typeSortedVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }

    public static void addNewVehicle(String vin, String make, String model, int year, String type, String color, int mileage, double price){
        //CHECK IF ADMIN
        String query = "INSERT INTO vehicles (VIN, Make, Model, Year, Type, Color, Mileage, Price)" +
                "VALUES (\"" + vin + "\", \"" + make + "\", \"" + model + "\", " + year +  ",\"" + type + "\", \"" + color + "\", " + mileage + ", " + df.format(price) + ")";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.executeUpdate();
            System.out.println("SUCCESS");
        }
        catch (Exception updateError) {
            System.out.println("UPDATE ERROR");
            updateError.printStackTrace();
        }
    }

    public static void removeVehicle(String vin){
        //CHECK IF ADMIN
        String query = "DELETE FROM vehicles WHERE VIN = \"" + vin + "\"";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.executeUpdate();
            System.out.println("SUCCESS");
        }
        catch (Exception updateError) {
            System.out.println("UPDATE ERROR");
            updateError.printStackTrace();
        }
    }

    public static ArrayList<Vehicle> allVehicles(){
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        String query = "SELECT * " +
                "FROM vehicles AS v " +
                "ORDER BY v.Make";
        try(Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery()){
            while(rs.next()){
                Vehicle newVehicle = new Vehicle(rs.getString("VIN"),
                        rs.getInt("Year"),
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getInt("Mileage"),
                        rs.getDouble("Price"));
                allVehicles.add(newVehicle);
            }
            return allVehicles;
        }
        catch (Exception sortError) {
            System.out.println("SORT ERROR");
            sortError.printStackTrace();
            return null;
        }
    }
}
