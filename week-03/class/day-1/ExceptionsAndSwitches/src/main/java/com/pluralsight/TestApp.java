package com.pluralsight;

public class TestApp {
    public static void main(String[] args) {
        Human one = new Human("Test Human 1", 2, 2, 2, 1);
        Human alienHumanoid = new Human("Alien Human", 6, 3, 2, 4);

        System.out.println(one.getName());
        System.out.println(alienHumanoid.getName());


        //start lower case, other words after are UpperCased



    }
}
