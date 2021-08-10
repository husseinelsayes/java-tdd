package com.codurance.java.tdd;

public class Coordinates {
    private int x;
    private int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getRow() {
        return x;
    }

    public int getColumn() {
        return y;
    }

    
}
