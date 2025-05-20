package com.cardgames.models;

public class Card implements CardInterface<Card> {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = true; // Cards are dealt face up by default
    }

    public String getSuit(){
        if(isFaceUp){
            return suit;
        } else {
            return "#";
        }
    }

    @Override
    public String getValue(){
        if(isFaceUp){
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue(){
        if (isFaceUp){
            switch (value) {
                case "A":
                    return 11; // Default ace value
                case "K":
                case "Q":
                case "J":
                    return 10;
                default:
                    return Integer.parseInt(value);
            }
        } else {
            return 0;
        }
    }

    @Override
    public boolean isFaceUp(){
        return isFaceUp;
    }

    @Override
    public void flip(){
        isFaceUp = !isFaceUp;
    }

    @Override
    public void setFaceUp(boolean faceUp) {
        this.isFaceUp = faceUp;
    }
}
