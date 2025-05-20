package com.cardgames.models;


/**
 * Generic interface for any type of card
 * @param <T> The type of card
 */
public interface CardInterface<T> {
    /**
     * Get the value of the card
     * @return The card's value
     */
    String getValue();

    /**
     * Check if the card is face up
     * @return true if face up, false if face down
     */
    boolean isFaceUp();

    /**
     * Flip the card
     */
    void flip();

    /**
     * Set whether the card is face up
     * @param faceUp true to set face up, false for face down
     */
    void setFaceUp(boolean faceUp);
}
