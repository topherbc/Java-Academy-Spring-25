package com.pluralsight;

public abstract class Vehicle {

    private int numberOfPassengers, cargoCapacity, fuelCapacity;
    private String color;

    public Vehicle(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
        this.color = color;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-8s | %-12s | %-15s | %-13s",
                this.getClass().getSimpleName(),
                color,
                numberOfPassengers + " passengers",
                cargoCapacity + " L cargo",
                fuelCapacity + " L fuel");
    }
}
