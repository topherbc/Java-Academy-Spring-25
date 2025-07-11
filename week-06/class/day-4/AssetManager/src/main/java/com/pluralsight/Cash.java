package com.pluralsight;

public class Cash extends Asset{
    public Cash(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    @Override
    public double getValue() {
        return this.originalCost;
    }
}
