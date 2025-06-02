package com.pluralsight;

public class RubixCube {
    private String shape;
    private int sides;

    public RubixCube(String shape, int sides) {
        this.shape = shape;
        this.sides = sides;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
