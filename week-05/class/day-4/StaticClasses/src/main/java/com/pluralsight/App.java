package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //instantiation  == to create an instance of
        //instance = object based on a class blueprint
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        System.out.print("Prefix (Not Required): ");
        String prefix = input.nextLine();

        System.out.print("First Name (Required): ");
        String firstName = input.nextLine();

        System.out.print("Middle Name (Not Required): ");
        String middleName = input.nextLine();

        System.out.print("Last Name (Required): ");
        String lastName = input.nextLine();

        System.out.print("Suffix (Not Required): ");
        String suffix = input.nextLine();

        System.out.println(Math.PI);

        System.out.println(NameFormatter.format(prefix, firstName, middleName, lastName, suffix));
    }

    public static void exampleBankAccount() {
        BankAccount myAccount = new BankAccount(100, "Name");

        Transfer.send(100, myAccount);
    }
}
