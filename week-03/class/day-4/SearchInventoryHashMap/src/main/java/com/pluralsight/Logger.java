package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static void log(String action) {

        try {
            FileWriter fw = new FileWriter("logs.txt", true);
            BufferedWriter logger = new BufferedWriter(fw);

            LocalDateTime timestamp = LocalDateTime.now();

            String formatted = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            logger.write(formatted + " - " + action);
            logger.newLine();

            logger.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void error(String action) {
        log("ERROR - " + action);
    }
}
