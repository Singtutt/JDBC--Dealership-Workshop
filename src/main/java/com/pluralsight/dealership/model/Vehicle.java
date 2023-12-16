package com.pluralsight.dealership.model;

public record Vehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer,
                      double price, boolean sold) {

    @Override
    public String toString() {
        return String.format("| %-22s | %-5s | %-15s | %-15s | %-15s | %-10s | %-10s | %-15s |%n",
                vin, year, make, model, vehicleType, color, price, sold);
    }

    @Override
    public boolean equals(Object instance) {
        if (this == instance)
            return true;
        if (instance == null || getClass() != instance.getClass())
            return false;
        Vehicle vehicle = (Vehicle) instance;
        return vin.equals(vehicle.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }
}
