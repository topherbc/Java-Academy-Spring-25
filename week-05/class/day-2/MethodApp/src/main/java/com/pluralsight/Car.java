package com.pluralsight;

public class Car {
    // attributes
    private String make;
    private String model;
    private String color;
    private int speed;

    // constructor
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.speed = 0;
    }

    //Overloaded constructor
    public Car(String make) {
        this.make = make;
        this.model = "";
        this.speed = 0;
    }

    //Overloaded parameterless constructor
    public Car() {
        this.make = "";
        this.model = "";
        this.speed = 0;
    }

    // getters and setters
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this. model = model;
    }

    public int getSpeed() {
        return this.speed;
    }

    // no setter for speed
    // other methods
    public void accelerate(int changeInSpeed) {
        this.speed += changeInSpeed;
    }

    public void brake(int changeInSpeed) {
        if(changeInSpeed > this.speed){
            this.speed = 0;
        } else {
            this.speed -= changeInSpeed;
        }
    }
}