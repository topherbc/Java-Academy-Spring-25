package com.pluralsight.collection;

public class Main {
    public static void main(String[] args) {
        FixedList<Integer> numbers = new FixedList<>(4);
        numbers.add(999);
        numbers.add(12);
        numbers.add(14);
        numbers.add(8000);

        System.out.println(numbers.getItems());

        numbers.add(747);

        System.out.println(numbers.getItems());
    }
}
