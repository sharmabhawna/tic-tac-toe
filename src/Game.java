import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Game {

    private Board board;
    private String gameStatus;
    private final List<List> winningMoves;
    private List<Player> players;
    private Player currentPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.players = new ArrayList<>(2);
        this.players.add(firstPlayer);
        this.players.add(secondPlayer);

        this.winningMoves = new ArrayList<>();
        this.winningMoves.add(asList(1,2,3));
        this.winningMoves.add(asList(4,5,6));
        this.winningMoves.add(asList(7,8,9));
        this.winningMoves.add(asList(1,4,7));
        this.winningMoves.add(asList(2,5,8));
        this.winningMoves.add(asList(3,6,9));
        this.winningMoves.add(asList(1,5,9));
        this.winningMoves.add(asList(4,5,7));

        this.board = new Board(asList('1','2','3','4','5','6','7','8','9'));
        this.currentPlayer = firstPlayer;
        this.gameStatus = "start";
    }

    public String getGameStatus() {
        return this.gameStatus;
    }

    public void changeTurn(){
        int currentPlayerIndex = this.players.indexOf(this.currentPlayer);
        this.currentPlayer = this.players.get(1 - currentPlayerIndex);
    }

    public void makeMove(int position){
        this.currentPlayer.addMove(position);
        this.board.addSymbol(position, this.getCurrentPlayerSymbol());
        System.out.println(this.board.generateBoard());
        if(currentPlayer.hasWon(winningMoves)){
            this.gameStatus = "won";
            return;
        }
        this.changeTurn();
    }



}
