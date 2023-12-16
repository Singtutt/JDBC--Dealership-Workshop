package com.pluralsight.dealership.app.ui;

public class Screens {
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
                \t2. Manage Inventory (Add/Delete)
                \t0. Return to Main Menu
            
                User Input:\s""");
    }
    public static void inventoryMenuDisplay() {
        System.out.print("""
                Display Inventory:
                
                Please enter a menu option (0-2):
                \t1. Filter Cars By...
                \t2. Display All Vehicles (Available)
                \t0. Return to Vehicle Management
            
                User Input:\s""");
    }
    public static void filterMenuDisplay() {
        System.out.print("""
                Filter Cars:
                
                Please enter a menu option (0-2):
                \t1. Filter Cars by Price
                \t2. Filter Cars by Make & Model
                \t3. Filter Cars by Year
                \t4. Filter Cars by Color
                \t5. Filter Cars by Mileage
                \t6. Filter Cars by Vehicle Type
                \t7. Retrieve All Available Vehicles
                \t0. Return to Display Inventory
            
                User Input:\s""");
    }
    public static void modifyMenuDisplay() {
        System.out.print("""
                Manage Inventory:
                
                Please enter a menu option (0-2):
                \t1. Add an Entry
                \t2. Delete an Entry
                \t0. Return to Vehicle Management
            
                User Input:\s""");
    }
    public static void salesMenuDisplay() {
        System.out.print("""
                Sales Management:
                
                Please enter a menu option (0-2):
                \t1. Purchase a New Vehicle
                \t2. Lease a New Vehicle
                \t3. Display Contracts
                \t0. Return to Main Menu
            
                User Input:\s""");
    }
    public static void contractMenuDisplay() {
        System.out.print("""
                Sales Management:
                
                Please enter a menu option (0-2):
                \t1. Sales Contracts
                \t2. Lease Contracts
                \t0. Return to Sales Management
            
                User Input:\s""");
    }
}
