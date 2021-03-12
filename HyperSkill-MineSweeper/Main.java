package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] grid = new char[9][9];
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        fillGrid();
        fillWithMines(grid);
       // printGrid();
        fillWithHints(grid);
        //System.out.println("----------------------------------");
        printGrid();

    }

    public static void fillGrid(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public static void printGrid(){
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
      //  System.out.println(Arrays.deepToString(grid).replace("], ", "\n").replace("[[", "")
         //               .replace("]]", "").replace("[","").replace(", ",""));
    }

    public static void fillWithMines(char[][] grid){
        System.out.println("How many mines do you want on the field?");
        int mines = sc.nextInt();
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

    public static void fillWithHints(char[][] grid){

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                int temp = 48;

                if(grid[i][j] == '.'){
                if(i == 0 && j == 0){
                    if(grid[i+1][j] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i == 0 && j == 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i == 8 && j == 0){
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i == 8 && j == 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i-1][j] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i == 0 && j != 0 && j != 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i == 8 && j != 0 && j != 8){
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i != 0 && i != 8 && j == 0){
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j+1] == 'X') temp++;
                    if(grid[i][j+1] == 'X') temp++;
                    if(grid[i+1][j+1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                if(i != 0 && i != 8 && j == 8){
                    if(grid[i-1][j] == 'X') temp++;
                    if(grid[i-1][j-1] == 'X') temp++;
                    if(grid[i][j-1] == 'X') temp++;
                    if(grid[i+1][j-1] == 'X') temp++;
                    if(grid[i+1][j] == 'X') temp++;
                    if(temp > 48) grid[i][j] = (char)temp;
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
                    if(temp > 48) grid[i][j] = (char)temp;
                }

                }
            }
        }
    }
}

