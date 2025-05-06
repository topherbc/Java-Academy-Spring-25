package com.pluralsight;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        /*
        Addresses

            name Test Person
            apt_num
            street_num 123
            street main st
            city
            state
            country
            zipcode-areacode 19811
            planet
            solarsystem

            Address personsAddress = new Address(street_num, street, zip)





         */

        //immutable - not mutatable or - non changeable
        //constant
        final String file_name = "employees_ranking.csv";

        final int counter = 0;

        Car shelby = new Car("Ford", "Shelby"); //2022

        Car camaro = new Car("Chevrolet", "Zl1 le");

        Car porsche = new Car("Porsche");

        porsche.setModel("GT4");

        System.out.println(porsche.getModel());

        Car bently = new Car();


        bently.setMake("Bently");

        shelby.accelerate(320); //kmh
        camaro.accelerate(220); //mph

        //accessing methods/attributes by using dot notation
//        System.out.println(shelby.getSpeed());
//        System.out.println(camaro.getSpeed());

        //camaro loosing control
        camaro.brake(60);

//        System.out.println(shelby.getSpeed());
//        System.out.println(camaro.getSpeed());

        int numsAdd = add(1, 2);
        String stringsAdd = add("First Name", "Last Name");
        double doublesAdd = add(1.10, 2.2, 1.0);

        int aloneAdd = add(2);
        String addedVals = add("cat", 2);

//        System.out.println(add(2));


    }

//    accessModifier static returnDataType methodName(parameterType parameter (optional)) {
//        return responseData; (optional)
//    }

    //Overloading by providing different method signatures, with the same name

    //Add method signature = int add(int x, int y)
    public static int add(int x, int y) {
        return x + y;
    }

    //Add method signature = int add(int x)
    //Overloaded method
    public static int add(int x) {
        return x + 0;
    }

    //Overloaded method
    public static String add(String x, int y) {
        return x + y;
    }

    //Overloaded method
    public static double add(double x, double y, double z){
        return x + y + z;
    }

    //Overloaded method
    public static String add(String x, String y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }
}
