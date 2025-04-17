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

    public void load() {
//        int loadingTime = 0;
//        while(loadingTime < 5) {
//            System.out.println("Loading... " + loadingTime+1);
//            loadingTime++; //negate condition after 5ish times
//        }

        //comparing, i == loadingTime with functionality of these loops
        //for (variable and start position; condition; modifier amount)
        for (int i = 0; i < 5; i++) {
            System.out.println("Loading... " + i);
        }

        System.out.println("Loaded " + this.name);
    }
}
