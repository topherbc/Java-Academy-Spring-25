package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner keyboardInput = new Scanner(System.in);

        VideoGame game = new VideoGame();

        System.out.println("Welcome to the Video Game Inventory System");

        System.out.println("---You will need to insert the new video game---");
        System.out.println("\n");

        System.out.print("Please enter the name of your video game: ");
        game.setName(keyboardInput.nextLine());

        System.out.print("Please enter the type: ");
        game.setType(keyboardInput.nextLine());

        System.out.print("Please enter if it's preowned: ");
        game.setPreowned(Boolean.parseBoolean(keyboardInput.nextLine()));

        System.out.print("Please enter if it's digital: ");
        game.setDigital(Boolean.parseBoolean(keyboardInput.nextLine()));

        System.out.print("Please enter the price: ");
        game.setPrice(Double.parseDouble(keyboardInput.nextLine()));

        System.out.println("Thanks, here is your game being inserted");
        System.out.printf("Name: %s, Type: %s, Price: $%.2f", game.getName(), game.getType(), game.getPrice());



    }
}
