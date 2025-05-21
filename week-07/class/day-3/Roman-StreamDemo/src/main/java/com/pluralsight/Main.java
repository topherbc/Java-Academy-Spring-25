package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        //Setting up test values
        BankAccount account = new BankAccount(20);

       // account.printAll();
        account.depositsOnly().forEach(System.out::println);
        account.depositsOnly().forEach(transaction -> System.out.println(transaction));
        System.out.println(account.sum());
    }
}
