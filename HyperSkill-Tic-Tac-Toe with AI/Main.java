package tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static char[][] chars = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public static void main(String[] args) {
    Logic game = new Logic();

        game.gameLogic(chars);


    }




}