import java.util.Random;
import java.util.Scanner;

/**
 * @author Matteo Lucchini
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("# of rows & cols (N x N): ");
        int dim = sc.nextInt();
        int mat[][] = createMatrix(dim, dim);
        ReadMatrix m = new ReadMatrix(mat);
        m.startElaboration();
    }

    /**
     *
     * @param r is number of rows in the matrix
     * @param c is number of columns in the matrix
     * @return random matrix containing values between 10 and 99
     */
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
