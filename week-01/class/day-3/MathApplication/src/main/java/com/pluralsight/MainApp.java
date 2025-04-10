package com.pluralsight;

public class MainApp {
    public static void main(String[] args) {

        //String example, Concatenation Example

        String example_1 = "good words";

        int example_2 = 10;


//        System.out.println(example_1 + " " + example_2);

        /*
        Multiple
        Lines
        In
        A
        Comment

         */

        //Addition assignments


        int x = 10;

//        System.out.println(x);

//        x = x + 20;

        x += 20;

//        System.out.println(x);






        // Exercise 2

        /*
            Question 1. Create two variables to represent the
            salary for Bob and Gary, name them
            bobSalary and garySalary. Create a new variable named
            highestSalary. Determine whose salary is greater using
            Math.max() and
            store the answer in highestSalary.
            Set the initial salary variables to any value
            you want. Print the answer (i.e "The highest salary is …)
         */

        float bobSalary = 12000f;
        float garySalary = 10000f;

        double highestSalary = Math.max(bobSalary, garySalary);

        System.out.println("The highest salary is " + highestSalary);

        /*
        Question 3.Find and display the area of a circle whose radius is 7.25
         */


        float radius = 7.25f;


        System.out.println("Area of a circle with radius of " + radius + " is: " + Math.PI * Math.pow(radius, 2));


        /*
        Question 5. Find and display the distance between the points
        (5, 10) and (85, 50)
         */

        short x1 = 5;
        short y1 = 10;
        short x2 = 85;
        short y2 = 50;

        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

        System.out.println(x1 - x2);
        System.out.println(y1 - y2);
        System.out.println(distance);


        // Question 7

        System.out.println(Math.random());


    }
}
