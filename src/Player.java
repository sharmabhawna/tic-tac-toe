import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Player {

    private String name;
    private char symbol;
    private Set<Integer> moves = new HashSet<>(5);

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean hasMadeMove(int position){
        return this.moves.contains(position);
    }

    public void addMove(int position){
        this.moves.add(position);
    }

    public boolean hasWon(List<List> winningMoves){
        Iterator<List> iterator = winningMoves.listIterator();

        while (iterator.hasNext()){
            if(this.moves.containsAll(iterator.next())){
                return true;
            }
        }
        return false;
    }
}
