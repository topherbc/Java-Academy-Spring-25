package com.pluralsight;

public class House {
    private String floors;
    private int bathrooms;
    private int bedrooms;
    private int windows;
    private int balcony;
    private boolean garage;
    private String kitchen;
    private int doors;
    private int yearBuilt;

    public House(String floors, int bathrooms, int bedrooms, int windows, int balcony, boolean garage, String kitchen, int doors, int yearBuilt) {
        this.floors = floors;
        this.balcony = balcony;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.windows = windows;
        this.garage = garage;
        this.kitchen = kitchen;
        this.yearBuilt = yearBuilt;
        this.doors = doors;
    }

    public int getYearBuilt() {
        return this.yearBuilt;
    }





}
