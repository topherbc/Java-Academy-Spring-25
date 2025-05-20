package com.pluralsight.collection;

import java.util.ArrayList;

public class FixedList<T> {

    private ArrayList<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.items = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void add(T item) {
        if (items.size() == maxSize) return;
        items.add(item);
    }

    public ArrayList<T> getItems(){
        return this.items;
    }
}
