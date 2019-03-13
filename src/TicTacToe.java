import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first player's name : ");
        String firstPlayerName = scanner.nextLine();

        System.out.print("Enter symbol choice => X or O : ");
        char firstPlayerSymbol = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("Enter second player's name : ");
        String secondPlayerName = scanner.nextLine();

        char secondPlayerSymbol = firstPlayerSymbol == 'X' ? 'O' : 'X';
        System.out.println(secondPlayerName + "'s symbol is " + secondPlayerSymbol);

        Player firstPlayer = new Player(firstPlayerName, firstPlayerSymbol);
        Player secondPlayer = new Player(secondPlayerName, secondPlayerSymbol);

        Game game = new Game(firstPlayer, secondPlayer);
        game.startGame();

        while (game.getGameStatus() == "continue"){
            Player currentPlayer = game.getCurrentPlayer();
            String playerName = currentPlayer.getName();
            System.out.print(playerName + "'s turn => Enter position : ");
            int position = scanner.nextInt();
            game.makeMove(position);
            System.out.println(game.generateBoard());
        }

        if(game.getGameStatus() == "won"){
            Player currentPlayer = game.getCurrentPlayer();
            String playerName = currentPlayer.getName();
            System.out.println(playerName + " has won");
        }
    }
}
