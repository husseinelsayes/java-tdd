package com.codurance.java.tdd;

public class TicTacToe {
    private final String[][] board;
    
    public TicTacToe(int length){
        board = new String[length][length];
        initializeSquares();
    }

    public String play(int row,int column,String value){
        String result = "";
        if(checkAllEmptySquares()){
            if(value.equalsIgnoreCase("x")){
                result = "X";
            }
        }else{
            if(!board[row][column].isEmpty()){
                throw new IllegalArgumentException("not allowed");
            }
        }
        checkSquare(row, column, value);
        return result;
    }

    public String[][] getBoard() {
        return board;
    }

    private void checkSquare(int row,int column,String value){
        board[row][column] = value;
    }

    private boolean checkAllEmptySquares(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(!board[row][col].isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    private void initializeSquares(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = "";
            }
        }
    }

    
}
