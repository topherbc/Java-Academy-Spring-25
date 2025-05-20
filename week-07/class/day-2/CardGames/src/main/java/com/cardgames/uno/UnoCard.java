package com.cardgames.uno;

import com.cardgames.models.CardInterface;

/**
 * Represents a UNO card
 */
public class UnoCard implements CardInterface<UnoCard> {
    public enum Color {
        RED, BLUE, GREEN, YELLOW, WILD
    }

    public enum Type {
        NUMBER, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR
    }

    private Color color;
    private Type type;
    private int number; // Only used for number cards, -1 for action cards
    private boolean isFaceUp;

    public UnoCard(Color color, Type type, int number) {
        this.color = color;
        this.type = type;
        this.number = number;
        this.isFaceUp = true;
    }

    public UnoCard(Color color, Type type) {
        this(color, type, -1);
    }

    public Color getColor() {
        return isFaceUp ? color : null;
    }

    public Type getType() {
        return isFaceUp ? type : null;
    }

    public int getNumber() {
        return isFaceUp ? number : -1;
    }

    @Override
    public String getValue() {
        if (!isFaceUp) {
            return "#";
        }

        if (type == Type.NUMBER) {
            return String.valueOf(number);
        } else {
            return type.toString();
        }
    }

    @Override
    public boolean isFaceUp() {
        return isFaceUp;
    }

    @Override
    public void flip() {
        isFaceUp = !isFaceUp;
    }

    @Override
    public void setFaceUp(boolean faceUp) {
        this.isFaceUp = faceUp;
    }

    @Override
    public String toString() {
        if (!isFaceUp) {
            return "[UNO Card]";
        }

        if (type == Type.NUMBER) {
            return color + " " + number;
        } else if (type == Type.WILD || type == Type.WILD_DRAW_FOUR) {
            return type.toString();
        } else {
            return color + " " + type;
        }
    }
}
