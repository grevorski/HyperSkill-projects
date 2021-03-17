package tictactoe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Logic {
    private boolean isFinished = false;
    private final Scanner scanner = new Scanner(System.in);
    private char nextSymbol;
    Grid grid = new Grid();

    public void gameLogic(char[][] chars){
        System.out.println("Enter the cells: ");
        String cells = scanner.nextLine().replace("_"," ");
        int k = 0;
        int xCount =0;
        int oCount =0;

        // convert the string into grid
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(cells.charAt(k) == 'X') xCount++;
                if(cells.charAt(k) == 'O') oCount++;


                chars[i][j] = cells.charAt(k);
                k++;
            }
        }
        if(xCount>oCount) nextSymbol = 'X';
        else if(xCount<oCount) nextSymbol = 'O';
        else nextSymbol ='O';

        grid.printGrid(chars);
        int x = -1;
        int y = -1;
        while (!isFinished) {
            boolean isCorrect = false;
            while (!isCorrect) {
                while(!isCorrect) {
                    System.out.println("Enter the coordinates: ");
                    try {
                        x = scanner.nextInt();
                        y = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("You should enter numbers!");
                        scanner.next();
                    }
                    isCorrect = true;
                }

                    if (x > 0 && x < 4 && y > 0 && y < 4) {
                        if (chars[x - 1][y - 1] == ' ') {
                            chars[x - 1][y - 1] = getSymbol();
                        } else{
                            isCorrect = false;
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        isCorrect = false;
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
            }

            String result = "";
            int xNum = 0;
            int oNum = 0;
            List<Object> sums = new ArrayList<>();

            for (char[] aChar : chars) {
                int sum = 0;
                for (int j = 0; j < chars.length; j++) {
                    char ch = aChar[j];
                    switch (ch) {
                        case 'X'://88
                            xNum++;
                            break;
                        case 'O'://79
                            oNum++;
                            break;
                        default:
                            break;
                    }
                    sum += ch;
                }
                sums.add(sum);
            }
            sums.add(chars[0][0] + chars[1][0] + chars[2][0]);
            sums.add(chars[0][1] + chars[1][1] + chars[2][1]);
            sums.add(chars[0][2] + chars[1][2] + chars[2][2]);
            sums.add(chars[0][0] + chars[1][1] + chars[2][2]);
            sums.add(chars[0][2] + chars[1][1] + chars[2][0]);
            if (Math.abs(xNum - oNum) > 1 || sums.contains(264) && sums.contains(237)) {
                result = "Impossible";
            } else if (sums.contains(264)) {
                result = "X wins";
                isFinished = true;
            } else if (sums.contains(237)) {
                result = "O wins";
                isFinished = true;
            } else if (xNum + oNum == 9) {
                result = "Draw";
                isFinished = true;
            } else {
                result = "Game not finished";
                isFinished = true;
            }
            grid.printGrid(chars);
            System.out.println(result);
        }
    }
    private  boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    private  char getSymbol() {
        if(nextSymbol == 'X') nextSymbol = 'O';
        else nextSymbol = 'X';
        return nextSymbol;
    }
}
