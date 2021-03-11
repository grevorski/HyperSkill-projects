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

    public static void main(String[] args) {

        FillGrid(grid1);
        FillGrid(grid2);
        FillGrid(fogOfWar);
        FillGrid(fogOfWar2);
        System.out.println("Player 1, place your ships to the game field");
        DisplayGrid(grid1, alphabets);
        for(Ships ship: Ships.values()) {
            CheckCoordinates(grid1, alphabets, ship.shipString, ship.shipSize);
        }
        promptEnterKey();

        System.out.println("Player 2, place your ships to the game field");
        DisplayGrid(grid2, alphabets);
        for(Ships ship: Ships.values()) {
            CheckCoordinates(grid2, alphabets, ship.shipString, ship.shipSize);
        }
        promptEnterKey();

        while(true) {

            DisplayGrid(fogOfWar2, alphabets);
            System.out.println("---------------------");
            DisplayGrid(grid1, alphabets);
            System.out.println("Player 1, it's your turn:");
            TakeShot(grid2, alphabets, fogOfWar2);
            if(!(SunkedShips.getSunkedShips1() == 5 || SunkedShips.getSunkedShips2() == 5)) promptEnterKey();
            else break;

            DisplayGrid(fogOfWar, alphabets);
            System.out.println("---------------------");
            DisplayGrid(grid2, alphabets);
            System.out.println("Player 2, it's your turn:");
            TakeShot(grid1, alphabets, fogOfWar);
               if(!(SunkedShips.getSunkedShips1() == 5 || SunkedShips.getSunkedShips2() == 5)) promptEnterKey();
               else break;


        }

    }
    public static final class SunkedShips {

        private static int sunkedShips1 = 0;
        private static int sunkedShips2 = 0;

        public static int getSunkedShips1(){
            return sunkedShips1;
        }
        public static int getSunkedShips2(){
            return sunkedShips2;
        }

        public static void increaseSunkedShips1(){
            SunkedShips.sunkedShips1++;
            System.out.println(sunkedShips1);
        }
        public static void increaseSunkedShips2( ){
            SunkedShips.sunkedShips2++;
            System.out.println(sunkedShips2);
        }
    }
    public static void SunkMessage(char[][] grid  ){
        if(grid == grid1){
            SunkedShips.increaseSunkedShips1();
        }else{
            SunkedShips.increaseSunkedShips2();
        }
        if(SunkedShips.getSunkedShips1() == 5 || SunkedShips.getSunkedShips2() == 5){
            System.out.println("You sank the last ship. You won. Congratulations!");
        }else System.out.println("You sank a ship! Specify a new target:");
    }

    public static void TakeShot(char[][] grid, char[] alphabets , char[][] fogOfWar) {
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

                        if(coordinate.charAt(0) == 'A' && first == 1){
                            if(grid[index+1][first-1] == 'O' || grid[index][first] == 'O'){
                                System.out.println("You hit a ship!");
                            }else{
                                SunkMessage(grid);
                            }
                        }else if(coordinate.charAt(0) == 'J' && first == 1){
                            if(grid[index-1][first-1] == 'O' || grid[index][first] == 'O'){
                                System.out.println("You hit a ship!");
                            }else{
                                SunkMessage(grid);
                            }
                        }else if(first == 1){
                            if(grid[index-1][first-1] == 'O' || grid[index+1][first-1] == 'O' || grid[index][first] == 'O'){
                                System.out.println("You hit a ship!");
                            }else{
                                SunkMessage(grid);
                            }
                        }else if(coordinate.charAt(0) == 'A' && first == 10){
                            if(grid[index+1][first-1] == 'O' || grid[index][first-2] == 'O'){
                                System.out.println("You hit a ship!");
                            }else{
                                SunkMessage(grid);
                            }
                        }else if(coordinate.charAt(0) == 'J' && first == 10) {
                            if (grid[index - 1][first - 1] == 'O' || grid[index][first - 2] == 'O') {
                                System.out.println("You hit a ship!");
                            } else {
                                SunkMessage(grid);
                            }
                        }else if(first == 10) {
                            if (grid[index + 1][first - 1] == 'O' || grid[index - 1][first - 1] == 'O' || grid[index][first - 2] == 'O') {
                                System.out.println("You hit a ship!");
                            } else {
                                SunkMessage(grid);
                            }
                        }else if(coordinate.charAt(0) == 'A'){
                            if (grid[index][first - 2] == 'O' || grid[index][first ] == 'O' || grid[index+1][first - 1] == 'O') {
                                System.out.println("You hit a ship!");
                            } else {
                                SunkMessage(grid);//first numer //index litera
                            }
                        }else if(coordinate.charAt(0) == 'J'){
                            if (grid[index][first - 2] == 'O' || grid[index][first] == 'O' || grid[index-1][first - 1] == 'O') {
                                System.out.println("You hit a ship!");
                            } else {
                                SunkMessage(grid);
                            }
                        } else if (grid[index][first - 2] == 'O' || grid[index][first] == 'O' || grid[index - 1][first-1] == 'O' || grid[index + 1][first-1] == 'O') {
                            System.out.println("You hit a ship!");

                        } else {
                            SunkMessage(grid);
                        }

                        break;
                    case '~':
                        grid[index][first-1] = 'M';
                        fogOfWar[index][first-1] ='M';
                        System.out.println("You missed!");
                        break;
                    case 'X':
                        DisplayGrid(Main.fogOfWar, alphabets);
                        System.out.println("You've already shot here");
                        break;
                }

                break;
            } else{
                System.out.println("Error! You entered the wrong coordinates! Try again:");

            }
        }
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
                                for (int i = index1; i <= index2; i++) {
                                    grid[i][first - 1] = 'O';
                                }
                                DisplayGrid(grid, alphabets);
                                break;
                            } else if(index1 > index2 && first == second){
                                for (int i = index2; i <= index1; i++) {
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

    public static void promptEnterKey(){

            System.out.println("Press Enter and pass the move to another player");
            try {
                int read = System.in.read(new byte[2]);
            } catch (IOException e) {
                e.printStackTrace();

        }
    }

    public enum Ships{
        AIRCRAFT_CARRIER (5, "Aircraft Carrier"),
        BATTLESHIP (4, "Battleship"),
        SUBMARINE (3, "Submarine"),
        CRUISER (3, "Cruiser"),
        DESTROYER (2, "Destroyer");

        final int shipSize;
        final String shipString;

        Ships(int shipSize, String shipString) {
            this.shipSize = shipSize;
            this.shipString = shipString;
        }
    }
}