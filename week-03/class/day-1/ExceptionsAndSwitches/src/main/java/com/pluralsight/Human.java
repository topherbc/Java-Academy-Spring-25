package com.pluralsight;

public class Human {
    private String name;
    private int eyes, legs, arms, head;

    public Human(String name, int eyes, int legs, int arms, int head) {
        this.name = name;
        this.eyes = eyes;
        this.legs = legs;
        this.arms = arms;
        this.head = head;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }
}
