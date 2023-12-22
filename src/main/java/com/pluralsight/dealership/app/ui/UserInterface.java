package com.pluralsight.dealership.app.ui;


import com.pluralsight.dealership.dao.LeaseContractDAO;
import com.pluralsight.dealership.dao.SalesContractDAO;
import com.pluralsight.dealership.dao.VehicleDAO;
import com.pluralsight.dealership.model.Vehicle;
import com.pluralsight.dealership.model.contract.LeaseContract;
import com.pluralsight.dealership.model.contract.SalesContract;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.dealership.dao.VehicleDAO.*;

public class UserInterface {
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    //  Filter Menu User Prompts and inputs.
    public static void processGetVehiclesByPriceRequest() {
        try {
            System.out.print("\nPlease enter the minimum price for your search: $");
            double minPrice = input.nextDouble();
            System.out.print("\nPlease enter the maximum price for your search: $");
            double maxPrice = input.nextDouble();

            List<Vehicle> filteredByPrice = byPrice(minPrice, maxPrice);

            System.out.println("\nList of All Vehicles between $" + df.format(minPrice) + " - $" + df.format(maxPrice) + ":");
            formatVehicles(filteredByPrice);

            System.out.println("\nReturning to the main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid price (Ex: $1633.23).\n");
            input.nextLine();
            processGetVehiclesByPriceRequest();
        }
    }

    public static void processGetVehiclesByMakeModelRequest() {
        try {
            System.out.print("\nPlease enter the vehicle make for your search: ");
            String make = input.nextLine();
            System.out.print("\nPlease enter the vehicle model for your search: ");
            String model = input.nextLine();

            List<Vehicle> filteredByMakeModel = byMakeModel(make, model);

            System.out.println("\nList of All " + make + " " + model + "s:");
            formatVehicles(filteredByMakeModel);

            System.out.println("\nReturning to the main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid make or model (Ex: Ford Explorer).\n");
            input.nextLine();
            processGetVehiclesByMakeModelRequest();
        }
    }

    public static void processGetVehiclesByYearRequest() {
        try {
            System.out.print("\nPlease enter the minimum year for your search: ");
            int minYear = input.nextInt();
            System.out.print("\nPlease enter the maximum year for your search: ");
            int maxYear = input.nextInt();

            List<Vehicle> filteredByYear = byYear(minYear, maxYear);

            System.out.println("\nList of All Vehicles between " + minYear + " - " + maxYear + ":");
            formatVehicles(filteredByYear);

            System.out.println("\nReturning to the main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid year (Ex: 2004).\n");
            input.nextLine();
            processGetVehiclesByYearRequest();
        }
    }

    public static void processGetVehiclesByColorRequest() {
        try {
            System.out.print("\nPlease enter the vehicle color for your search: ");
            String color = input.nextLine();

            List<Vehicle> filteredByColor = byColor(color);

            System.out.println("\nList of All " + color + " vehicles:");
            formatVehicles(filteredByColor);

            System.out.println("\nReturning to the main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid color (Ex: Red).\n");
            processGetVehiclesByColorRequest();
        }
    }

    public static void processGetVehiclesByMileageRequest() {
        try {
            System.out.print("\nPlease enter the minimum mileage for your search: ");
            int minMileage = input.nextInt();
            System.out.print("\nPlease enter the maximum mileage for your search: ");
            int maxMileage = input.nextInt();

            List<Vehicle> filteredByMileage = byMileage(minMileage, maxMileage);

            System.out.println("\nList of All Vehicles with mileage between " + minMileage + " - " + maxMileage + ":");
            formatVehicles(filteredByMileage);

            System.out.println("\nReturning to the main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid mileage (Ex: 56263).\n");
            processGetVehiclesByMileageRequest();
        }
    }

    public static void processGetVehiclesByTypeRequest() {
        try {
            System.out.print("\nPlease enter the vehicle type for your search: ");
            String vehicleType = input.nextLine();

            List<Vehicle> filteredByType = byType(vehicleType);

            System.out.println("\nList of All " + vehicleType + " vehicles:");
            formatVehicles(filteredByType);

            System.out.println("\nReturning to the main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid vehicle type (Ex: SUV).\n");
            processGetVehiclesByTypeRequest();
        }
    }

    public static void processGetAllVehiclesRequest() {
        System.out.println("\nList of All Vehicles: ");
        formatVehicles(allVehicles());
        System.out.println("\nReturning to the main menu...\n");
        Screens.mainMenuFlow();
    }

    //    Modify Menu User Prompts and Inputs
    public static void processAddVehicleRequest() {
        try {
            System.out.println("\nVehicle Addition Form:");
            System.out.print("Please enter the VIM of the new vehicle (Ex: 12345): ");
            String newVin = input.nextLine();
            System.out.print("\nPlease enter the year of the new vehicle (Ex: 2003): ");
            int newYear = input.nextInt();
            input.nextLine();
            System.out.print("\nPlease enter the make of the new vehicle (Ex: Ford): ");
            String newMake = input.nextLine();
            System.out.print("\nPlease enter the model of the new vehicle (Ex: Explorer): ");
            String newModel = input.nextLine();
            System.out.print("\nPlease enter the vehicle type of the new vehicle (Ex: SUV): ");
            String newVehicleType = input.nextLine();
            System.out.print("\nPlease enter the color of the new vehicle (Ex: Red): ");
            String newColor = input.nextLine();
            System.out.print("\nPlease enter the mileage of the new vehicle (Ex: 123456): ");
            int newMileage = input.nextInt();
            System.out.print("\nPlease enter the price of the new vehicle (Ex: $10000): $");
            double newPrice = input.nextDouble();
            Vehicle newVehicle = new Vehicle(newVin, newMake, newModel, newVehicleType, newColor, newMileage, newPrice, false);
            VehicleDAO.addVehicle(newVehicle);
            System.out.println("\nYour new vehicle has been successfully added!\n\nReturning to main menu...\n");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nThere has been an input error. Please review your information and try again. ");
            Screens.mainMenuFlow();
        }
    }

