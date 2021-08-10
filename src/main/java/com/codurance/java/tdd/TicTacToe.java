package com.codurance.java.tdd;

public class TicTacToe {
    Board board;
    // private String[][] squares;
    // private Player currentPlayer;
    // private BoardState boardState;

    // public BoardState getBoardStatus(){
    //     return this.boardState;
    // }
    
    public TicTacToe(int size){
        this.board = new Board(3);
        // this.squares = new String[size][size];
        // this.currentPlayer = Player.X;
        // this.boardState = BoardState.ACTIVE;
    }

    public String play(int row,int column,Player player){
        // if(board.isEmpty()){
        //     throw new GameAlreadyStartedException();
        // }
        // if(!isPlayerXStartingTheGame(player)){
        //     checkPlayerPermittedToPlay(player, row, column);
        // }
        // assignSquare(row, column, player);
        // updateGameStatus(row, column, player);
        // return true;
    }

    // private void updateGameStatus(int row, int column, Player player){
    //     if(isfWinningPlay(row, column, player)){
    //         // boardState = BoardState.valueOf("PLAYER_"+player.toString()+"_WON");
    //         board.makePlayerWin(player);
    //         return;
    //     }
    //     if(board.isFullyOccupied()){
    //         board.makeDraw();
    //         return;
    //     }
    // }

    // private boolean isAllSquaresOccupied(){
    //     for (int row = 0; row < squares.length; row++) {
    //         for (int col = 0; col < squares[row].length; col++) {
    //             if(squares[row][col] == null){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // private boolean isPlayerXStartingTheGame(Player player){
    //     boolean freshSquares = true;
    //     for (int row = 0; row < squares.length; row++) {
    //         for (int col = 0; col < squares[row].length; col++) {
    //             if(squares[row][col] != null){
    //                 freshSquares = false;
    //             }
    //         }
    //     }
    //     if(freshSquares && player != Player.X){
    //         throw new IllegalArgumentException("Player X only can start"); 
    //     }
    //     return freshSquares;
    // }

    // private boolean checkPlayerPermittedToPlay(Player player,int row,int column){
    //     if(currentPlayer == player){
    //         throw new IllegalArgumentException("Player cannot play twice");
    //     }
    //     if(squares[row][column] != null){
    //         throw new IllegalArgumentException("Player cannot play on a played Square");
    //     }
    //     return true;
    // }

    // private void assignSquare(int row, int column, Player player){
    //     squares[row][column] = player.toString();
    //     currentPlayer = player;
    // }

    // private boolean isfWinningPlay(int row, int column, Player player){
    //     return rowComplete(row,player) || columnComplete(column, player) || backDiagonalComplete(row, column, player) || frontDiagonalComplete(row, column, player);
    // }

    // private boolean rowComplete(int row,Player player){
    //     for(int i = 0;i< squares.length ; i++){
    //         if(!(squares[row][i] != null && squares[row][i].equalsIgnoreCase(player.toString()))){
    //             return false;                
    //         }
    //     }
    //     return true;
    // }

    // private boolean columnComplete(int column,Player player){
    //     for(int i = 0;i< squares.length ; i++){
    //         if(!(squares[i][column] != null && squares[i][column].equalsIgnoreCase(player.toString()))){
    //             return false;                
    //         }
    //     }
    //     return true;
    // }

    // private boolean backDiagonalComplete(int row,int column,Player player){
    //     for(int i = 0;i< squares.length ; i++){
    //         if(!(squares[i][i] != null && squares[i][i].equalsIgnoreCase(player.toString()))){
    //             return false;                
    //         }
    //     }
    //     return true;
    // }

    // private boolean frontDiagonalComplete(int row,int column,Player player){
    //     for(int i = 0; i < squares.length ; i++){
    //         if(!(squares[i][squares.length-(1+i)] != null && squares[i][squares.length-(1+i)].equalsIgnoreCase(player.toString()))){
    //             return false;                
    //         }
    //     }
    //     return true;
    // }    
}
