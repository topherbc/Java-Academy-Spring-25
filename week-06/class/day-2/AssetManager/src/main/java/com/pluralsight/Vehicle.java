package com.pluralsight;

import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year, odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        double reducedValue = getOriginalCost();

        if (age <= 3) { //year == 0, 1, 2, 3
            reducedValue *= Math.pow(0.97, age);
        } else if (age <= 6) {
            reducedValue *= Math.pow(0.94, age);
        } else if (age <= 10) {
            reducedValue *= Math.pow(0.92, age);
        } else if (age > 10) {
            reducedValue = 1000;
        }

        if (odometer > 100000 && (!makeModel.toLowerCase().contains("honda") || !makeModel.toLowerCase().contains("toyota"))) {
            reducedValue *= .75;
        }

        return reducedValue;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
