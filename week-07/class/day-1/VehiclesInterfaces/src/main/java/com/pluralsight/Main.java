package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Vehicle> allVehicles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create all vehicle types with some default values
        System.out.println("Creating all vehicle types...");

        loadVehicles();

//        Vehicle v = new Vehicle(); // doesn't work, abstract class

        Car sampleCar = new Car(5, 500, 60, "Red");

        Moped sampleMoped = new Moped(2, 50, 15, "Yellow");

        SemiTruck sampleSemiTruck = new SemiTruck(2, 25000, 500, "Blue");

        Hovercraft sampleHovercraft = new Hovercraft(10, 1000, 200, "Silver");

        // Show menu and let user choose
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n=== Vehicle Information System ===");
            System.out.println("Which vehicle would you like to see information about?");
            System.out.println("1. Car");
            System.out.println("2. Moped");
            System.out.println("3. Semi Truck");
            System.out.println("4. Hovercraft");
            System.out.println("5. Show All Vehicles (Polymorphic!)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(sampleCar);
                    break;
                case 2:
                    System.out.println(sampleMoped);
                    break;
                case 3:
                    System.out.println(sampleSemiTruck);
                    break;
                case 4:
                    System.out.println(sampleHovercraft);
                    break;
                case 5:
                    // Polymorphic behavior - treating all different types as Vehicle
                    System.out.println("All Vehicles in Our Fleet:");
                    System.out.println("========================");

                    for (Vehicle vehicle : allVehicles) {
                        if (vehicle instanceof Car) {
                            System.out.println("This is a car");
                        } else if (vehicle instanceof Moped) {
                            System.out.println("This is a MOPED");
                        }
                        System.out.println(vehicle);
                        System.out.println("");
                    }

                    System.out.print("Please hit enter to return to the main menu ");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Thank you for using the Vehicle Information System!");
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }

    public static void loadVehicles() {
        // Add 5 cars with different properties
        allVehicles.add(new Car(5, 500, 60, "Red"));
        allVehicles.add(new Car(4, 450, 55, "Green"));
        allVehicles.add(new Car(2, 300, 45, "Black"));
        allVehicles.add(new Car(7, 600, 70, "White"));
        allVehicles.add(new Car(3, 400, 50, "Blue"));

        // Add 5 mopeds with different properties
        allVehicles.add(new Moped(2, 40, 10, "Blue"));
        allVehicles.add(new Moped(1, 30, 12, "Pink"));
        allVehicles.add(new Moped(2, 50, 15, "Orange"));
        allVehicles.add(new Moped(2, 35, 8, "Yellow"));
        allVehicles.add(new Moped(1, 45, 14, "Purple"));

        // Add 5 semi trucks with different properties
        allVehicles.add(new SemiTruck(2, 25000, 500, "Blue"));
        allVehicles.add(new SemiTruck(3, 30000, 600, "Red"));
        allVehicles.add(new SemiTruck(2, 20000, 450, "Green"));
        allVehicles.add(new SemiTruck(2, 35000, 700, "Silver"));
        allVehicles.add(new SemiTruck(3, 28000, 550, "Black"));

        // Add 5 hovercrafts with different properties
        allVehicles.add(new Hovercraft(12, 1500, 250, "Silver"));
        allVehicles.add(new Hovercraft(8, 800, 180, "Gold"));
        allVehicles.add(new Hovercraft(15, 2000, 300, "Purple"));
        allVehicles.add(new Hovercraft(10, 1200, 220, "Bronze"));
        allVehicles.add(new Hovercraft(20, 2500, 400, "Platinum"));
    }
}
