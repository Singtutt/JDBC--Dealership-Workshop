package com.pluralsight.dealership.model;

public class Vehicle {
    public double price;
    public boolean available;
    public int vin, year, odometer;
    public String make, model, vehicleType, color;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.price = price;
        this.vin = vin;
        this.year = year;
        this.odometer = odometer;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.available = true;
    }

    public double getPrice() {
        return price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
