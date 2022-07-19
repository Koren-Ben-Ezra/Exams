/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int findMaximum(int[][] mat) {
        if(mat[0][0] == -1)
            return -1;
        return findMaximum(mat, 0, 0);
    }

    private static int findMaximum(int[][] mat, int row, int col) {
        boolean outOfBoundaries = col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return 0;

        boolean inValidPath = mat[row][col] == -1;
        if (inValidPath)
            return 0;

        int tempVal = mat[row][col];
        mat[row][col] = -1;


        int down = tempVal + findMaximum(mat, row + 1, col);

        int horizontal;
        if (row % 2 == 0)
            horizontal = tempVal + findMaximum(mat, row, col + 1);
        else
            horizontal = tempVal + findMaximum(mat, row, col - 1);

        mat[row][col] = tempVal;

        return max(horizontal, down);
    }

    private static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }


    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, -1, 1, 1},
                {1, 0, 0, -1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, 1, 1, 1},
                {1, 1, -1, -1, 1}
        };
        System.out.println("expected 9: " + findMaximum(mat));

        mat[0][0] = -1;
        System.out.println("expected -1: " + findMaximum(mat));


    }
}
