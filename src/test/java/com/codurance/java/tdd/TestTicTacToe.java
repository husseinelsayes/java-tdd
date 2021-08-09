package com.codurance.java.tdd;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestTicTacToe { 
    private final Integer[] RANDOM_SQUARE_INDEX = {2,1};
    private final Player RANDOM_PLAYER = Player.X;
    private TicTacToe ticTacToe;
    
    
    @BeforeEach
    void setup(){
        ticTacToe =  new TicTacToe(3);
    }

    @DisplayName("should_only_allow_X_to_start")
    @Test
    void should_accept_when_X_starts() {
        boolean actualValue = ticTacToe.play(RANDOM_SQUARE_INDEX[0], RANDOM_SQUARE_INDEX[1],Player.X);
        assertTrue(actualValue);
    }

    @DisplayName("should_not_allow_O_to_start")
    @Test
    void should_not_accept_when_O_starts() {
        assertThrows(IllegalArgumentException.class, ()->{
            ticTacToe.play(RANDOM_SQUARE_INDEX[0], RANDOM_SQUARE_INDEX[1],Player.O);
        });
    }

    @DisplayName("same_player_cannot_play_twice")
    @Test
    void should_not_play_if_player_played_twice() {
        //GIVEN
        ticTacToe.play(RANDOM_SQUARE_INDEX[0], RANDOM_SQUARE_INDEX[1],RANDOM_PLAYER);
        
        assertThrows(IllegalArgumentException.class, ()->{
            ticTacToe.play(RANDOM_SQUARE_INDEX[0], RANDOM_SQUARE_INDEX[1],RANDOM_PLAYER);
        });
    }
    
    @DisplayName("cannot_play_on_a_played_square")
    @ParameterizedTest
    @ValueSource(strings = {"X","O"})
    void should_not_allow_playing_on_a_played_position(String player){
        //GIVEN
        ticTacToe.play(RANDOM_SQUARE_INDEX[0], RANDOM_SQUARE_INDEX[1],RANDOM_PLAYER);
        
        assertThrows(IllegalArgumentException.class, ()->{
            ticTacToe.play(RANDOM_SQUARE_INDEX[0], RANDOM_SQUARE_INDEX[1],Player.valueOf(player));
        });
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_row")
    @Test
    void should_win_if_3_X_or_O_in_a_row(){
        //GIVEN
        ticTacToe.play(0,0,Player.X);
        ticTacToe.play(1,0,Player.O);
        ticTacToe.play(0,1,Player.X);
        ticTacToe.play(1,1,Player.O);
        ticTacToe.play(0,2,Player.X);
        
        
        BoardState expected = BoardState.valueOf("PLAYER_" + RANDOM_PLAYER.toString() + "_WON");
        assertEquals(expected, ticTacToe.getBoardStatus());
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_column")
    @Test
    void should_win_if_3_X_or_O_in_a_column(){
        //given
        ticTacToe.play(0,0,Player.X);
        ticTacToe.play(2,2,Player.O);
        ticTacToe.play(1,0,Player.X);
        ticTacToe.play(1,1,Player.O);
        ticTacToe.play(2,0,Player.X);
        
        //when
        BoardState expected = BoardState.valueOf("PLAYER_" + RANDOM_PLAYER.toString() + "_WON");
        assertEquals(expected, ticTacToe.getBoardStatus());
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_back_diagonal")
    @Test
    void should_win_if_3_X_or_O_in_a_back_diagonal(){
        //given
        ticTacToe.play(0,0,Player.X);
        ticTacToe.play(2,1,Player.O);
        ticTacToe.play(1,1,Player.X);
        ticTacToe.play(1,0,Player.O);
        ticTacToe.play(2,2,Player.X);
        
        //when
        BoardState expected = BoardState.valueOf("PLAYER_" + RANDOM_PLAYER.toString() + "_WON");
        assertEquals(expected, ticTacToe.getBoardStatus());
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_diagonal")
    @Test
    void should_win_if_3_X_or_O_in_a_diagonal(){
        //given
        ticTacToe.play(0,2,Player.X);
        ticTacToe.play(2,1,Player.O);
        ticTacToe.play(1,1,Player.X);
        ticTacToe.play(1,0,Player.O);
        ticTacToe.play(2,0,Player.X);
        
        BoardState expected = BoardState.valueOf("PLAYER_" + RANDOM_PLAYER.toString() + "_WON");
        assertEquals(expected, ticTacToe.getBoardStatus());
    }

    @DisplayName("end_as_draw_when_board_is_full_and_no_winner")
    @Test
    void should_draw_when_all_occupied_and_no_3_in_a_row(){
        //given
        ticTacToe.play(0,0,Player.X);
        ticTacToe.play(0,2,Player.O);
        ticTacToe.play(0,1,Player.X);
        ticTacToe.play(1,0,Player.O);
        ticTacToe.play(1,2,Player.X);
        ticTacToe.play(1,1,Player.O);
        ticTacToe.play(2,0,Player.X);
        ticTacToe.play(2,2,Player.O);
        ticTacToe.play(2,1,Player.X);
        assertEquals(BoardState.DRAW, ticTacToe.getBoardStatus());
    }
}
