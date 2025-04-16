package com.pluralsight;

public class Clothes {
    private boolean coldTempReady;
    private String type;
    private String color;
    private String material;
    private double price;
    private String size;
    private float weight;

    public Clothes(boolean coldTempReady, String type, String color, String material, double price, String size, float weight) {
        this.coldTempReady = coldTempReady;
        this.color = color;
        this.type = type;
        this.material = material;
        this.price = price;
        this.size = size;
        this.weight = weight;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public boolean getColdTempReady() {
        return this.coldTempReady;
    }
}
