import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static java.util.Arrays.asList;

public class Game {

    private final List<List> winningMoves;
    private Board board;
    private boolean isContinue;
    private String gameResult;
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

        this.board = new Board(asList(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '));
        this.currentPlayer = firstPlayer;
        this.isContinue = true;
        this.gameResult = "Game Draw";
    }

    public boolean isContinue() {
        return this.isContinue;
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
            if (player.hasMadeMove(position) || position > 9 || position < 1)
                return true;
        }
        return false;
    }

    public boolean validateMove(int position) {
        if (this.isInvalidMove(position)) {
            return false;
        }
        this.makeMove(position);
        return true;
    }

    public void makeMove(int position) {
        this.currentPlayer.addMove(position);
        this.board.addSymbol(position, this.getCurrentPlayerSymbol());
        if (this.isOver()) this.isContinue = false;
        this.changeTurn();
    }

    public boolean isWon() {
        return currentPlayer.hasWon(winningMoves);
    }

    public boolean isDraw() {
        return this.currentPlayer.hasMadeAllMoves();
    }

    public boolean isOver() {
        if (this.isWon()) {
            this.gameResult = this.getCurrentPlayerName() + " has won";
        }
        return this.isWon() || this.isDraw();
    }

    public String getGameResult() {
        return this.gameResult;
    }

    public String generateBoard() {
        return this.board.generateBoard();
    }
}
