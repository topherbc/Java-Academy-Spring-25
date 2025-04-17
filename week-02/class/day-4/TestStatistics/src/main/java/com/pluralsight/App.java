package com.pluralsight;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] testScores = {100, 99, 80, 65, 70, 75, 95, 85, 80, 60};

//        System.out.println(testScores[testScores.length-1]); //retrieves last value from array


        int sum = 0;

        int high = testScores[0];

        int low = 100;

        //i == iterator
        for (int index = 0; index < testScores.length; index++) {
            sum += testScores[index];

            if (high < testScores[index]) {
                high = testScores[index];
            }

        }

        //for each loop
        for (int testScore : testScores) {
            System.out.println(testScore);
        }

        int average = sum / testScores.length;
        Arrays.sort(testScores);

        System.out.println("Grade average: " + average);
        System.out.println("Other Highest Grade: " + testScores[0]);
        System.out.println("Highest Grade: " + high);
        System.out.println("Other Highest Grade: " + testScores[testScores.length-1]);



    }
}
