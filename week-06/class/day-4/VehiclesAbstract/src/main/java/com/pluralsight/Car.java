package com.pluralsight;

public class Car extends Vehicle {

    public Car(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
    }

    @Override
    public int getSpeed() {
        return 0;
    }

}
