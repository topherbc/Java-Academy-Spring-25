package com.pluralsight;

public interface Driveable {

    void accelerate(int pressure);

    void brake(int pressure);

    int steer(char rotate); //L or R

    int getSpeed();

}
