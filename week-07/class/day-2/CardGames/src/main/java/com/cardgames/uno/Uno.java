package com.cardgames.uno;

import com.cardgames.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Uno {
    public static void play() {
        Scanner input = new Scanner(System.in);
        ArrayList<Player<UnoCard, UnoHand>> players = new ArrayList<>();
        UnoCardDeck deck = new UnoCardDeck();

        System.out.println("--Welcome to UNO--");
        System.out.println("(Demo mode with 2-4 players)");
        System.out.println("");

        System.out.print("Please enter all names of players (comma separated, 2-4 players): ");
        String[] names = input.nextLine().trim().split(Pattern.quote(","));

        // Ensure 2-4 players
        int numPlayers = Math.max(2, Math.min(names.length, 4));
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player<>(names[i].trim(), new UnoHand()));
        }

        deck.shuffle(); // Shuffle the deck before game

        // Deal 7 cards to each player
        for (int i = 0; i < 7; i++) {
            for (Player<UnoCard, UnoHand> player : players) {
                player.getHand().deal(deck.deal());
            }
        }

        // Deal the first card to start the discard pile
        UnoCard topCard = deck.deal();
        while (topCard.getType() != UnoCard.Type.NUMBER) {
            // Redraw if first card is special
            deck.shuffle();
            topCard = deck.deal();
        }

        // Simple demo game loop - just one round
        System.out.println("\nStarting card: " + topCard);
        System.out.println("");

        for (int i = 0; i < players.size(); i++) {
            Player<UnoCard, UnoHand> player = players.get(i);
            System.out.println("===============================");
            System.out.println("Player: " + player.getName() + "'s turn");
            player.getHand().showCards();
            System.out.println("\nTop card: " + topCard);

            List<UnoCard> playableCards = player.getHand().getPlayableCards(topCard);

            if (playableCards.size() > 0) {
                System.out.println("\nYou can play: ");
                for (int j = 0; j < playableCards.size(); j++) {
                    System.out.println((j + 1) + ": " + playableCards.get(j));
                }

                System.out.print("\nSelect a card to play (1-" + playableCards.size() + ") or 0 to draw: ");
                int choice = Integer.parseInt(input.nextLine().trim());

                if (choice > 0 && choice <= playableCards.size()) {
                    UnoCard selectedCard = playableCards.get(choice - 1);
                    // Find the index of this card in the original hand
                    int originalIndex = player.getHand().getCards().indexOf(selectedCard);

                    // Play the card
                    player.getHand().playCard(originalIndex);
                    topCard = selectedCard;

                    System.out.println("You played: " + selectedCard);

                    // Handle wild cards
                    if (selectedCard.getType() == UnoCard.Type.WILD ||
                            selectedCard.getType() == UnoCard.Type.WILD_DRAW_FOUR) {
                        System.out.print("Choose a color (RED, BLUE, GREEN, YELLOW): ");
                        String colorChoice = input.nextLine().trim().toUpperCase();
                        UnoCard.Color chosenColor = UnoCard.Color.valueOf(colorChoice);
                        // In a real game, we'd update the topCard color here
                        System.out.println("Color changed to " + chosenColor);
                    }
                } else {
                    // Draw a card
                    UnoCard drawnCard = deck.deal();
                    player.getHand().deal(drawnCard);
                    System.out.println("You drew: " + drawnCard);
                }
            } else {
                System.out.println("No playable cards. Drawing...");
                UnoCard drawnCard = deck.deal();
                player.getHand().deal(drawnCard);
                System.out.println("You drew: " + drawnCard);

                // Check if drawn card can be played
                if (drawnCard.getType() == UnoCard.Type.WILD ||
                        drawnCard.getType() == UnoCard.Type.WILD_DRAW_FOUR ||
                        drawnCard.getColor() == topCard.getColor() ||
                        (drawnCard.getType() == UnoCard.Type.NUMBER &&
                                topCard.getType() == UnoCard.Type.NUMBER &&
                                drawnCard.getNumber() == topCard.getNumber())) {

                    System.out.print("Play drawn card? (Y/N): ");
                    String playChoice = input.nextLine().trim().toUpperCase();

                    if (playChoice.equals("Y")) {
                        // Play the card
                        int drawnIndex = player.getHand().getCards().size() - 1;
                        player.getHand().playCard(drawnIndex);
                        topCard = drawnCard;

                        System.out.println("You played: " + drawnCard);

                        // Handle wild cards
                        if (drawnCard.getType() == UnoCard.Type.WILD ||
                                drawnCard.getType() == UnoCard.Type.WILD_DRAW_FOUR) {
                            System.out.print("Choose a color (RED, BLUE, GREEN, YELLOW): ");
                            String colorChoice = input.nextLine().trim().toUpperCase();
                            UnoCard.Color chosenColor = UnoCard.Color.valueOf(colorChoice);
                            // In a real game, we'd update the topCard color here
                            System.out.println("Color changed to " + chosenColor);
                        }
                    }
                }
            }

            System.out.println("");
        }

        System.out.println("===============================");
        System.out.println("Demo round complete!");
        System.out.println("In a real game, play would continue until a player has no cards left.");
    }
}
