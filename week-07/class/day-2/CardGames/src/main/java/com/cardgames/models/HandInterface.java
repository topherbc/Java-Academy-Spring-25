package com.cardgames.models;

import java.util.List;

/**
 * Generic interface for a hand of cards
 * @param <T> The type of card in the hand
 */
public interface HandInterface<T extends CardInterface<?>> {
    /**
     * Deal a card to the hand
     * @param card The card to add to the hand
     */
    void deal(T card);

    /**
     * Get the number of cards in the hand
     * @return The size of the hand
     */
    int getSize();

    /**
     * Show all cards in the hand
     */
    void showCards();

    /**
     * Get all cards in the hand
     * @return List of cards
     */
    List<T> getCards();
}