package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create all vehicle types with some default values
        System.out.println("Creating all vehicle types...");

        // Create a car
        Car car = new Car(5, 500, 60, "Red");

        // Create a moped
        Moped moped = new Moped(2, 50, 15, "Yellow");

        // Create a semi truck
        SemiTruck semiTruck = new SemiTruck(2, 25000, 500, "Blue");

        // Create a hovercraft
        Hovercraft hovercraft = new Hovercraft(10, 1000, 200, "Silver");

        // Show menu and let user choose which vehicle to view
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n=== Vehicle Information System ===");
            System.out.println("Which vehicle would you like to see information about?");
            System.out.println("1. Car");
            System.out.println("2. Moped");
            System.out.println("3. Semi Truck");
            System.out.println("4. Hovercraft");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(car);
                    break;
                case 2:
                    System.out.println(moped);
                    break;
                case 3:
                    System.out.println(semiTruck);
                    break;
                case 4:
                    System.out.println(hovercraft);
                    break;
                case 5:
                    System.out.println("Thank you for using the Vehicle Information System!");
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
