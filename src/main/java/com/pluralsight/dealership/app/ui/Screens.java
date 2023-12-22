package com.pluralsight.dealership.app.ui;

import com.pluralsight.dealership.dao.LeaseContractDAO;
import com.pluralsight.dealership.dao.SalesContractDAO;

import java.util.Scanner;

public class Screens {
    public static Scanner input = new Scanner(System.in);
//  Menu Display Handling
    public static void mainMenuDisplay() {
        System.out.print("""
                Welcome to E & S Used Cars!
                                
                Please enter a menu option (0-2):
                \t1. Vehicle Management
                \t2. Sales Management
                \t0. Exit Application
                            
                User Input:\s""");
    }
    public static void vehicleMenuDisplay() {
        System.out.print("""
                Vehicle Management:
                                
                Please enter a menu option (0-2):
                \t1. Display Inventory
                \t2. Modify Inventory (Add/Delete)
                \t0. Return to Main Menu
                            
                User Input:\s""");
    }
    public static void salesMenuDisplay() {
        System.out.print("""
                Sales Management:
                                
                Please enter a menu option (0-2):
                \t1. New Contracts
                \t2. Display Contracts
                \t0. Return to Main Menu
                            
                User Input:\s""");
    }
    public static void inventoryMenuDisplay() {
        System.out.print("""
                Display Inventory:
                                
                Please enter a menu option (0-2):
                \t1. Filter Vehicles By...
                \t2. All Vehicles (Available)
                \t0. Return to Vehicle Management
                            
                User Input:\s""");
    }
    public static void filterMenuDisplay() {
        System.out.print("""
                Filter Cars:
                                
                Please enter a menu option (0-6):
                \t1. Filter Cars by Price
                \t2. Filter Cars by Make & Model
                \t3. Filter Cars by Year
                \t4. Filter Cars by Color
                \t5. Filter Cars by Mileage
                \t6. Filter Cars by Vehicle Type
                \t0. Return to Display Inventory
                            
                User Input:\s""");
    }
    public static void modifyMenuDisplay() {
        System.out.print("""
                Modify Inventory:
                                
                Please enter a menu option (0-2):
                \t1. Add an Entry
                \t2. Delete an Entry
                \t0. Return to Vehicle Management
                            
                User Input:\s""");
    }
    public static void contractMenuDisplay() {
        System.out.print("""
                New Contracts:
                                
                Please enter a menu option (0-2):
                \t1. Sales Contracts
                \t2. Lease Contracts
                \t0. Return to Sales Management
                            
                User Input:\s""");
    }
    private static void contractViewMenuDisplay() {
        System.out.print("""
                Display Contracts:
                                
                Please enter a menu option (0-2):
                \t1. All Sales Contract Entries
                \t2. All Lease Contract Entries
                \t3. Lease Contract Entry
                \t4. Sales Contract Entry
                \t0. Return to Sales Management
                            
                User Input:\s""");
    }
//  Menu Flow Handling
    public static void mainMenuFlow() {
        mainMenuDisplay();
        String option = input.nextLine();

        if (option.isEmpty()) {
            option = input.nextLine();
        }
        switch (option) {
            case "1":
                vehicleMenuDisplay();
                vehicleMenuFlow();
                break;
            case "2":
                salesMenuDisplay();
                salesMenuFlow();
                break;
            case "0":
                System.out.println("\nExiting Application... Have A Good Day!");
                break;
            default:
                System.out.println("\nPlease enter a valid options (0-2)\n");
                mainMenuFlow();
                break;
        }
    }
    public static void vehicleMenuFlow() {
        inventoryMenuDisplay();
        String option = input.nextLine();
        switch (option) {
            case "1":
                filterMenuDisplay();
                filterMenuFlow();
                break;
            case "2":
                modifyMenuDisplay();
                modifyMenuFlow();
                break;
            case "0":
                mainMenuFlow();
                break;
            default:
                System.out.println("\nPlease enter a valid options (0-2)\n");
                vehicleMenuFlow();
                break;
        }
    }
    public static void salesMenuFlow() {
        salesMenuDisplay();
        String option = input.nextLine();
        switch (option) {
            case "1":
                contractMenuFlow();
                break;
            case "2":
                contractViewMenuFlow();
                break;
            case "0":
                mainMenuFlow();
                break;
            default:
                System.out.println("\nPlease enter a valid option (0-2)\n");
                salesMenuFlow();
        }
    }
    private static void contractViewMenuFlow() {
        contractViewMenuDisplay();
        String option = input.nextLine();
        switch (option) {
            case "1":
                UserInterface.processNewSalesContractRequest();
                break;
            case "2":
                UserInterface.processNewLeaseContractRequest();
                break;
            case "3":
                UserInterface.processGetSCByID(); // Need to create this method in SalesContractDAO
                break;
            case "4":
                UserInterface.processGetLCByID();// Need to create this method in LeaseContractDAO
                break;
            case "0":
                salesMenuFlow();
                break;
            default:
                System.out.println("\nPlease enter a valid option (0-2)\n");
                contractViewMenuFlow();
                break;
        }
    }
    public static void inventoryMenuFlow() {
        inventoryMenuDisplay();
        String option = input.nextLine();
        switch (option) {
            case "1":
                filterMenuDisplay();
                break;
            case "2":
                UserInterface.processGetAllVehiclesRequest();
                break;
            case "0":
                vehicleMenuFlow();
                break;
            default:
                System.out.println("\nPlease enter a valid option (0-2)\n");
                inventoryMenuFlow();
                break;
        }
    }
    public static void contractMenuFlow() {
        contractMenuDisplay();
        String option = input.nextLine();
        switch (option) {
            case "1":
                UserInterface.processNewSalesContractRequest();
                break;
            case "2":
                UserInterface.processNewLeaseContractRequest();
                break;
            case "0":
                salesMenuFlow();
                break;
            default:
                System.out.println("\nPlease enter a valid options (0-2)\n");
                contractMenuFlow();
                break;
        }
    }
    public static void filterMenuFlow() {
        String option = input.nextLine();

        switch (option) {
            case "1":
                UserInterface.processGetVehiclesByPriceRequest();
                break;
            case "2":
                UserInterface.processGetVehiclesByMakeModelRequest();
                break;
            case "3":
                UserInterface.processGetVehiclesByYearRequest();
                break;
            case "4":
                UserInterface.processGetVehiclesByColorRequest();
                break;
            case "5":
                UserInterface.processGetVehiclesByMileageRequest();
                break;
            case "6":
                UserInterface.processGetVehiclesByTypeRequest();
                break;
            case "0":
                inventoryMenuFlow();
                break;
            default:
                System.out.println("Please enter a valid option (0-2)\n");
                filterMenuFlow();
                break;

        }
    }
    public static void modifyMenuFlow() {
        String option = input.nextLine();
        switch (option) {
            case "1":
                UserInterface.processAddVehicleRequest();
                break;
            case "2":
                UserInterface.processRemoveVehicleRequest();
                break;
            case "0":
                vehicleMenuFlow();
                break;
            default:
                System.out.println("\nPlease enter a valid option (0-2)\n");
                modifyMenuFlow();
                break;
        }
    }
}
