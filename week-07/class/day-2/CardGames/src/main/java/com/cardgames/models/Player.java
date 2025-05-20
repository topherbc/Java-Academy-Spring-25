package com.cardgames.models;

import com.cardgames.models.Hand;

/**
 * Generic player class that can hold any type of hand
 * @param <T> The type of card
 * @param <H> The type of hand
 */
public class Player<T extends CardInterface<?>, H extends HandInterface<T>> {
    private String name;
    private H hand;

    public Player(String name, H hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public H getHand() {
        return hand;
    }

    public void setHand(H hand) {
        this.hand = hand;
    }
}