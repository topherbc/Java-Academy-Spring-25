package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Clothes shirt = new Clothes(true, "t-shirt", "purple", "cotton", 1.99, "M", 0.0055f);
        Clothes pants = new Clothes(true, "pants", "black", "denim", 100.99, "XL", 0.0055f);

//        System.out.println(shirt.getType());
//
//        System.out.println(pants.getType());

        House ourCoolNewHouse = new House("2", 7, 5, 25, 2, true, "Big one", 15, 2025);

        House ourNotSoGreatHouse = new House("0", 1, 0, 0, 0, false, "outhouse kitchen", 1, 1610);





        Scanner keyboard = new Scanner(System.in);

        add("3", "4");

    }

    public static void add(String x, String y) {
        System.out.println("Nah, we're not adding anything for you");
    }





}
