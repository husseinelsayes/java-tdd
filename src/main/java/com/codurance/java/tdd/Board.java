package com.codurance.java.tdd;

public class Board {
    private String[][] squares;
    private Player currentPlayer;
    private BoardState boardState;
    
    public Board(int size) {
        this.squares = new String[size][size];
        this.currentPlayer = null;
        this.boardState = BoardState.ACTIVE;
    }

    public boolean isActive() {
        return boardState == BoardState.ACTIVE;
    }

    public void updateState(BoardState boardState) {
        this.boardState = boardState;
    }

    public String setSquare(Coordinates coords, Player player){
        if(isEmpty() && player != Player.X)
            throw new GameAlreadyStartedException();
        if(currentPlayer == player)
            throw new PlayTwiceException();
        if(squareHasValue(coords))
            throw new AlreadyPlayedException();
        squares[coords.getRow()][coords.getColumn()] = player.toString();
        return player.toString();
    }

    // public String getSquareValue(Coordinates coords){
    //     return squares[coords.getRow()][coords.getColumn()];
    // }

    private void makePlayerWin(Player player){
        this.boardState = BoardState.valueOf("PLAYER_"+player.toString()+"_WON");
    }

    private void makeDraw(){
        this.boardState =BoardState.DRAW;
    }

    private boolean isFullyOccupied(){
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {
                if(squares[row][col] == null){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEmpty(){
        return currentPlayer == null;
    }

    private boolean squareHasValue(Coordinates coords){
        return squares[coords.getRow()][coords.getColumn()] != null;
    }

    
    
}
