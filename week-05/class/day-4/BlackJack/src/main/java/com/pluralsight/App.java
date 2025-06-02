package com.pluralsight;

/*
    You will need a deck of cards, and you will need to be able to
    deal cards to each players hand.

    The examples we have covered do not track the player names. Add any variables
    and/or classes that you think are necessary to meet these requirements.
    Start the game by prompting the user for the name of each player.

    Create a deck and shuffle the cards, then deal 2 cards to each hand. Display each
    player's hand and determine which player is closest to 21 without going over.
    Declare that player as the winner.

    Scoring:
    All number cards are worth their numeric value
    Face cards are worth 10 points
    Ace is worth 11 points

    Prompt the user for the number of players that will be playing the game. Then
    create that many Hands.

    If you have time. Take turns and allow each player to choose if they want to Hit
    to take another card, or to Stay.

    Ace is worth 11 points by default. Add logic to count Ace as 1 point if 11 would
    cause the hand to bust


 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<Player>();

        Deck deck = new Deck();

        System.out.println("--Welcome to BlackJack--");
        System.out.println("");

        System.out.print("Please enter all names of players (comma seperated): ");
        String[] names = input.nextLine().trim().split(Pattern.quote(","));

        //names: "M,T,C,Z,X"
        for (String name : names) {
            //name: M
            players.add(new Player(name.trim()));
        }

        deck.shuffle(); //Shuffle the deck before game

        for(int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.getHand().deal(deck.deal());
            }
        }


        for (Player player : players) {
            System.out.println("Player: " + player.getName());
            while(true) {
                if (player.getHand().getValue() < 16) {
                    System.out.println("Your current value is: " + player.getHand().getValue());
                    System.out.print("HIT? (YES, NO): ");
                    String userHit = input.nextLine().trim().toUpperCase();

                    if (userHit.equals("YES")) {
                        player.getHand().deal(deck.deal());
                        System.out.println("Your current value is: " + player.getHand().getValue());
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }



        int bestScore = 0;
        ArrayList<Player> winners = new ArrayList<Player>();

        for (Player player : players) {

            System.out.println(player.getName() + " Hand Value: " + player.getHand().getValue());

            //4 players

            //player 1 score: 23
            //player 2 score: 19
            //player 3 score: 21
            //player 4 score: 20

            if (player.getHand().getValue() <= 21) {
                if (player.getHand().getValue() > bestScore) {
                    winners.clear();
                    bestScore = player.getHand().getValue();

                    //add to winner list
                    winners.add(player);
                } else if (player.getHand().getValue() == bestScore) {
                    winners.add(player);
                }
            }
        }

        if (winners.size() == 1) {
            System.out.printf("%s is the winner with: %d", winners.get(0).getName(), winners.get(0).getHand().getValue());
        } else if (winners.size() > 1) {
            System.out.println("TIE, NO WINNERS");
        } else {
            System.out.println("NO WINNERS");
        }
    }
}
