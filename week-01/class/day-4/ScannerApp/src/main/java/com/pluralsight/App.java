package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter is your total order cost: ");
        int total = input.nextInt();
//
        System.out.printf("Your total is: %s", "something");

//        System.out.println("Your name is: " + total);

        int id = 10135;
        String name = "Brandon Plyers";
        float pay = 5239.77f;

        System.out.printf("%s (id: %d) $%.0f \n", name, id, pay);
        System.out.println(name + " (id: " + id + ") $" + pay);

    }
}
