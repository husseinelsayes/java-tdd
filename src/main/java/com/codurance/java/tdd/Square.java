package com.codurance.java.tdd;

public class Square {
    private Coordinates coords;
    private String value ;

    public Square(Coordinates coords, String value) {
        this.coords = coords;
        this.value = value;
    }

    public int getRow(){
        return coords.getRow();
    }
    
    public int getColumn(){
        return coords.getRow();
    }

    public boolean isX() {
        return value.equals("X");
    }

    public boolean isO() {
        return value.equals("O");
    }
}
