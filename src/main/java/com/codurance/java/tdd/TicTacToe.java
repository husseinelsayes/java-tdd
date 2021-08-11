package com.codurance.java.tdd;

public class TicTacToe {
    Board board;
    
    public TicTacToe(int size){
        this.board = new Board(3);
    }

    public String play(Coordinates coords,Player player){
        if(!board.acceptingPlays()){
            throw new BoardBlockedException();
        }
        if(board.isEmpty() && !board.isPlayerX(player)){
            throw new NotXPlayerException();
        }
        if(!board.isAlternatePlayer(player)){
            throw new PlayTwiceException();
        }
        if(board.squareAlreadyPlayed(coords)){
            throw new AlreadyPlayedException();
        }
        board.playOnSquare(coords, player);
        if(board.playerGotThreeInARow(coords, player)){
            board.endAsWinner(player);
            return "PLAYER_"+player.toString()+"_WINS";
        }
        if(board.isFull()){
            board.endAsDraw();
            return "DRAW";
        }
        return player.toString();
    }
}
