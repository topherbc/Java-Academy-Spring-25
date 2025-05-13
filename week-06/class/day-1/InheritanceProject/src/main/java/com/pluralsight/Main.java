package com.pluralsight;

import com.pluralsight.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Inheritance and Super Demo ===\n");

        // Create instances
        Employee employee = new Employee("John", 1001, 50000);
        Developer developer = new Developer("Alice", 1002, 75000, "Java");
        Manager manager = new Manager("Bob", 1003, 90000, 5);
        
        // Show inheritance in action
        System.out.println("1. Basic Employee:");
        employee.displayInfo();
        employee.work();

        System.out.println("\n2. Developer (extends Employee):");
        developer.displayInfo();  // Calls overridden method which uses super
        developer.work();         // Calls overridden method which uses super
        developer.debug();        // Developer-specific method

        System.out.println("\n3. Manager (extends Employee):");
        manager.displayInfo();    // Calls overridden method which uses super
        manager.work();           // Calls overridden method which uses super
        manager.holdMeeting();    // Manager-specific method

        System.out.println("\n=== Polymorphism Example ===");
        // Array of Employee references pointing to different object types
        Employee[] employees = {employee, developer, manager};

        for (Employee emp : employees) {
            System.out.println("\n--- " + emp.getClass().getSimpleName() + " ---");
            emp.displayInfo();  // Calls the overridden version for each type
            emp.work();         // Calls the overridden version for each type
        }
    }
}
