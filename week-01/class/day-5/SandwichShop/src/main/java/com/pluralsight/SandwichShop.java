package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner waiter = new Scanner(System.in);
        float regularSize = 5.45f;
        float largeSize = 8.95f;

        System.out.println("Welcome Big T's Sandwich Shoppe");

        System.out.print("Please choose a sandwich size (Enter 1 for Regular, 2 for Large): ");
        int option = waiter.nextInt();

        waiter.nextLine(); //consume the CRLF

        System.out.print("Hey, please choose something with words (yes/no): ");
        String loaded = waiter.nextLine();

        if (loaded.equals("yes")) {
            System.out.println("Hey, you chose yes!");
        } else {
            System.out.println("nope you chose no");
        }

        System.out.print("Please enter your age for a discount: ");

        int age = waiter.nextInt();

        float base = 0f;

        if (option == 1) {
            base = regularSize;
        } else if (option == 2) {
            base = largeSize;
        } else {
            System.out.println("Please choose a correct option, 1 or 2; Please restart the app;");
        }

        double discount = 0.0;

        if (age <= 17) {
            discount = 0.10;
        } else if (age >= 65) {
            discount = 0.20;
        }

        System.out.printf("Your total is: $%.2f", base * (1-discount));




    }
}
