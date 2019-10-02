import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows: ");
        int row = sc.nextInt();
        System.out.print("Cols: ");
        int col = sc.nextInt();
        int mat[][] = createMatrix(row, col);
        ReadMatrix m = new ReadMatrix(mat);
        m.startElaboration();
    }

    private static int[][] createMatrix(int r, int c) {
        Random ran = new Random();
        int[][] matrix = new int[r][c];
        for(int i = 0; i < r; i++)
            for(int y = 0; y < c; y++) {
                int min = 10;
                int max = 99 - min;
                // random numbers from 10 to 99
                matrix[i][y] = ran.nextInt(max) + min;
            }
        return matrix;
    }
}
