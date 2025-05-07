package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Reservation r = new Reservation("king", 10, true);

        Employee samaria = new Employee(123, "Samaria Barron", "Electronics", 100.00);

        samaria.punchTimeCard(8.0);
        samaria.punchTimeCard(17.0);

        System.out.println(samaria.getTotalPay());
    }
}
