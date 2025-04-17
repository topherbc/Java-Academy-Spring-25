package com.pluralsight;

public class VideoGame {
    private String name, type;
    private boolean preowned, digital;
    private double price;

    public VideoGame() {
        this.name = "";
        this.type = "";
        this.price = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPreowned() {
        return preowned;
    }

    public void setPreowned(boolean preowned) {
        this.preowned = preowned;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
