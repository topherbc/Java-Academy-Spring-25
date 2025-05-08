package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    private ArrayList<Card> aces;

    public Hand(){
        cards = new ArrayList<>();
    }

    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card){
        cards.add(card);
    }

    public int getSize(){
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue(){
        int value = 0;
        int aces = 0;

        for (Card card : cards){
            card.flip(); // turn the card over to see the value
            if (card.getValue() == "A") {
                aces += 1;
            } else {
                value += card.getPointValue();
            }
            card.flip(); // hide the card again
        }

        while (aces > 0) {
            aces--; // aces == 0
            if ((value + 11 + (aces) > 21)) {
                value += 1;
            } else {
                value += 11;
            }
        }

        return value;
    }
}