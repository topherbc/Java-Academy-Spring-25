package com.cardgames.blackjack;

import com.cardgames.models.Card;
import com.cardgames.models.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BlackJack {
    public static void play() {
        Scanner input = new Scanner(System.in);
        ArrayList<Player<Card, BlackJackHand>> players = new ArrayList<>();
        Dealer dealer = new Dealer();
        CardDeck deck = new CardDeck();

        System.out.println("--Welcome to BlackJack--");
        System.out.println("(Maximum 5 players)");
        System.out.println("");

        System.out.print("Please enter all names of players (comma separated, max 5): ");
        String[] names = input.nextLine().trim().split(Pattern.quote(","));

        // Limit to 5 players
        int numPlayers = Math.min(names.length, 5);
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player<>(names[i].trim(), new BlackJackHand()));
        }

        deck.shuffle(); // Shuffle the deck before game

        // Deal initial 2 cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player<Card, BlackJackHand> player : players) {
                player.getHand().deal(deck.deal());
            }
        }

        // Deal 2 cards to dealer (first face up, second face down)
        Card dealerCard1 = deck.deal();
        Card dealerCard2 = deck.deal();
        dealer.getHand().deal(dealerCard1); // Face up
        dealerCard2.setFaceUp(false); // Face down
        dealer.getHand().deal(dealerCard2);

        // Show dealer's first card
        System.out.println("\nDealer's showing card: " + dealer.getShowingCard());
        System.out.println("");

        // Players take turns
        for (Player<Card, BlackJackHand> player : players) {
            System.out.println("===============================");
            System.out.println("Player: " + player.getName());
            player.getHand().showCards();
            System.out.println("Hand value: " + player.getHand().getValue());
            System.out.println("");

            while (!player.getHand().isBust()) {
                System.out.print("HIT or STAND? (H/S): ");
                String userChoice = input.nextLine().trim().toUpperCase();

                if (userChoice.equals("H") || userChoice.equals("HIT")) {
                    Card newCard = deck.deal();
                    player.getHand().deal(newCard);
                    System.out.println("You drew: " + newCard.getValue() + " of " + newCard.getSuit());
                    player.getHand().showCards();

                    // Check for aces and let player choose value
                    if (newCard.getValue().equals("A")) {
                        System.out.print("You drew an Ace! Use as 1 or 11? (1/11): ");
                        String aceChoice = input.nextLine().trim();
                        if (aceChoice.equals("1")) {
                            player.getHand().setAceValue(newCard, 1);
                        } else {
                            player.getHand().setAceValue(newCard, 11);
                        }
                    }

                    System.out.println("Hand value: " + player.getHand().getValue());

                    if (player.getHand().isBust()) {
                        System.out.println("BUST! You went over 21.");
                        break;
                    }
                } else {
                    break;
                }
                System.out.println("");
            }
            System.out.println("");
        }

        // Dealer's turn
        System.out.println("===============================");
        System.out.println("Dealer's turn");
        dealer.getHand().flipFirstCard(); // Reveal the hidden card
        dealer.getHand().showCards();
        System.out.println("Dealer's hand value: " + dealer.getHand().getValue());
        System.out.println("");

        // Dealer hits until 17 or higher
        while (dealer.getHand().getValue() < 17) {
            System.out.println("Dealer hits...");
            Card newCard = deck.deal();
            dealer.getHand().deal(newCard);
            System.out.println("Dealer drew: " + newCard.getValue() + " of " + newCard.getSuit());
            dealer.getHand().showCards();
            System.out.println("Dealer's hand value: " + dealer.getHand().getValue());
            System.out.println("");
        }

        if (dealer.getHand().isBust()) {
            System.out.println("Dealer BUST!");
        } else {
            System.out.println("Dealer stands with " + dealer.getHand().getValue());
        }
        System.out.println("");

        // Determine winners
        System.out.println("===============================");
        System.out.println("FINAL RESULTS:");
        System.out.println("===============================");

        ArrayList<Player<Card, BlackJackHand>> winners = new ArrayList<>();
        int dealerValue = dealer.getHand().isBust() ? 0 : dealer.getHand().getValue();

        for (Player<Card, BlackJackHand> player : players) {
            int playerValue = player.getHand().isBust() ? 0 : player.getHand().getValue();
            System.out.println(player.getName() + ": " + playerValue);

            if (!player.getHand().isBust()) {
                if (dealer.getHand().isBust() || playerValue > dealerValue) {
                    winners.add(player);
                }
            }
        }
        System.out.println("Dealer: " + dealerValue);
        System.out.println("");

        // Display results
        if (winners.size() > 0) {
            System.out.print("WINNERS: ");
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i).getName());
                if (i < winners.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Dealer wins!");
        }
    }
}
