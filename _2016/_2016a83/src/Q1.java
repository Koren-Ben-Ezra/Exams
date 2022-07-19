/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int minPoints(int[][] m) {
        return minPoints(m, 1);
    }

    private static int minPoints(int[][] mat, int startingSum) {

        int tryThisSum = minPoints(mat, startingSum, startingSum, 0, 0);
        if (tryThisSum == -1)
            return minPoints(mat, startingSum + 1);
        return tryThisSum;
    }

    private static int minPoints(int[][] mat, int startingSum, int currSum, int row, int col) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return -1;

        boolean invalidPath = currSum + mat[row][col] <= 0 || currSum <= 0;
        if (invalidPath)
            return -1;

        if (row == mat.length - 1 && col == mat[0].length - 1)
            return startingSum;

        currSum += mat[row][col];
        return specialMin(minPoints(mat, startingSum, currSum, row + 1, col),
                minPoints(mat, startingSum, currSum, row, col + 1));
    }

    private static int specialMin(int a, int b) {

        if (b == -1 || (a < b && a != -1))
            return a;
        return b;
    }


    public static void main(String[] args) {

        int[][] mat = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println("expected 7: " + minPoints(mat));
    }
}
