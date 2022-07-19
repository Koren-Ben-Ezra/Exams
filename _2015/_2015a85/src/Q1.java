/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int countRopes(int[][] mat) {
        return countRopes(mat, 0);
    }

    private static int countRopes(int[][] mat, int col) {

        if (col == mat[0].length)
            return 0;

        return countRopes(mat, 0, col, mat[0][col] + 1) + countRopes(mat, col + 1);
    }

    private static int countRopes(int[][] mat, int row, int col, int lastVal) {

        boolean outOfBoundaries = col < 0 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return 0;

        if (row == mat.length - 1) {
            if (mat[row][col] > 0 && mat[row][col] < lastVal)
                return 1;
            else
                return 0;
        }

        if (mat[row][col] >= lastVal)
            return 0;

        return countRopes(mat, row + 1, col - 1, mat[row][col]) +
                countRopes(mat, row + 1, col, mat[row][col]) +
                countRopes(mat, row + 1, col + 1, mat[row][col]);
    }


    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0, 10, 0, 0},
                {0, 0, 8, 0, 9, 0},
                {0, 6, 0, 0, 0, 7},
                {3, 0, 4, 0, 0, 5},
                {1, 2, 0, 0, 0, 2}
        };

        System.out.println("expected 4: " + countRopes(mat));

        mat[2][3] = 5;
        System.out.println("expected 6: " + countRopes(mat));
    }
}
