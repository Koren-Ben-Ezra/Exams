/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int longestSlope(int[][] mat, int num) {
        return longestSlope(0, mat, num, 0, 0);
    }

    private static int longestSlope(int savedLength, int[][] mat, int num, int row, int col) {

        if (col > mat[0].length - 1) {
            row++;
            col = 0;
        }

        if (row > mat.length - 1)
            return savedLength;

        int currSlope = longestSlope(mat, num, mat[row][col] + num, row, col);
        if (currSlope > savedLength)
            savedLength = currSlope;

        return longestSlope(savedLength, mat, num, row, col + 1);
    }

    private static int longestSlope(int[][] mat, int num, int prevVal, int row, int col) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return 0;

        boolean invalidSlope = prevVal - mat[row][col] != num;
        if (invalidSlope)
            return 0;

        int tempVal = mat[row][col];
        mat[row][col] = Integer.MAX_VALUE;

        int up = longestSlope(mat, num, tempVal, row - 1, col);
        int right = longestSlope(mat, num, tempVal, row, col + 1);
        int down = longestSlope(mat, num, tempVal, row + 1, col);
        int left = longestSlope(mat, num, tempVal, row, col - 1);

        mat[row][col] = tempVal;

        return 1 + max(up, right, down, left);
    }

    private static int max(int a, int b, int c, int d) {

        if (a < b)
            a = b;
        if (c < d)
            c = d;

        if (a < c)
            a = c;

        return a;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {3, 13, 15, 28, 30},
                {55, 54, 53, 27, 26},
                {54, 12, 52, 51, 50},
                {50, 10, 8, 53, 11}
        };


        System.out.println("expected 6: " + longestSlope(mat, 1));
        System.out.println("expected 3: " + longestSlope(mat, 2));
    }
}
