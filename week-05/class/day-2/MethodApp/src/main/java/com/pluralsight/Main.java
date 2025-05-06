package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        Car shelby = new Car("Ford", "Shelby"); //2022

        Car camaro = new Car("Chevrolet", "Zl1 le");

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
        double doublesAdd = add(1.10, 2.2);

        int aloneAdd = add(2);
        String addedVals = add("cat", 2);

        System.out.println(add(2));


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
    public static double add(double x, double y){
        return x + y;
    }

    //Overloaded method
    public static String add(String x, String y) {
        return x + y;
    }
}
