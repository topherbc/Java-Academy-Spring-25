package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String contains = "id|description|quantity|price";
        String input = "111|Hot Chocolate (12-count)|21|4.99";

        String[] tokens = input.split(Pattern.quote("|"));
//        System.out.println(input);

        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        int quantity = Integer.parseInt(tokens[2]);
        double price = Double.parseDouble(tokens[3]);

        String example = "10.5";

        String valueToAdd = "100";


//        System.out.println(Double.parseDouble(example) + Integer.parseInt(valueToAdd));


        String userInput = "12/17/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


        LocalDate birthDay = LocalDate.parse(userInput, formatter);
        //yyyy-mm-dd
        System.out.println(birthDay.getMonth());


    }
}
