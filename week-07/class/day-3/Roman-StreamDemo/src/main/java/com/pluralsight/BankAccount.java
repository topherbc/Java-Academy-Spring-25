package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BankAccount {
    ArrayList<Transaction> transactions;
    BankAccount(){
        this.transactions = new ArrayList<>();
    }
    BankAccount(int testFill){
        this.transactions = new ArrayList<>();
        for(int i = 0; i < testFill; i++){
            double rand = Math.random() * 100 + 1;
            this.addTransaction("Test Transaction: " + i, rand * (i%2==0? 1: -1));
        }
    }


    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }


    public void addTransaction(String desc, double amount){
        transactions.add(new Transaction(desc, LocalDate.now(), amount));
    }


    //Print out all transactions
    public void printAll(){
        //transactions.forEach(transaction -> System.out.println(transaction));
        transactions.forEach(System.out::println);
    }
//    //Exact same thing as normal for loop
//    public void printAllV2(){
//        for (Transaction transaction: transactions){
//            System.out.println(transaction);
//        }
//    }


    //Stream filter for deposits only
    public ArrayList<Transaction> depositsOnly(){
        return transactions.stream()
                .filter(transaction -> transaction.getAmount() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
//    public ArrayList<Transaction> depositsOnlyV2(){
//        ArrayList<Transaction> deposits = new ArrayList<>();
//        for (Transaction transaction : transactions){
//            if(transaction.amount > 0) deposits.add(transaction);
//        }
//        return deposits;
//    }



    //Stream filter for payments only
    public ArrayList<Transaction> paymentsOnly(){
        return transactions.stream().filter(transaction -> transaction.getAmount() < 0).collect(Collectors.toCollection(ArrayList::new));
    }
//    public ArrayList<Transaction> paymentsOnlyV2(){
//        ArrayList<Transaction> payments = new ArrayList<>();
//        for (Transaction transaction : transactions){
//            if(transaction.amount < 0) payments.add(transaction);
//        }
//        return payments;
//    }


    //Get transactions that are of the current year only
    public ArrayList<Transaction> currentYearOnly(){
        return transactions.stream().filter(transaction -> transaction.getDate().getYear() == LocalDate.now().getYear()).collect(Collectors.toCollection(ArrayList::new));
    }
//    public ArrayList<Transaction> currentYearOnlyV2(){
//        ArrayList<Transaction> transactionsThisYear = new ArrayList<>();
//        for (Transaction transaction : transactions){
//            if(transaction.getDate().getYear() == LocalDate.now().getYear()) transactionsThisYear.add(transaction);
//        }
//        return transactionsThisYear;
//    }


    //Map the Transaction Stream to a String Stream of transaction descriptions
    public ArrayList<String> getDescriptionsOnly(){
        //return transactions.stream().map(transaction -> transaction.getDescription()).collect(Collectors.toCollection(ArrayList::new));
        return transactions.stream().map(Transaction::getDescription).collect(Collectors.toCollection(ArrayList::new));
    }
//    public ArrayList<String> getDescriptionsOnlyV2(){
//        ArrayList<String> descriptions = new ArrayList<>();
//        for(Transaction transaction : transactions){
//            descriptions.add(transaction.getDescription());
//        }
//        return descriptions;
//    }

    public ArrayList<Double> getAmountsOnly(){
        //return transactions.stream().map(transaction -> transaction.getAmount()).collect(Collectors.toCollection(ArrayList::new));
        return transactions.stream().map(Transaction::getAmount).collect(Collectors.toCollection(ArrayList::new));
    }
//    public ArrayList<Double> getAmountsOnlyV2(){
//        ArrayList<Double> amounts = new ArrayList<>();
//        for(Transaction transaction : transactions){
//            amounts.add(transaction.getAmount());
//        }
//        return amounts;
//    }

    
    //Sum of all transactions
    public double sum(){
        //return transactions.stream().mapToDouble(transaction -> transaction.getAmount()).sum();
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }
//    public double sumV2(){
//        double sum = 0;
//        for(Transaction transaction : transactions){
//            sum += transaction.getAmount();
//        }
//        return sum;
//    }





    public boolean anyHaveDescription(String desc){
        return transactions.stream().anyMatch(transaction -> transaction.getDescription().equalsIgnoreCase(desc));
    }
//    public boolean anyHaveDescriptionV2(String desc){
//        for(Transaction transaction : transactions){
//            if(transaction.description.equalsIgnoreCase(desc)) return true;
//        }
//        return false;
//    }


    public boolean anyAtDate(LocalDate date){
        return transactions.stream().anyMatch(transaction -> transaction.getDate().equals(date));
    }
//    public boolean anyAtDateV2(LocalDate date){
//        for(Transaction transaction : transactions){
//            if(transaction.getDate().equals(date)) return true;
//        }
//        return false;
//    }


    public boolean allLessThan(double amount){
        return transactions.stream().allMatch(transaction -> transaction.getAmount() < amount);
    }
//    public boolean allLessThenV2(double amount){
//        for(Transaction transaction : transactions){
//            if(transaction.amount < amount) return false;
//        }
//        return true;
//    }

    public boolean allMoreThan(double amount){
        return transactions.stream().allMatch(transaction -> transaction.getAmount() > amount);
    }
//    public boolean allMoreThenV2(double amount){
//        for(Transaction transaction : transactions){
//            if(transaction.amount > amount) return false;
//        }
//        return true;
//    }


    public Transaction min() throws NoSuchElementException {
        return transactions.stream().min(Transaction::compareTo).get();
    }
    public Transaction max() throws NoSuchElementException {
        return transactions.stream().max(Transaction::compareTo).get();
    }
}
