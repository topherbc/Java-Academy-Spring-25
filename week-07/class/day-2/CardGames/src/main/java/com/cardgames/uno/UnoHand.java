package com.cardgames.uno;

import com.cardgames.models.Hand;

import java.util.ArrayList;
import java.util.List;

/**
 * A specialized hand for Uno games
 */
public class UnoHand extends Hand<UnoCard> {

    public UnoHand() {
        super();
    }

    /**
     * Check if the hand has a valid playable card
     * @param topCard The current top card on the discard pile
     * @return true if a valid play exists
     */
    public boolean hasValidPlay(UnoCard topCard) {
        return getPlayableCards(topCard).size() > 0;
    }

    /**
     * Get a list of all cards that can be played on the given top card
     * @param topCard The current top card on the discard pile
     * @return List of playable cards
     */
    public List<UnoCard> getPlayableCards(UnoCard topCard) {
        List<UnoCard> playableCards = new ArrayList<>();

        for (UnoCard card : getCards()) {
            if (isValidPlay(card, topCard)) {
                playableCards.add(card);
            }
        }

        return playableCards;
    }

    /**
     * Check if a card can be played on the top card
     * @param card The card to check
     * @param topCard The top card on the discard pile
     * @return true if the card is a valid play
     */
    private boolean isValidPlay(UnoCard card, UnoCard topCard) {
        // Wild cards can always be played
        if (card.getType() == UnoCard.Type.WILD || card.getType() == UnoCard.Type.WILD_DRAW_FOUR) {
            return true;
        }

        // Match color
        if (card.getColor() == topCard.getColor()) {
            return true;
        }

        // Match type for action cards
        if (card.getType() == topCard.getType() && card.getType() != UnoCard.Type.NUMBER) {
            return true;
        }

        // Match number for number cards
        if (card.getType() == UnoCard.Type.NUMBER && topCard.getType() == UnoCard.Type.NUMBER
                && card.getNumber() == topCard.getNumber()) {
            return true;
        }

        return false;
    }

    /**
     * Play a card from the hand
     * @param index The index of the card to play
     * @return The played card, or null if index is invalid
     */
    public UnoCard playCard(int index) {
        if (index >= 0 && index < getSize()) {
            UnoCard card = getCards().get(index);
            getCards().remove(index);
            return card;
        }
        return null;
    }

    @Override
    public void showCards() {
        System.out.println("Your Uno Hand:");
        List<UnoCard> cards = getCards();
        for (int i = 0; i < cards.size(); i++) {
            UnoCard card = cards.get(i);
            System.out.printf("%d: %s\n", i + 1, card.toString());
        }
    }
}
