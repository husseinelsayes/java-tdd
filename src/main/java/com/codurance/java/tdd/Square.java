package com.codurance.java.tdd;

public class Square {
    final private Integer row;
    final private Integer col;
    private char value;

    public Square(Integer row,Integer col){
        this.row = row;
        this.col = col;
        value = ' ';
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    public char getValue() {
        return value;
    }

    boolean isEmpty(){
        return value == ' ';
    }

}
