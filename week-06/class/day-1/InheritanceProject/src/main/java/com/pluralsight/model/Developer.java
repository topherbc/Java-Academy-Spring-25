package com.pluralsight.model;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);  // Call parent constructor
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        super.work();  // Call parent method
        System.out.println(name + " is coding in " + programmingLanguage);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent method
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
    }

    // Developer-specific method
    public void debug() {
        System.out.println(name + " is debugging code.");
    }
}