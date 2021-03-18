package tictactoe;

import java.util.*;

public class Logic extends Grid{
    public boolean isFinished = false;
    private final Scanner scanner = new Scanner(System.in);
    private char nextSymbol;


    public void playerMove(char[][] chars){
        int x = -1;
        int y = -1;

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
        printGrid(chars);
        result(chars);
    }

    private void result(char[][] chars){

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
            resetGrid(chars);
            isFinished = true;
        } else if (sums.contains(237)) {
            result = "O wins";
            resetGrid(chars);
            isFinished = true;
        } else if (xNum + oNum == 9) {
            result = "Draw";
            resetGrid(chars);
            isFinished = true;
        }

        System.out.println(result);

    }

    private  char getSymbol() {
        if(nextSymbol == 'X') nextSymbol = 'O';
        else nextSymbol = 'X';
        return nextSymbol;
    }

    public void easyAi(char[][] chars){
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
            while(true) {
                int randomX = random.nextInt(3);
                int randomY = random.nextInt(3);
                if(chars[randomX][randomY] == ' '){
                    chars[randomX][randomY] = getSymbol();
                    break;
                }
            }
        printGrid(chars);
        result(chars);
    }

    public void gameOptions(char[][] chars){
        boolean exit = false;

        String input;
        while(!exit) {
            System.out.println("Input command: ");
            input = scanner.nextLine();
            if(input.equals("")) input = scanner.nextLine();
            switch (input) {
                case "start easy easy":

                    printGrid(chars);
                    while (!isFinished) {
                        easyAi(chars);
                        if (isFinished) break;
                        easyAi(chars);
                    }
                    isFinished=false;
                    break;
                case "start easy user":

                    printGrid(chars);
                    while (!isFinished) {
                        easyAi(chars);
                        if (isFinished) break;
                        playerMove(chars);
                    }
                    isFinished=false;
                    break;
                case "start user easy":

                    printGrid(chars);
                    while (!isFinished) {
                        playerMove(chars);
                        if (isFinished) break;
                        easyAi(chars);
                    }
                    isFinished=false;
                    break;
                case "start user user":

                    printGrid(chars);
                    while (!isFinished) {
                        playerMove(chars);
                        if (isFinished) break;
                        playerMove(chars);
                    }
                    isFinished=false;
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Bad parameters!");

            }
        }
    }
}
