package tictactoe;

public class Grid {

    public void printGrid(char[][] cells){
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

    public void resetGrid(char[][] cells){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }

    }

}
