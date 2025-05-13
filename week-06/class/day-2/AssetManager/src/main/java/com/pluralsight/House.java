package com.pluralsight;

public class House extends Asset {

    private String address;
    private int lotSize, squareFoot, condition;

    public House(String description, String dateAcquired, double originalCost, String address, int lotSize, int squareFoot, int condition) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.lotSize = lotSize;
        this.squareFoot = squareFoot;
        this.condition = condition; //(1 -excellent, 2 -good, 3 -fair, 4 -poor)
    }

    @Override
    public double getValue() {
        double rate = switch(condition) {
            case 1 -> 180.00; //excellent
            case 2 -> 130.00; //good
            case 3 -> 90.00; //fair
            case 4 -> 80.00; //poor
            default -> 0.0;
        };

        return (rate * squareFoot) + (0.25 * lotSize);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
