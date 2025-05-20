package com.cardgames.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Generic implementation of a hand of cards
 * @param <T> The type of card in the hand
 */
public class Hand<T extends CardInterface<?>> implements HandInterface<T> {
    private ArrayList<T> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    @Override
    public void deal(T card) {
        cards.add(card);
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public List<T> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public void showCards() {
        System.out.print("Cards: ");
        for (int i = 0; i < cards.size(); i++) {
            T card = cards.get(i);
            if (card.isFaceUp()) {
                System.out.print(card.toString());
            } else {
                System.out.print("[Hidden Card]");
            }
            if (i < cards.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Get the first card in the hand
     * @return The first card, or null if hand is empty
     */
    public T getFirstCard() {
        return cards.size() > 0 ? cards.get(0) : null;
    }

    /**
     * Flip the first card in the hand
     */
    public void flipFirstCard() {
        if (cards.size() > 0) {
            cards.get(0).flip();
        }
    }
}
