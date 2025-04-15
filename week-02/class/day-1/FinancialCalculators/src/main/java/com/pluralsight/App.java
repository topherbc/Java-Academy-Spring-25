package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter your loan principal amount: ");
        float principal = keyboard.nextFloat();

        System.out.print("Please enter your interest rate: ");
        float interestRate = keyboard.nextFloat() / 100;

        System.out.print("Please enter your loan length (in years): ");
        float loanLength = keyboard.nextFloat();

        double numberOfMonths = 12 * loanLength;

        double monthlyInterestRate = interestRate / 12;

        //M=P×(i*(1+i)^n / ((1+i)^n)-1)
        double monthlyPayment = principal * (monthlyInterestRate * Math.pow(1+monthlyInterestRate, numberOfMonths) / (Math.pow(1+monthlyInterestRate, numberOfMonths)-1));

        System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total Interest: $%.2f", (monthlyPayment * numberOfMonths)-principal);

        // System.out.printf("Monthly Payment: $%.2f\nTotal Interest: $%.2f", monthlyPayment, (monthlyPayment * numberOfMonths)-principal);


    }
}
