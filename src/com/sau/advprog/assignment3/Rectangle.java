package com.sau.advprog.assignment3;

/**
 * Class Rectangle with 3 overloaded constructors
 */
public class Rectangle {
    public int length;
    public int width;
//    This constructor takes 2 parameters: length and width and sets it to the members length and width
    public Rectangle(int l, int w) {
        length = l;
        width = w;
    }
//    This constructor takes only the length as the parameter and assigns a static width of 10
    public Rectangle(int l) {
        this(l, 10);
    }
//    This constructor takes an instance of the same class, extracts the length and breadth and assigns to its own class members
    public Rectangle(Rectangle other) {
        this(other.length, other.width);
    }
}
