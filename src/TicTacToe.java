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

        while (game.isContinue()){
            String currentPlayerName = game.getCurrentPlayerName();
            System.out.print(currentPlayerName + "'s turn => Enter position : ");
            int position = scanner.nextInt();
            boolean moveStatus = game.makeMove(position);
            if(!moveStatus){
                System.out.println("Invalid position");
            }
            System.out.println(game.generateBoard());
        }
        System.out.println(game.getGameResult());
    }
}
