package com.pluralsight.model;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);  // Call parent constructor
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        super.work();  // Call parent method
        System.out.println(name + " is managing a team of " + teamSize + " people.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent method
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }

    // Manager-specific method
    public void holdMeeting() {
        System.out.println(name + " is holding a team meeting.");
    }
}
