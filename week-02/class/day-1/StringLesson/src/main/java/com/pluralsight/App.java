package com.pluralsight;

import java.util.regex.Pattern; //JDK

public class App {
    public static void main(String[] args) {
        String welcome = "Big Tex says \"Howdy\"!";
        String welcome2 = "Let's get this started!";


//        System.out.println(welcome);

//        System.out.println(welcome2);

        String var = "ABC";

        String varPart1 = "a";

        String varPart2 = "b";

        String varPart3 = "c";

        String var2 = varPart1 + varPart2 + varPart3;

//        System.out.println(var);
//        System.out.println(var2);

        if (var.equalsIgnoreCase(var2)) {
//            System.out.println("Is this true?");
        } else {
//            System.out.println("It is not true");
        }



        String userInput = "Sir Albert Einstein";

//        System.out.println(userInput.indexOf("i"));



        String discountCode = "FAIR-15OFF";


        if (discountCode.endsWith("OFF")) {
//            System.out.println("Yes");
        }

        String productCode = "ACME-12213";

        int dashPosition = productCode.indexOf("-");

        String vendor = productCode.substring(0, dashPosition);
        String productNum = productCode.substring(dashPosition + 1);
        // : colon
        // ; semi-colon
//        System.out.println(vendor);
//        System.out.println(productNum);


        String input = "Dallas|Ft. Worth|Austin";
//        String[] cities = input.split("\\|");
        String[] cities = input.split(Pattern.quote("|"));
        // | bar

        // delimiter

        System.out.println(cities[0]);
        System.out.println(cities[1]);
        System.out.println(cities[2]);
        System.out.println(cities[3]);












    }
}
