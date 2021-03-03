package tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static char nextSymbol = 'O';
    private static  boolean isFinished = false;
    public static void main(String[] args) {

        char[][] chars = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        printGrid(chars);

        Scanner scanner = new Scanner(System.in);

        int x,y;
        while (!isFinished) {
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.println("Enter the coordinates: ");
                String firstCoordinate = scanner.next();
                String secondCoordinate = scanner.next();
                if (isNumeric(firstCoordinate) && isNumeric(secondCoordinate)) {
                    x = Integer.parseInt(firstCoordinate);
                    y = Integer.parseInt(secondCoordinate);
                    if (x > 0 && x < 4 && y > 0 && y < 4) {
                        if (chars[x - 1][y - 1] == ' ') {
                            chars[x - 1][y - 1] = getSymbol();
                            isCorrect = true;
                        } else System.out.println("This cell is occupied! Choose another one!");
                    } else System.out.println("Coordinates should be from 1 to 3!");
                } else System.out.println("You should enter numbers!");
            }
            String result = null;
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
            }
            printGrid(chars);
            System.out.println(result);
        }

    }

    private static void printGrid(char[][] cells){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", cells[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    private static char getSymbol() {
        if(nextSymbol == 'X') nextSymbol = 'O';
        else nextSymbol = 'X';
        return nextSymbol;
    }
}