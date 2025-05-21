package com.pluralsight;

import java.time.LocalDate;

public class Transaction implements Comparable {
    private String description;
    private LocalDate date;
    private double amount;

    Transaction(String description, LocalDate date, double amount){
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s, %s - %.2f", description, date, amount);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
