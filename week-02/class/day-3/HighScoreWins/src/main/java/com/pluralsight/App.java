package com.pluralsight;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the game scores and teams: ");

        String userInput = input.nextLine();

        //Home:Visitor|21:9

        String[] inputSplit = userInput.split(Pattern.quote("|"));

        String[] teams = inputSplit[0].split(Pattern.quote(":")); //Home:Visitor

        String home = teams[0];
        String away = teams[1];

        String[] scores = inputSplit[1].split(Pattern.quote(":")); //21:9

        int homeScore = Integer.parseInt(scores[0]);
        int awayScore = Integer.parseInt(scores[1]);

        if (homeScore > awayScore) {
            System.out.printf("Winner: %s", home);
        } else if (homeScore < awayScore) {
            System.out.printf("Winner: %s", away);
        } else {
            System.out.println("TIE or DRAW");
        }

    }
}
