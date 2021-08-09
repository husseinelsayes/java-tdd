package com.codurance.java.tdd;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class TestTicTacToe { 

    private TicTacToe ticTacToe;
    
    
    @BeforeEach
    void setup(){
        ticTacToe =  new TicTacToe(3);
    }

    @ParameterizedTest
    void should_accept_if_x_starts() {
        assertEquals(ticTacToe.play(0, 0,"x"),"x");
    }

    @Test
    void should_refuse_if_o_starts() {
        assertThrows(IllegalArgumentException.class, ()->{
            ticTacToe.play(0, 0,"y");
        });
    }

    @Test
    void should_refuse_playing_on_a_played_position(){
        //given
        int positionX = 2;
        int positionY = 1;
        String player = "X";
        ticTacToe.play(positionX,positionY,player);
        //when
        assertThrows(IllegalArgumentException.class, ()->{
            ticTacToe.play(0, 0,"y");
        });
        String result = ticTacToe.play(positionX,positionY,player);
        assertEquals(result, false);
    }

    @Test
    void should_win_if_3_X_or_O_in_a_row(){
        //given
        ticTacToe.play(0,0,"X");
        ticTacToe.play(0,1,"X");
        //when
        ;
        boolean result = ticTacToe.play(0,2,"X");
        assertEquals(result, false);
    }
}
