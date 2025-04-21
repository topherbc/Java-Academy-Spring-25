package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        boolean run = true;
        while(run) {
            try {
                Scanner scanner = new Scanner(System.in);

                String[] studentNames = {"Samaria", "Jahari", "Viktoriia", "Andrei", "Vilayat", "Enoch"};

                System.out.print("Please select a student (Enter 0-5): ");

                int index = scanner.nextInt();

                System.out.println(studentNames[index]);
                run = false;
            } catch (Exception e) {
                System.out.println("Please pick a better number!");
            }
        }




    }
}
