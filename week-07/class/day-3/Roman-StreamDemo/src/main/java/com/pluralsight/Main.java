package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Setting up test values
        BankAccount account = new BankAccount(20);


        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        numbers.stream().forEach(n -> System.out.println(n));
        numbers.stream().forEach(System.out::println);

        for (int n : numbers) {
            System.out.println(n);
        }

        for (int n : numbers) {
            System.out.println(n + 10);//map
            //if() //filter
            //sum += //reducer
        }







       // account.printAll();
        account.depositsOnly().forEach(System.out::println);
        account.depositsOnly().forEach(transaction -> System.out.println(transaction));
        System.out.println(account.sum());
    }
}
