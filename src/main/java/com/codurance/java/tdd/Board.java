package com.codurance.java.tdd;

public class Board {
    private String[][] squares;
    private Player currentPlayer;
    private BoardState boardState;
    private int moves = 0;
    
    public Board(int size) {
        this.squares = new String[size][size];
        this.currentPlayer = null;
        this.boardState = BoardState.ACTIVE;
    }

    public boolean acceptingPlays() {
        return boardState == BoardState.ACTIVE;
    }

    public boolean isFull(){
        return this.moves == 9;
    }

    public boolean isAlternatePlayer(Player player){
        return currentPlayer != player;
    }

    public boolean isWinningPlayer(Player player){
        return boardState == BoardState.valueOf("PLAYER_"+player.toString()+"_WON");
    }

    public boolean isPlayerX(Player player){
        return player == Player.X;
    }

    public boolean isEmpty(){
        return moves == 0;
    }

    public boolean squareAlreadyPlayed(Coordinates coords){
        return squares[coords.getRow()][coords.getColumn()] != null;
    }

    public void playOnSquare(Coordinates coords,Player player){
        squares[coords.getRow()][coords.getColumn()] = player.toString();
        currentPlayer = player;
        moves ++;
    }

    public void endAsDraw(){
        this.boardState =BoardState.DRAW;
    }

    public void endAsWinner(Player player){
        this.boardState = BoardState.valueOf("PLAYER_"+player.toString()+"_WON");
    }

    public boolean playerGotThreeInARow(Coordinates coords, Player player){
        return rowComplete(coords.getRow(),player) || columnComplete(coords.getColumn() , player) || backDiagonalComplete(coords.getRow() , coords.getColumn() , player) || frontDiagonalComplete(coords.getRow() , coords.getColumn(), player);
    }

    private boolean rowComplete(int row,Player player){
        for(int i = 0;i< squares.length ; i++){
            if(!(squares[row][i] != null && squares[row][i].equalsIgnoreCase(player.toString()))){
                return false;                
            }
        }
        return true;
    }

    private boolean columnComplete(int column,Player player){
        for(int i = 0;i< squares.length ; i++){
            if(!(squares[i][column] != null && squares[i][column].equalsIgnoreCase(player.toString()))){
                return false;                
            }
        }
        return true;
    }

    private boolean backDiagonalComplete(int row,int column,Player player){
        for(int i = 0;i< squares.length ; i++){
            if(!(squares[i][i] != null && squares[i][i].equalsIgnoreCase(player.toString()))){
                return false;                
            }
        }
        return true;
    }

    private boolean frontDiagonalComplete(int row,int column,Player player){
        for(int i = 0; i < squares.length ; i++){
            if(!(squares[i][squares.length-(1+i)] != null && squares[i][squares.length-(1+i)].equalsIgnoreCase(player.toString()))){
                return false;                
            }
        }
        return true;
    }   
}
