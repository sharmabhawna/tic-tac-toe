import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    @DisplayName("should insert the symbol and give the board accordingly")
    void insertSymbol() {
        Board board = new Board(asList('1', '2', '3'));
        String expected = "\n +---+---+---+\n | * | 2 | 3 | \n +---+---+---+\n";
        board.addSymbol(1, '*');
        String actual = board.generateBoard();
        assertEquals(expected, actual);
    }
}