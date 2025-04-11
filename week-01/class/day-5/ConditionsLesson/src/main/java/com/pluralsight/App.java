package com.pluralsight;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your cars year: ");

        int carYear = keyboard.nextInt();

        carYear--;

        if (carYear < 2005){
            System.out.printf("Please get a newer car, your car is this old: %d", carYear);
        } else {
            System.out.println("New car, you're all good");
            System.out.print("New car, you're all good \n");
        }

    }

}
