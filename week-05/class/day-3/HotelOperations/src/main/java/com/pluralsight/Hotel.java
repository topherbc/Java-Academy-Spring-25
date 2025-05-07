package com.pluralsight;

public class Hotel {
    private int numberOfSuites, numberOfRooms, bookedSuites, bookedBasicRooms;
    private String name;

    public Hotel(int numberOfSuites, int numberOfRooms, String name) {
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.name = name;
    }

    public Hotel(int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms, String name) {
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
        this.name = name;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= this.getAvailableSuites()) {
                this.bookedSuites += numberOfRooms;
                return true;
            }
        } else {
            if (numberOfRooms <= this.getAvailableRooms()) {
                this.bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedBasicRooms;
    }

    public String getName() {
        return name;
    }
}
