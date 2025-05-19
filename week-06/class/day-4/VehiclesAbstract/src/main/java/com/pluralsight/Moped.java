package com.pluralsight;

public class Moped extends Vehicle {
    public Moped(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
