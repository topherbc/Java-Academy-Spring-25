package com.pluralsight;

public class Box<T> {
    private T content;

    // Empty constructor
    public Box() {
    }

    // Constructor with content
    public Box(T content) {
        this.content = content;
    }

    // Get the content
    public T getContent() {
        return content;
    }

    // Set the content
    public void setContent(T content) {
        this.content = content;
    }

    // Check if the box is empty
    public boolean isEmpty() {
        return content == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Box";
        } else {
            return "Box containing: " + content.toString();
        }
    }
}