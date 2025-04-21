package com.pluralsight;

import java.util.Scanner;

public class Switches {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number, 1-100: ");

        int val = scanner.nextInt();

//        if (val == 1) {
//            System.out.println("Yes, option 1 is selected");
//        } else if (val == 2) {
//            System.out.println("Yes, option 2 is selected");
//        } else if (val == 3 || val == 4 || val == 5 || val == 6 || val ==7 || val == 8 || val ==9 || val == 10) {
//            System.out.println("Yes, 3-10 selected");
//        } else if (val > 10 || val < 100) {
//
//        }else {
//            System.out.printf("Option out of range: %d", val);
//        }

        //constant == immutable
        final int testVariable = 1;
        int test = 1;

//        testVariable += 100;
//        test += 100;
//
//        testVariable = 100;
//        test = 100;

        // == or .equals
        switch (val) {
            case testVariable:
                System.out.println("Yes, option 1 is selected");
                break;
            case 2:
                System.out.println("Yes, option 2 is selected");
                break;
            case 3, 4, 5, 6, 7, 8, 9, 10:
                System.out.println("Yes, 3-10 selected");
                break;
            default:
                System.out.printf("Option out of range: %d", val);
        }


    }
}
