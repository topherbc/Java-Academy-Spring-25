package com.cardgames;

import com.cardgames.blackjack.BlackJack;
import com.cardgames.uno.Uno;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which game would you like to play?");
        System.out.println("1. Blackjack");
        System.out.println("2. Uno (demo)");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = Integer.parseInt(input.nextLine().trim());

        switch(choice) {
            case 1:
                BlackJack.play();
                break;
            case 2:
                Uno.play();
                break;
            default: System.exit(0);
        }
    }
}