    public static void processRemoveVehicleRequest() {
        try {
            List<Vehicle> VehicleList = allVehicles();
            System.out.println("\nAll removable vehicles: ");
            formatVehicles(VehicleList);
            System.out.print("\nPlease enter the number of the vehicle you would like to remove (Ex: 2): ");
            int removeInput = Integer.parseInt(input.nextLine());
            if (removeInput > 0 && removeInput <= VehicleList.size()) {
                VehicleDAO.removeVehicle(VehicleList.get(removeInput - 1).getVin());
                System.out.println("\nYour selected vehicle has been successfully removed!\n\nReturning to the main menu...\n");
                Screens.mainMenuFlow();
            } else {
                System.out.println("\nInvalid vehicle number. Please select a valid vehicle number.\n");
                processRemoveVehicleRequest();
            }
        } catch (Exception inputError) {
            System.out.println("\nThere has been an input error. Please review your chosen vehicle number and try again. ");
            Screens.mainMenuFlow();
        }
    }

    //    Contract Menu User Prompts and Inputs
    public static void processNewSalesContractRequest() {
        SalesContract newSC = null;
        try {
            Timestamp date = new Timestamp(System.currentTimeMillis());
            System.out.println("Sales Contract Form:");
            System.out.print("Please enter your first and last name (Ex. John Smith): ");
            String nameInput = input.nextLine();
            System.out.print("Please enter your email (Ex. johnsmithcars@gmail.com): ");
            String emailInput = input.nextLine();
            System.out.print("Please enter the VIN of the vehicle you would like to begin a contract with (Ex. 12345): ");
            String vinInput = input.nextLine();
            List<Vehicle> vehicleInput = byVIN(vinInput);
            if (vehicleInput == null || vehicleInput.isEmpty()) {
                System.out.println("\nUnfortunately, we could not find an available vehicle with your chosen VIN. Please verify your information and try again!");
                System.out.println("\nNow returning to the main menu...\n");
                Screens.mainMenuFlow();
                return;
            }
            System.out.print("Will you be financing this vehicle today? (Y or N): ");
            String yN = input.nextLine().toLowerCase();
            newSC = new SalesContract(0, date, nameInput, emailInput, vinInput, 0, 0, false);
            if (yN.equals("y")) {
                newSC.setFinanced(true);
            }
            SalesContractDAO.saveSC(newSC);
            for (Vehicle vehicle : vehicleInput) {
                if (vehicle != null && !newSC.isFinanced()) {
                    vehicle.setSold(false);
                }
            }
            System.out.println("\nYour contract has been recorded! Thank you for your business with 'E & S', & we hope you enjoy your new " + vehicleInput.get(0).getYear() + " " + vehicleInput.get(0).getMake() + " " + vehicleInput.get(0).getModel() + "!");
            System.out.println("\nNow returning to the main menu...");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            System.out.println("\nThere has been an input error. Please review your chosen info and try again. ");
            Screens.mainMenuFlow();
        }
    }
    public static void processNewLeaseContractRequest() {
        LeaseContract newLC = null;
        try {
            Timestamp date = new Timestamp(System.currentTimeMillis());
            System.out.println("Lease Contract Form:");
            System.out.print("Please enter your first and last name (Ex. John Smith): ");
            String nameInput = input.nextLine();
            System.out.print("Please enter your email (Ex. johnsmithcars@gmail.com): ");
            String emailInput = input.nextLine();
            System.out.print("Please enter the VIN of the vehicle you would like to begin a contract with (Ex. 12345): ");
            String vinInput = input.nextLine();
            newLC = new LeaseContract(0, date, nameInput, emailInput, vinInput, 0, 0);
            LeaseContractDAO.saveLC(newLC);
            System.out.println("\nYour lease contract has been recorded! Thank you for choosing us.");
            System.out.println("Returning to the main menu...");
            Screens.mainMenuFlow();
        } catch (Exception inputError) {
            // Handle input errors and flow as per your application's logic
            System.out.println("\nThere has been an input error. Please review your chosen information and try again. ");
            Screens.mainMenuFlow();
        }
    }
    //    Support methods
    public void setFinancedForContract(SalesContract contract) {
        Scanner input = new Scanner(System.in);
        System.out.print("Is this contract financed? (Y/N): ");
        String userInput = input.nextLine();

        boolean isFinanced = userInput.equalsIgnoreCase("Y");

        contract.setFinanced(isFinanced);
    }

    public static void formatVehicles(List<Vehicle> vehicleList) {
        System.out.println("\n[~Vehicle Inventory~]");
        System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-15s | %-10s | %-10s | %-15s |%n", "ID", "VIN", "Year", "Make", "Model", "Vehicle Type", "Color", "Price");
        System.out.println("------------------------------------------------------------------------------");
        int temp = 1;
        for (Vehicle vehicle : vehicleList) {
            System.out.printf("| %-20s | %-5s | %-15s | %-15s | %-10s | %-10s | %-15s |%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getType(), vehicle.getColor(), vehicle.getPrice());
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\nRedirecting...");
    }
}


