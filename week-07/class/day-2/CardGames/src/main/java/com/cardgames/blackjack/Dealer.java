package com.cardgames.blackjack;

import com.cardgames.models.Card;

/**
 * Represents a dealer in a Blackjack game
 */
public class Dealer {
    private BlackJackHand hand;

    public Dealer() {
        this.hand = new BlackJackHand();
    }

    public BlackJackHand getHand() {
        return hand;
    }

    /**
     * Get the dealer's showing card (first card)
     * @return String description of the first card
     */
    public String getShowingCard() {
        Card firstCard = hand.getFirstCard();
        if (firstCard != null && firstCard.isFaceUp()) {
            return firstCard.getValue() + " of " + firstCard.getSuit();
        }
        return "[Hidden Card]";
    }
}
