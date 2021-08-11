package com.codurance.java.tdd;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestTicTacToe { 
    private final Coordinates SAMPLE_COORDS = new Coordinates(1, 2);
    private TicTacToe ticTacToe;
    
    
    @BeforeEach
    void setup(){
        ticTacToe =  new TicTacToe(3);
    }

    @DisplayName("should_only_allow_X_to_start")
    @Test
    void should_accept_when_X_starts() {
        String actualValue = ticTacToe.play(SAMPLE_COORDS,Player.X);
        assertEquals(actualValue,Player.X.toString());
    }

    @DisplayName("should_not_allow_O_to_start")
    @Test
    void should_not_accept_when_O_starts() {
        assertThrows(NotXPlayerException.class, ()->{
            ticTacToe.play(SAMPLE_COORDS,Player.O);
        });
    }

    @DisplayName("same_player_cannot_play_twice")
    @Test
    void should_not_play_if_player_played_twice() {
        //GIVEN
        ticTacToe.play(new Coordinates(0, 0),Player.X);
        assertThrows(PlayTwiceException.class, ()->{
            ticTacToe.play(new Coordinates(0, 1),Player.X);
        });
    }
    
    @DisplayName("cannot_play_on_a_played_square")
    @Test
    void should_not_allow_playing_on_a_played_position(){
        //GIVEN
        ticTacToe.play(SAMPLE_COORDS,Player.X);
        assertThrows(AlreadyPlayedException.class, ()->{
            ticTacToe.play(SAMPLE_COORDS,Player.O);
        });
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_row")
    @Test
    void should_win_if_3_X_or_O_in_a_row(){
        //GIVEN
        ticTacToe.play(new Coordinates(0,0),Player.X);
        ticTacToe.play(new Coordinates(1,0),Player.O);
        ticTacToe.play(new Coordinates(0,1),Player.X);
        ticTacToe.play(new Coordinates(1,1) ,Player.O);

        String expectedMsg = ticTacToe.play(new Coordinates(0,2) ,Player.X);
        assertEquals(expectedMsg,"PLAYER_X_WINS");
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_column")
    @Test
    void should_win_if_3_X_or_O_in_a_column(){
        //given
        ticTacToe.play(new Coordinates(0,0),Player.X);
        ticTacToe.play(new Coordinates(2,2),Player.O);
        ticTacToe.play(new Coordinates(1,0),Player.X);
        ticTacToe.play(new Coordinates(1,1),Player.O);

        //when
        String expectedMsg = ticTacToe.play(new Coordinates(2,0),Player.X);
        assertEquals(expectedMsg,"PLAYER_X_WINS");
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_back_diagonal")
    @Test
    void should_win_if_3_X_or_O_in_a_back_diagonal(){
        //given
        ticTacToe.play(new Coordinates(0,0),Player.X);
        ticTacToe.play(new Coordinates(2,1),Player.O);
        ticTacToe.play(new Coordinates(1,1),Player.X);
        ticTacToe.play(new Coordinates(1,0),Player.O);
        
        //when
        String expectedMsg = ticTacToe.play(new Coordinates(2,2),Player.X);
        assertEquals(expectedMsg,"PLAYER_X_WINS");
    }

    @DisplayName("player_wons_when_he_gets_3_in_a_diagonal")
    @Test
    void should_win_if_3_X_or_O_in_a_diagonal(){
        //given
        ticTacToe.play(new Coordinates(0,2),Player.X);
        ticTacToe.play(new Coordinates(2,1),Player.O);
        ticTacToe.play(new Coordinates(1,1),Player.X);
        ticTacToe.play(new Coordinates(1,0),Player.O);
        
        String expectedMsg = ticTacToe.play(new Coordinates(2,0),Player.X);
        assertEquals(expectedMsg,"PLAYER_X_WINS");
    }

    @DisplayName("end_as_draw_when_board_is_full_and_no_winner")
    @Test
    void should_draw_when_all_occupied_and_no_3_in_a_row(){
        //given
        ticTacToe.play(new Coordinates(0, 0),Player.X);
        ticTacToe.play(new Coordinates(0, 2),Player.O);
        ticTacToe.play(new Coordinates(0, 1),Player.X);
        ticTacToe.play(new Coordinates(1, 0),Player.O);
        ticTacToe.play(new Coordinates(1, 2),Player.X);
        ticTacToe.play(new Coordinates(1, 1),Player.O);
        ticTacToe.play(new Coordinates(2, 0),Player.X);
        ticTacToe.play(new Coordinates(2, 2),Player.O);

        String expectedMsg = ticTacToe.play(new Coordinates(2, 1),Player.X);
        assertEquals(expectedMsg,"DRAW");
    }

    @DisplayName("should_not_allow_more_plays_if_player_wins")
    @Test
    void should_not_allow_more_plays_if_player_wins(){
        //given
        ticTacToe.play(new Coordinates(0,2),Player.X);
        ticTacToe.play(new Coordinates(2,1),Player.O);
        ticTacToe.play(new Coordinates(1,1),Player.X);
        ticTacToe.play(new Coordinates(1,0),Player.O);
        ticTacToe.play(new Coordinates(2,0),Player.X);

        assertThrows(BoardBlockedException.class, ()->{
            ticTacToe.play(new Coordinates(2,0),Player.O);
        });
    }
    
}
