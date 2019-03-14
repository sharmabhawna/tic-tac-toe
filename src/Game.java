import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static java.util.Arrays.asList;

public class Game {

    private final List<List> winningMoves;
    private Board board;
    private boolean gameStatus;
    private List<Player> players;
    private Player currentPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.players = new ArrayList<>(2);
        this.players.add(firstPlayer);
        this.players.add(secondPlayer);

        this.winningMoves = new ArrayList<>(9);
        this.winningMoves.add(asList(1, 2, 3));
        this.winningMoves.add(asList(4, 5, 6));
        this.winningMoves.add(asList(7, 8, 9));
        this.winningMoves.add(asList(1, 4, 7));
        this.winningMoves.add(asList(2, 5, 8));
        this.winningMoves.add(asList(3, 6, 9));
        this.winningMoves.add(asList(1, 5, 9));
        this.winningMoves.add(asList(3, 5, 7));

        this.board = new Board(asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        this.currentPlayer = firstPlayer;
        this.gameStatus = true;
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        return this.getCurrentPlayer().getName();
    }

    public char getCurrentPlayerSymbol() {
        return this.getCurrentPlayer().getSymbol();
    }

    public void startGame() {
        System.out.println(this.board.generateBoard());
    }

    public void changeTurn() {
        int currentPlayerIndex = this.players.indexOf(this.currentPlayer);
        this.currentPlayer = this.players.get(1 - currentPlayerIndex);
    }

    public boolean isInvalidMove(int position) {
        ListIterator<Player> playerListIterator = this.players.listIterator();
        while (playerListIterator.hasNext()) {
            Player player = playerListIterator.next();
            if (player.hasMadeMove(position))
                return true;
        }
        return false;
    }

    public boolean makeMove(int position) {
        if (this.isInvalidMove(position)) {
            return false;
        }
        this.applyMove(position);
        return true;
    }

    public void applyMove(int position) {
        this.currentPlayer.addMove(position);
        this.board.addSymbol(position, this.getCurrentPlayerSymbol());
        System.out.println(this.board.generateBoard());
        if (currentPlayer.hasWon(winningMoves)) {
            this.gameStatus = false;
            return;
        }
        this.changeTurn();
    }


    public String getGameResult() {
        return this.getCurrentPlayerName() + " has won";
    }
}
