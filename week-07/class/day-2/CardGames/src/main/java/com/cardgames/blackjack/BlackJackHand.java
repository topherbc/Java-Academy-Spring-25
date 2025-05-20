package com.cardgames.blackjack;


import com.cardgames.models.Card;
import com.cardgames.models.Hand;

import java.util.HashMap;

/**
 * A specialized hand for Blackjack games
 */
public class BlackJackHand extends Hand<Card> {
    private HashMap<Card, Integer> aceValues; // Track custom ace values

    public BlackJackHand() {
        super();
        aceValues = new HashMap<>();
    }

    /**
     * Set a specific ace card to value 1 or 11
     * @param ace The ace card
     * @param value Value to set (1 or 11)
     */
    public void setAceValue(Card ace, int value) {
        if (ace.getValue().equals("A") && (value == 1 || value == 11)) {
            aceValues.put(ace, value);
        }
    }

    /**
     * Calculate the total value of the hand
     * @return The hand value according to Blackjack rules
     */
    public int getValue() {
        int value = 0;
        int autoAces = 0; // Aces that haven't been manually set

        for (Card card : getCards()) {
            if (card.getValue().equals("A")) {
                if (aceValues.containsKey(card)) {
                    // Use manually set ace value
                    value += aceValues.get(card);
                } else {
                    // Count aces that need automatic handling
                    autoAces++;
                }
            } else {
                value += card.getPointValue();
            }
        }

        // Handle remaining aces automatically (prefer 11, but use 1 if it prevents bust)
        for (int i = 0; i < autoAces; i++) {
            if (value + 11 + (autoAces - i - 1) <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }

        return value;
    }

    /**
     * Check if the hand has busted
     * @return true if hand value > 21
     */
    public boolean isBust() {
        return getValue() > 21;
    }

    @Override
    public void showCards() {
        System.out.print("Cards: ");
        for (int i = 0; i < getCards().size(); i++) {
            Card card = getCards().get(i);
            if (card.isFaceUp()) {
                System.out.print(card.getValue() + " of " + card.getSuit());
                // Show custom ace value if set
                if (card.getValue().equals("A") && aceValues.containsKey(card)) {
                    System.out.print("(" + aceValues.get(card) + ")");
                }
            } else {
                System.out.print("[Hidden Card]");
            }
            if (i < getCards().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}