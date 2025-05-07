package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return this.roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        //roomType == "king", price = 139
        //roomType == "double", price = 124

        double originalPrice = 0;

        if (this.roomType.equalsIgnoreCase("king")) {
            originalPrice = 139;
        } else {
            originalPrice = 124;
        }

        if (this.isWeekend) {
            originalPrice *= 1.10; //Increases by 10%
        }

        return originalPrice;
    }

    public int getNumberOfNights() {
        return this.numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationTotal() {
        return getPrice() * getNumberOfNights();
    }
}
