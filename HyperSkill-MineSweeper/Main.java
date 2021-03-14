package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] grid = new char[9][9];
    public static char[][] grid1 = new char[9][9];
    public static final Scanner sc = new Scanner(System.in);
    public static int countX = 0;
    public static int countStar = 0;
    public static void main(String[] args) {
        fillGrid();

        System.out.println("How many mines do you want on the field?");
        int mines = sc.nextInt();

        fillWithMines(grid,mines);
        fillWithHints(grid,grid1);
        printGrid();
        guessMine(mines);

    }

    public static void guessMine(int mines){
        while(true){
            System.out.println("Set/delete mines marks (x and y coordinates): ");
            int y = sc.nextInt();
            int x = sc.nextInt();

            if(grid1[x-1][y-1] == '.') {
                grid1[x-1][y-1] = '*';
                countStar++;
                printGrid();
                if(grid[x-1][y-1] == 'X') countX++;

            }else if(grid1[x-1][y-1] == '*'){
                grid1[x-1][y-1] = '.';
                countStar--;
                printGrid();
            } else System.out.println("There is a number here!");

            if(countStar - countX == 0) {
                System.out.println("Congratulations! You found all mines!");
                break;
            }
        }

    }

    public static void fillGrid(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = '.';
                grid1[i][j] = '.';
            }
        }
    }

    public static void printGrid(){
        System.out.print(" |");
        for(int i = 1 ; i <10; i++) System.out.print(i);
        System.out.print("|\n-|---------|");
        System.out.println();
        for(int i = 1; i<10; i++)
        {
            System.out.print(i + "│");
            for(int j = 0; j<9; j++)
            {
                System.out.print(grid1[i-1][j]);
            }
            System.out.print("│");
            System.out.println();
        }
        System.out.print("-|---------|\n");

    }

    public static void fillWithMines(char[][] grid, int mines){

        Random random = new Random();
        for(int i =0; i<mines; i++){
            while(true) {
                int randomX = random.nextInt(9);
                int randomY = random.nextInt(9);
                if(grid[randomX][randomY] == '.'){
                    grid[randomX][randomY] = 'X';
                    break;
                }
            }
        }
    }

    public static void fillWithHints(char[][] grid, char[][]grid1){

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                int temp = 48;

                if(grid[i][j] == '.'){
                if(i == 0 && j == 0){
                    if(grid[i+1][j] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i == 0 && j == 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i == 8 && j == 0){
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i == 8 && j == 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i-1][j] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i == 0 && j != 0 && j != 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i == 8 && j != 0 && j != 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i != 0 && i != 8 && j == 0){
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i != 0 && i != 8 && j == 8){
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                if(i>0 && j>0 && i<8 && j<8){
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(temp > 48) {
                        grid[i][j] = (char)temp;
                        grid1[i][j] = (char)temp;
                    }
                }

                }
            }
        }
    }
}

