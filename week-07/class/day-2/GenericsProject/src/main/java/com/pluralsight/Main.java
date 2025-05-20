package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //Generics == any data type

        Playground<Swinging> swingingPlayground = new Playground<>();
        Playground<Tag> tagPlayground = new Playground<>();

        ArrayList<String> stringArrayList = new ArrayList<>();


        Item coolItem1 = new Item("Cool Data");

        coolItem1.getName();

        // Create a Box that holds a String
        Box<String> stringBox = new Box<>("Hello, Generics!");
        System.out.println(stringBox);





//
//
//        // Get content from the box and use String methods
//        String message = stringBox.getContent();
//        System.out.println("Message length: " + message.length());
//
//        // Create a Box that holds an Integer
//        Box<Integer> intBox = new Box<>(42);
//        System.out.println(intBox);
//
//        // You can also create an empty box and add content later
//        Box<Double> emptyBox = new Box<>();
//        System.out.println(emptyBox);
//        emptyBox.setContent(3.14159);
//        System.out.println(emptyBox);
//
//        // Create a Box that holds our custom Item class
//        Item laptop = new Item("Laptop", 999.99);
//        Box<Item> itemBox = new Box<>(laptop);
//        System.out.println(itemBox);
//
//        // We can safely get the Item without casting
//        Item retrievedItem = itemBox.getContent();
//        System.out.println("Retrieved: " + retrievedItem.getName() +
//                " costs $" + retrievedItem.getPrice());
//
//        // The same Box class works with ANY type!
//        Box<Boolean> boolBox = new Box<>(true);
//        System.out.println(boolBox);
    }
}
