import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    List<List> winningMoves = new ArrayList<>();

    @BeforeEach
    void setUp() {
        winningMoves.add(asList(1, 2, 3));
        winningMoves.add(asList(4, 5, 6));
        winningMoves.add(asList(7, 8, 9));
        winningMoves.add(asList(1, 4, 7));
        winningMoves.add(asList(2, 5, 8));
        winningMoves.add(asList(3, 6, 9));
        winningMoves.add(asList(1, 5, 9));
        winningMoves.add(asList(4, 5, 7));
    }

    @Test
    @DisplayName("should return true if moves are subset of winning moves")
    void hasWon() {
        Player player = new Player("player", 'x');

        player.makeMove(1);
        player.makeMove(3);
        player.makeMove(4);
        player.makeMove(6);
        player.makeMove(7);

        assertTrue(player.hasWon(winningMoves));
    }

    @Test
    @DisplayName("should return false if moves are not subset of winning moves")
    void hasNotWon() {
        Player player = new Player("player", 'x');

        player.makeMove(1);
        player.makeMove(3);
        player.makeMove(4);
        player.makeMove(6);
        player.makeMove(8);

        assertFalse(player.hasWon(winningMoves));
    }

    @Test
    @DisplayName("should return true if moves already contain position")
    void isMovePresent(){
        Player player = new Player("player", 'x');

        player.makeMove(1);
        player.makeMove(3);
        player.makeMove(4);
        player.makeMove(6);
        player.makeMove(7);

        assertTrue(player.hasMadeMove(3));
    }

    @Test
    @DisplayName("should return false if moves does not contain position")
    void isMoveAbsent(){
        Player player = new Player("player", 'x');

        player.makeMove(1);
        player.makeMove(3);
        player.makeMove(4);
        player.makeMove(6);
        player.makeMove(7);

        assertFalse(player.hasMadeMove(5));
    }

}