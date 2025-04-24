package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        actionsLogger("launch");
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a search term (X to exit): ");
            String searchTerm = input.nextLine();

            if (searchTerm.equalsIgnoreCase("x")) {
                actionsLogger("exit");
                System.exit(0);
            } else {
                actionsLogger("search : " + searchTerm);
            }
        }
    }

    public static void actionsLogger(String action) {

        try {
            FileWriter fw = new FileWriter("logs.txt", true);
            BufferedWriter logger = new BufferedWriter(fw);

            LocalDateTime timestamp = LocalDateTime.now();

            String formatted = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            logger.write(formatted + " " + action);
            logger.newLine();

            logger.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
