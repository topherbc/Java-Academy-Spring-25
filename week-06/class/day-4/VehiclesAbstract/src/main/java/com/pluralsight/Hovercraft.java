package com.pluralsight;

public class Hovercraft extends Vehicle {
    public Hovercraft(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
