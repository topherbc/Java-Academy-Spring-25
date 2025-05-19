package com.pluralsight;

public class SemiTruck extends Vehicle {
    public SemiTruck(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
