package com.pluralsight;

public class Moped extends Vehicle implements Driveable {
    public Moped(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
    }

    @Override
    public void accelerate(int pressure) {

    }

    @Override
    public void brake(int pressure) {

    }

    @Override
    public int steer(char rotate) {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
