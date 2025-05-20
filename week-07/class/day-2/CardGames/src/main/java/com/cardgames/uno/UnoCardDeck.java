package com.cardgames.uno;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of UNO cards
 */
public class UnoCardDeck {
    private ArrayList<UnoCard> cards;

    public UnoCardDeck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Add number cards (0-9) for each color
        // Each color has one 0 and two of each 1-9
        for (UnoCard.Color color : new UnoCard.Color[]{UnoCard.Color.RED, UnoCard.Color.BLUE,
                UnoCard.Color.GREEN, UnoCard.Color.YELLOW}) {
            // Add one 0 card
            cards.add(new UnoCard(color, UnoCard.Type.NUMBER, 0));

            // Add two of each 1-9 card
            for (int num = 1; num <= 9; num++) {
                cards.add(new UnoCard(color, UnoCard.Type.NUMBER, num));
                cards.add(new UnoCard(color, UnoCard.Type.NUMBER, num));
            }

            // Add action cards (2 of each type per color)
            for (int i = 0; i < 2; i++) {
                cards.add(new UnoCard(color, UnoCard.Type.SKIP));
                cards.add(new UnoCard(color, UnoCard.Type.REVERSE));
                cards.add(new UnoCard(color, UnoCard.Type.DRAW_TWO));
            }
        }

        // Add wild cards (4 of each type)
        for (int i = 0; i < 4; i++) {
            cards.add(new UnoCard(UnoCard.Color.WILD, UnoCard.Type.WILD));
            cards.add(new UnoCard(UnoCard.Color.WILD, UnoCard.Type.WILD_DRAW_FOUR));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UnoCard deal() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    public int getSize() {
        return cards.size();
    }
}