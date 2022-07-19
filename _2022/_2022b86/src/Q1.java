/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int maxPath(int[][] mat) {
        return maxPath(mat, 0, 0, 0);
    }

    // NOTE: They asked not to go out from the matrix's boundaries.
    // It is a bit confusing, I just never called the function if it's
    // beyond the matrix's boundaries.

    private static int maxPath(int[][] mat, int row, int col, int sum) {

        // Assuming row & col are within the matrix's boundaries.

        if (row == mat.length - 1 && col == mat[0].length - 1)
            return sum + mat[row][col];

        int ones = mat[row][col] % 10;
        int tens = mat[row][col] / 10;

        int move1 = Integer.MIN_VALUE, move2 = Integer.MIN_VALUE;

        boolean move1IsOkay = (row + ones) < mat.length && (col + tens) < mat[0].length;
        boolean move2IsOkay = (row + tens) < mat.length && (col + ones) < mat[0].length;

        if (move1IsOkay)
            move1 = maxPath(mat, row + ones, col + tens, sum + mat[row][col]);

        if (move2IsOkay)
            move2 = maxPath(mat, row + tens, col + ones, sum + mat[row][col]);


        return Math.max(move1, move2);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {12, 22, 23, 54, 11},
                {43, 35, 21, 20, 30},
                {34, 23, 43, 22, 30},
                {25, 31, 2, 20, 34},
                {10, 22, 10, 11, 10},
                {40, 13, 3, 1, 23}
        };

        System.out.println("expected 86: " + maxPath(mat));
    }
}
