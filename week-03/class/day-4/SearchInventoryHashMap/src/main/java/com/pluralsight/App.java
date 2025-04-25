package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
//        runMaps();
        Logger.log("program launch");
        HashMap<Integer, Product> inventory = getInventory();

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
            keyboard.nextLine(); //consume CRLF
            Logger.log("user selection : " + selection);

            // If statement comparing to switch below
//            if (selection == 1) {
//                viewAllInventory(inventory);
//                System.out.print("Continue to menu (Hit Enter): ");
//                keyboard.nextLine();
//            } else if (selection == 5) {
//                Logger.log("program exit");
//                System.exit(0);
//            } else {
//                Logger.error("invalid selection made : " + selection);
//                System.out.println("Invalid option selected, please try again\n");
//            }

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

    public static HashMap<Integer, Product> getInventory() {
        Logger.log("get inventory : invoked");

        HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line;

            while((line = br.readLine()) != null) {
                //line == 4567|10' 2x4  (grade B)|9.99 first time
                String[] splitItems = line.split(Pattern.quote("|"));

                int id = Integer.parseInt(splitItems[0]);

                inventory.put(id, new Product(id, splitItems[1], Double.parseDouble(splitItems[2])));
            }

        } catch(IOException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        }

        Logger.log("get inventory : complete");
        return inventory;
    }

    public static void viewAllInventory(HashMap<Integer, Product> inventory) {
        Logger.log("view all inventory : invoked");

        for(Product product : inventory.values()) {
            System.out.printf("Name: %s, Price: $%.2f\n", product.getName(), product.getPrice());
        }

        Logger.log("view all inventory : complete");
    }


    public static void runMaps() {
        HashMap<String, String> statesAndCapitals = new HashMap<String, String>();
        //0       1        2 -- index
//        {"one", "blue", "aligator"}

        statesAndCapitals.put("PA", "Harrisburg");
        statesAndCapitals.put("SC", "Columbia");
        statesAndCapitals.put("TR", "Ankara");
        statesAndCapitals.put("GA", "Georgia");
        statesAndCapitals.put("AZE", "Baku");
        statesAndCapitals.put("cactus", "monkeytail");


//        System.out.println(statesAndCapitals.get("PA"));

        for(String capital : statesAndCapitals.values()) {
            if (capital.contains("g")) {
                System.out.println(capital);
            }
        }

        for(String state : statesAndCapitals.keySet()) {
            if (state.startsWith("A")) {
                System.out.println(state);
            }
        }


    }




}
