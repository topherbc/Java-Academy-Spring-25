package com.pluralsight;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        /*
        Create a Java application named PayrollCalculator that prompts the user to enter:
        − their name
        − their hours worked (a floating point number)
        − their pay rate (a floating point number) Calculate their gross pay.
        Display the employee's name and their gross pay
         */
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = keyboard.nextLine();

        System.out.print("Please enter your hours worked: ");
        float hours = keyboard.nextFloat();

        System.out.print("Please enter your pay rate: ");
        float payRate = keyboard.nextFloat();


        System.out.println("Employee Name: " + name + ", Pay Rate: " + payRate * hours);
        System.out.printf("Employee Name: %s, Pay Rate: %.200f", name, payRate * hours);

    }
}
