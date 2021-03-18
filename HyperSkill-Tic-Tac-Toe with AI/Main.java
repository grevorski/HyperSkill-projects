package tictactoe;

public class Main extends Logic{

    public static char[][] chars = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public static void main(String[] args) {
    Logic game = new Logic();

            game.gameOptions(chars);

    }
}