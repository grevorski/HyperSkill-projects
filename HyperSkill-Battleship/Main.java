package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] grid1 = new char[10][10];
    public static char[][] grid2 = new char[10][10];
    public static char[][] fogOfWar = new char[10][10];
    public static char[][] fogOfWar2 = new char[10][10];
    public static final char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static int sunkedShips1 = 0;
    public static int sunkedShips2 = 0;

    public static void main(String[] args) {

        FillGrid(grid1);
        FillGrid(grid2);
        FillGrid(fogOfWar);
        FillGrid(fogOfWar2);
        DisplayGrid(grid1, alphabets);
        CheckCoordinates(grid1, alphabets, "Aircraft Carrier", 5);
        CheckCoordinates(grid1, alphabets, "Battleship", 4);
        CheckCoordinates(grid1, alphabets, "Submarine", 3);
        CheckCoordinates(grid1, alphabets, "Cruiser", 3);
        CheckCoordinates(grid1, alphabets, "Destroyer", 2);
        promptEnterKey();

        System.out.println("Player 2, place your ships to the game field");
        DisplayGrid(grid2, alphabets);
        CheckCoordinates(grid2, alphabets, "Aircraft Carrier", 5);
        CheckCoordinates(grid2, alphabets, "Battleship", 4);
        CheckCoordinates(grid2, alphabets, "Submarine", 3);
        CheckCoordinates(grid2, alphabets, "Cruiser", 3);
        CheckCoordinates(grid2, alphabets, "Destroyer", 2);
        promptEnterKey();
       // System.out.println("The game starts!");

        while(true) {

            DisplayGrid(fogOfWar2, alphabets);
            System.out.println("---------------------");
            DisplayGrid(grid1, alphabets);
            System.out.println("Player 1, it's your turn:");
            TakeShot(grid2, alphabets, fogOfWar2,sunkedShips1);

            if(sunkedShips2 == 5 || sunkedShips1 == 5) break;

            DisplayGrid(fogOfWar, alphabets);
            System.out.println("---------------------");
            DisplayGrid(grid2, alphabets);
            System.out.println("Player 2, it's your turn:");
            TakeShot(grid1, alphabets, fogOfWar,sunkedShips2);

            if(sunkedShips2 == 5 || sunkedShips1 == 5) break;


        }

    }
    public static void promptEnterKey(){
        System.out.println("Press Enter and pass the move to another player");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void TakeShot(char[][] grid, char[] alphabets , char[][] fogOfWar, int sunkedShips) {
        System.out.println("Take a shot!");
        String coordinate;
        int first;
        while (true) {
            coordinate = scanner.nextLine();
            try {
                first = Integer.parseInt(coordinate.substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                first = Integer.parseInt(String.valueOf(coordinate.charAt(1)));
            }
            if ((coordinate.charAt(0) >= 'A' && coordinate.charAt(0) <= 'J') && first<=10) {
                int index = new String(alphabets).indexOf(coordinate.charAt(0));
                switch(grid[index][first-1]){
                    case 'O':
                        grid[index][first-1] = 'X';
                        fogOfWar[index][first-1] ='X';
                       // DisplayGrid(fogOfWar, alphabets);

                            if(coordinate.charAt(0) == 'A' && first == 1){
                                if(grid[index+1][first-1] == 'O' || grid[index][first] == 'O'){
                                    System.out.println("You hit a ship!");
                                }else{
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);
                                }
                            }else if(coordinate.charAt(0) == 'J' && first == 1){
                                if(grid[index-1][first-1] == 'O' || grid[index][first] == 'O'){
                                    System.out.println("You hit a ship!");
                                }else{
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);
                                }
                            }else if(first == 1){
                                if(grid[index-1][first-1] == 'O' || grid[index+1][first-1] == 'O' || grid[index][first] == 'O'){
                                    System.out.println("You hit a ship!");
                                }else{
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);//first numer //index litera
                                }
                            }else if(coordinate.charAt(0) == 'A' && first == 10){
                                if(grid[index+1][first-1] == 'O' || grid[index][first-2] == 'O'){
                                    System.out.println("You hit a ship!");
                                }else{
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);//first numer //index litera
                                }
                            }else if(coordinate.charAt(0) == 'J' && first == 10) {
                                if (grid[index - 1][first - 1] == 'O' || grid[index][first - 2] == 'O') {
                                    System.out.println("You hit a ship!");
                                } else {
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);//first numer //index litera
                                }
                            }else if(first == 10) {
                                if (grid[index + 1][first - 1] == 'O' || grid[index - 1][first - 1] == 'O' || grid[index][first - 2] == 'O') {
                                    System.out.println("You hit a ship!");
                                } else {
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);//first numer //index litera
                                }
                            }else if(coordinate.charAt(0) == 'A'){
                                if (grid[index][first - 2] == 'O' || grid[index][first ] == 'O' || grid[index+1][first - 1] == 'O') {
                                    System.out.println("You hit a ship!");
                                } else {
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);//first numer //index litera
                                }
                            }else if(coordinate.charAt(0) == 'J'){
                                if (grid[index][first - 2] == 'O' || grid[index][first] == 'O' || grid[index-1][first - 1] == 'O') {
                                    System.out.println("You hit a ship!");
                                } else {
                                    sunkedShips++;
                                    SunkMessage(sunkedShips);
                                }
                            } else if (grid[index][first - 2] == 'O' || grid[index][first] == 'O' || grid[index - 1][first-1] == 'O' || grid[index + 1][first-1] == 'O') {
                                System.out.println("You hit a ship!");

                            } else {
                                sunkedShips++;
                                SunkMessage(sunkedShips);
                            }

                        break;
                    case '~':
                        grid[index][first-1] = 'M';
                        fogOfWar[index][first-1] ='M';
                       // DisplayGrid(Main.fogOfWar, alphabets);
                        System.out.println("You missed!");
                        break;
                   // case 'X':
                      //  DisplayGrid(Main.fogOfWar, alphabets);
                        //System.out.println("You've already shot here");
                       // break;
                }
                promptEnterKey();
                 break;
            } else{
                System.out.println("Error! You entered the wrong coordinates! Try again:");

            }
        }
    }
    public static void SunkMessage(int sunkedShips){
        if(sunkedShips == 1){
            System.out.println("You sank the last ship. You won. Congratulations!");
        }else System.out.println("You sank a ship! Specify a new target:");
    }
    public static void CheckCoordinates(char[][] grid, char[] alphabets, String shipName, int shipSize) {
        String[] coordinates;
        System.out.println("Enter the coordinates of the " + shipName + " (" + shipSize + " cells):");
        int first, second;
        while (true) {
            coordinates = scanner.nextLine().split(" ");

            try {
                first = Integer.parseInt(coordinates[0].substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                first = Integer.parseInt(String.valueOf(coordinates[0].charAt(1)));
            }
            try {
                second = Integer.parseInt(coordinates[1].substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                second = Integer.parseInt(String.valueOf(coordinates[1].charAt(1)));
            }

            if ((coordinates[0].charAt(0) >= 'A' && coordinates[1].charAt(0) <= 'J') && (first <=10 && second <=10)) {
                if (coordinates[0].charAt(0) == coordinates[1].charAt(0)) {
                    if (Math.abs(first - second) == shipSize - 1) {
                        int index = new String(alphabets).indexOf(coordinates[0].charAt(0));
                        if (first < second) {
                            for (int i = first - 1; i < second; i++) {
                                grid[index][i] = 'O';
                            }
                        } else {
                            for (int i = second - 1; i < first; i++) {
                                grid[index][i] = 'O';
                            }
                        }
                        DisplayGrid(grid, alphabets);
                        break;
                    } else {
                        System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
                    }
                } else {
                    int index1 = new String(alphabets).indexOf(coordinates[0].charAt(0));
                    int index2 = new String(alphabets).indexOf(coordinates[1].charAt(0));

                    if (first > 1 && second > 1 && index1 > 1 && index2 > 1 && index1 < 9 && index2 < 9) {
                        if (grid[index1 - 1][first] != 'O' && grid[index1 + 1][first] != 'O' && grid[index2 - 1][first] != 'O' && grid[index2 + 1][first] != 'O') {
                            if (index1 < index2 && first == second) {
                                for (int i = index1; i <= index2; i++) { //2gi if do fixa
                                    grid[i][first - 1] = 'O';
                                }
                                DisplayGrid(grid, alphabets);
                                break;
                            } else if(index1 > index2 && first == second){
                                for (int i = index2; i <= index1; i++) { //2gi if do fixa
                                    grid[i][first - 1] = 'O';
                                }
                                DisplayGrid(grid, alphabets);
                                break;
                            }else {
                                System.out.println("Error! Wrong ship location! Try again:");
                            }
                        } else {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                        }
                    } else {
                        if (index1 < index2 && first == second) {
                            for (int i = index1; i <= index2; i++) {
                                grid[i][first - 1] = 'O';
                            }
                            DisplayGrid(grid, alphabets);
                            break;
                        } else {
                            System.out.println("Error! Wrong ship location! Try again:");
                        }
                    }
                }
            } else{
                System.out.println("Error! Coordinates out of bounds");
            }
        }
    }
    public static void FillGrid(char[][] grid){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '~';
            }
        }
    }

    public static void DisplayGrid(char[][] grid, char[] alphabets) {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(alphabets[i] + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}