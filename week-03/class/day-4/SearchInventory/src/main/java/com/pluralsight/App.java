package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Logger.log("program launch");
        ArrayList<Product> inventory = getInventory();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("---Welcome to the Inventory Management System---\n");

        while(true) {
            System.out.println("Please choose from the following options\n\n");

            System.out.println("What do you want to do?");
            System.out.println("\t1- List all products\n" +
                    "\t2- Lookup a product by its id\n" +
                    "\t3- Find all products within a price range\n" +
                    "\t4- Add a new product\n" +
                    "\t5- Quit the application\n");
            System.out.print("Enter Selection: ");
            int selection = keyboard.nextInt();
            keyboard.nextLine();
            Logger.log("user selection : " + selection);

            switch (selection) {
                case 1:
                    viewAllInventory(inventory);
                    System.out.print("Continue to menu (Hit Enter): ");
                    keyboard.nextLine();
                    break;
                case 5:
                    Logger.log("program exit");
                    System.exit(0);
                default:
                    Logger.error("invalid selection made : " + selection);
                    System.out.println("Invalid option selected, please try again\n");
            }
        }
    }

    public static ArrayList<Product> getInventory() {
        Logger.log("get inventory : invoked");
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line;

            while((line = br.readLine()) != null) {
                //line == 4567|10' 2x4  (grade B)|9.99 first time
                String[] splitItems = line.split(Pattern.quote("|"));

                inventory.add(new Product(Integer.parseInt(splitItems[0]), splitItems[1], Double.parseDouble(splitItems[2])));
            }

        } catch(IOException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        }
        
        Logger.log("get inventory : complete");
        return inventory;

    }

    public static void viewAllInventory(ArrayList<Product> inventory) {
        Logger.log("view all inventory : invoked");
        for(Product product : inventory) {
            System.out.printf("Name: %s, Price: $%.2f\n", product.getName(), product.getPrice());
        }
        Logger.log("view all inventory : complete");
    }
}
