import java.util.List;
import java.util.ListIterator;

public class Board {

    private List<Character> symbols;

    public Board(List<Character> symbols) {
        this.symbols = symbols;
    }

    public void addSymbol(int position, Character symbol){
        this.symbols.set(--position, symbol);
    }

    public String generateBoard() {
        String board = "";
        String horizontalSeparator = "\n +---+---+---+\n";
        String verticalSeparator = " | ";
        int counter = 1;
        board = board + horizontalSeparator;
        ListIterator<Character> iterator = this.symbols.listIterator();
        while (iterator.hasNext()) {
            board = board + verticalSeparator + iterator.next();
            if (counter % 3 == 0) {
                board = board + verticalSeparator + horizontalSeparator;
            }
            counter++;
        }
        return board;
    }

}
