package com.pluralsight.dealership.app.ui;


public class UserInterface {
//    public static Scanner input = new Scanner(System.in);
//    public static Date today = new Date();
//    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
//    public static DecimalFormat df = new DecimalFormat("#.00");
//
//    public static void processGetVehiclesByPriceRequest() {
//        try {
//            System.out.print("\nPlease enter the minimum price for your search: $");
//            double minPrice = input.nextDouble();
//            System.out.print("\nPlease enter the maximum price for your search: $");
//            double maxPrice = input.nextDouble();
//            System.out.println("\nList of All Vehicles between $" + df.format(minPrice) + " - $" + df.format(maxPrice) + ":");
//            formatVehicles(byPrice(minPrice, maxPrice));
//            System.out.println("\nReturning to the main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nPlease enter a valid price (Ex: $1633.23).\n");
//            processGetVehiclesByPriceRequest();
//        }
//    }
//
//    public static void processGetVehiclesByMakeModelRequest() {
//        try {
//            System.out.print("\nPlease enter the vehicle make for your search: ");
//            String make = input.nextLine();
//            System.out.print("\nPlease enter the vehicle model for your search: ");
//            String model = input.nextLine();
//            System.out.println("\nList of All " + make + " " + model + "s:");
//            formatVehicles(sortByMakeModel(make, model));
//            System.out.println("\nReturning to the main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nPlease enter a valid make or model (Ex: Ford Explorer).\n");
//            processGetVehiclesByMakeModelRequest();
//        }
//    }
//
//    public static void processGetVehiclesByYearRequest() {
//        try {
//            System.out.print("\nPlease enter the minimum year for your search: ");
//            int minYear = input.nextInt();
//            System.out.print("\nPlease enter the maximum year for your search: ");
//            int maxYear = input.nextInt();
//            System.out.println("\nList of All Vehicles between " + minYear + " - " + maxYear + ":");
//            formatVehicles(sortByYear(minYear, maxYear));
//            System.out.println("\nReturning to the main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nPlease enter a valid year (Ex: 2004).\n");
//            processGetVehiclesByYearRequest();
//        }
//    }
//
//    public static void processGetVehiclesByColorRequest() {
//        try {
//            System.out.print("\nPlease enter the vehicle color for your search: ");
//            String color = input.nextLine();
//            System.out.println("\nList of All " + color + " vehicles:");
//            formatVehicles(sortByColor(color));
//            System.out.println("\nReturning to the main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nPlease enter a valid color (Ex: Red).\n");
//            processGetVehiclesByColorRequest();
//        }
//    }
//
//    public static void processGetVehiclesByMileageRequest() {
//        try {
//            System.out.print("\nPlease enter the minimum mileage for your search: ");
//            int minMileage = input.nextInt();
//            System.out.print("\nPlease enter the maximum mileage for your search: ");
//            int maxMileage = input.nextInt();
//            System.out.println("\nList of All Vehicles with mileage between " + minMileage + " - " + maxMileage + ":");
//            formatVehicles(sortByMileage(minMileage, maxMileage));
//            System.out.println("\nReturning to the main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nPlease enter a valid mileage (Ex: 56263).\n");
//            processGetVehiclesByMileageRequest();
//        }
//    }
//
//    public static void processGetVehiclesByTypeRequest() {
//        try {
//            System.out.print("\nPlease enter the vehicle type for your search: ");
//            String vehicleType = input.nextLine();
//            System.out.println("\nList of All " + vehicleType + " vehicles:");
//            formatVehicles(sortByType(vehicleType));
//            System.out.println("\nReturning to the main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nPlease enter a valid vehicle type (Ex: SUV).\n");
//            processGetVehiclesByTypeRequest();
//        }
//    }
//
//    public static void processGetAllVehiclesRequest() {
//        System.out.println("\nList of All Vehicles: ");
//        formatVehicles(allVehicles());
//        System.out.println("\nReturning to the main menu...\n");
//        Screens.mainMenuFlow();
//    }
//
//    public static void processAddVehicleRequest() {
//        try {
//            System.out.println("\nVehicle Addition Form:");
//            System.out.print("Please enter the VIM of the new vehicle(Ex: 12345): ");
//            String newVin = input.nextLine();
//            System.out.print("\nPlease enter the year of the new vehicle(Ex: 2003): ");
//            int newYear = input.nextInt();
//            System.out.print("\nPlease enter the make of the new vehicle(Ex: Ford): ");
//            input.nextLine();
//            String newMake = input.nextLine();
//            System.out.print("\nPlease enter the model of the new vehicle(Ex: Explorer): ");
//            String newModel = input.nextLine();
//            System.out.print("\nPlease enter the vehicle type of the new vehicle(Ex: SUV): ");
//            String newVehicleType = input.nextLine();
//            System.out.print("\nPlease enter the color of the new vehicle(Ex: Red): ");
//            String newColor = input.nextLine();
//            System.out.print("\nPlease enter the mileage of the new vehicle(Ex: 123456): ");
//            int newOdometer = input.nextInt();
//            System.out.print("\nPlease enter the price of the new vehicle(Ex: $10000): $");
//            double newPrice = input.nextDouble();
//            addNewVehicle(newVin, newMake, newModel, newYear, newVehicleType, newColor, newOdometer, newPrice);
//            System.out.println("\nYour new vehicle has been successfully added!\n\nReturning to main menu...\n");
//            Screens.mainMenuFlow();
//
//        } catch (Exception inputError) {
//            System.out.println("\nThere has been an input error. Please review your information and try again. ");
//            Screens.mainMenuFlow();
//        }
//    }
//
//    public static void processRemoveVehicleRequest() {
//        try {
//            ArrayList<Vehicle> tempVehicleList = allVehicles();
//            System.out.println("\nAll removable vehicles: ");
//            formatVehicles(tempVehicleList);
//            System.out.print("\nPlease enter the number of the vehicle you would like to remove (Ex: 2): ");
//            int removeInput = input.nextInt();
//            removeVehicle(tempVehicleList.get(removeInput - 1).vin());
//            System.out.println("\nYour new vehicle has been successfully removed!\n\nReturning to main menu...\n");
//            Screens.mainMenuFlow();
//        } catch (Exception inputError) {
//            System.out.println("\nThere has been an input error. Please review your chosen vehicle number and try again. ");
//            Screens.mainMenuFlow();
//        }
//    }
//
//    public static void processNewSalesContractRequest() {
//        try {
//            Date today = new Date();
//            System.out.println("Sales Contract Form:");
//            System.out.print("Please enter your first and last name (Ex. John Smith): ");
//            String nameInput = input.nextLine();
//            System.out.print("Please enter your email (Ex. johnsmithcars@gmail.com): ");
//            String emailInput = input.nextLine();
//            System.out.print("Please enter the VIN of the vehicle you would like to begin a contract with (Ex. 12345): ");
//            String vinInput = input.nextLine();
//            Vehicle vehicleInput = getVehicleByVin(vinInput);
//            if (vehicleInput == null || !vehicleInput.sold()) {
//                System.out.println("\nUnfortunately we could not find a vehicle with your chosen VIN. Please verify your information and try again!");
//                System.out.println("\nNow returning to the main menu...\n");
//                Screens.mainMenuFlow();
//                return;
//            }
//            SalesContract newSC = new SalesContract(0, today, nameInput, emailInput, false);
//            System.out.print("Will you be financing this vehicle today? (Y or N): ");
//            String yN = (input.nextLine()).toLowerCase();
//            if (yN.equals("y")) {
//                if (vehicleInput.sold()) {
//                    newSC.setFinanced(true);
//                    System.out.println("\nYour Total Cost: $" + df.format(newSC.getTotalPrice()) + " | Your (Estimated) Monthly Payment: $" + df.format(newSC.getMonthlyPayment()));
//                    vehicleInput.available(false);
//                    contractList.add(newSC);
//                    System.out.println("Your contract has been recorded! Thank you for financing through 'E & S', & we hope you enjoy your new " + vehicleInput.year() + " " + vehicleInput.make() + " " + vehicleInput.model() + "!");
//                    System.out.println("\nNow returning to the main menu...");
//                    Screens.mainMenuFlow();
//                } else {
//                    System.out.println("\nIt seems that the vehicle you selected was unavailable. Please choose a new vehicle and try again!");
//                    System.out.println("\nNow returning to the main menu...\n");
//                    Screens.mainMenuFlow();
//                }
//            } else if (yN.equals("n")) {
//                if (vehicleInput.sold()) {
//                    System.out.println("\nYour Total Cost: $" + df.format(newSC.getTotalPrice()));
//                    vehicleInput.available(false);
//                    contractList.add(newSC);
//                    System.out.println("Your contract has been recorded! Thank you for purchasing through 'E & S', & we hope you enjoy your new " + vehicleInput.year() + " " + vehicleInput.make() + " " + vehicleInput.model() + "!");
//                    System.out.println("\nNow returning to the main menu...");
//                    Screens.mainMenuFlow();
//                } else {
//                    System.out.println("\nIt seems that the vehicle you selected was unavailable. Please choose a new vehicle and try again!");
//                    System.out.println("\nNow returning to the main menu...\n");
//                    Screens.mainMenuFlow();
//                }
//            } else {
//                System.out.println("Please enter ('Y' or 'N') and try again.");
//                processNewSalesContractRequest();
//            }
//
//        } catch (Exception inputError) {
//            System.out.println("\nThere has been an input error. Please review your chosen info and try again. ");
//            Screens.mainMenuFlow();
//        }
//    }
//
//    public static void processNewLeaseContractRequest() {
//        try {
//            Date today = new Date();
//            System.out.println("Leasing Contract Form:");
//            System.out.print("Please enter your first and last name (Ex. John Smith): ");
//            String nameInput = input.nextLine();
//            System.out.print("Please enter your email (Ex. johnsmithcars@gmail.com): ");
//            String emailInput = input.nextLine();
//            System.out.print("Please enter the VIN of the vehicle you would like to begin a contract with (Ex. 12345): ");
//            String vinInput = input.nextLine();
//            String dateInput = dateFormatter.format(today);
//            Vehicle vehicleInput = getVehicleByVin(vinInput);
//            if (vehicleInput == null || vehicleInput.model().equalsIgnoreCase("null")) {
//                System.out.println("\nUnfortunately we could not find a vehicle with your chosen VIN. Please review your information and try again!");
//                System.out.println("\nNow returning to the main menu...\n");
//                Screens.mainMenuFlow();
//            } else {
//                LeaseContract newLS = new LeaseContract(dateInput, nameInput, emailInput, vehicleInput);
//                if (vehicleInput.sold()) {
//                    System.out.println("\nYour Estimated Total Cost: $" + df.format(newLS.getTotalPrice()) + " | Your (estimated) monthly total: $" + df.format(newLS.getMonthlyPayment()));
//                    vehicleInput.available(false);
//                    contractList.add(newLS);
//                    System.out.println("Your contract has been recorded! Thank you for leasing through 'E & S', & we hope you enjoy your new " + vehicleInput.year() + " " + vehicleInput.make() + " " + vehicleInput.model() + "!");
//                    System.out.println("\nNow returning to the main menu...");
//                    Screens.mainMenuFlow();
//                } else {
//                    System.out.println("\nIt seems that the vehicle you selected was unavailable. Please choose a new vehicle and try again!");
//                    System.out.println("\nNow returning to the main menu...\n");
//                    Screens.mainMenuFlow();
//                }
//            }
//        } catch (Exception inputError) {
//            System.out.println("\nThere has been an input error. Please review your chosen info and try again. ");
//            Screens.mainMenuFlow();
//        }
//    }
//
//    public static void formatVehicles(ArrayList<Vehicle> vehicleList) {
//        System.out.println("\n[~Vehicle Inventory~]");
//        System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-15s | %-10s | %-10s | %-15s |%n", "ID", "VIN", "Year", "Make", "Model", "Vehicle Type", "Color", "Price");
//        System.out.println("------------------------------------------------------------------------------");
//        int temp = 1;
//        for (Vehicle vehicle : vehicleList) {
//            System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-15s | %-10s | %-10s | %-15s |%n",
//                    temp++, vehicle.vin(), vehicle.year(), vehicle.make(), vehicle.model(), vehicle.vehicleType(), vehicle.color(), vehicle.price());
//        }
//        System.out.println("------------------------------------------------------------------------------");
//        System.out.println("\nRedirecting...");
//    }


}