/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int longestWorm(int[][] mat) {
        return longestWorm(mat, 0, 0, 0);
    }

    private static int longestWorm(int[][] mat, int row, int col, int savedLength) {

        if (col > mat[0].length - 1) {
            col = 0;
            row++;
        }

        if (row > mat.length - 1)
            return savedLength;

        int currLength = longestWorm(mat, row, col, 0, mat[row][col] - 1);
        if (currLength > savedLength)
            savedLength = currLength;

        return longestWorm(mat, row, col + 1, savedLength);
    }

    private static int longestWorm(int[][] mat, int row, int col, int tempLength, int lastVal) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return tempLength;

        boolean invalidPath = mat[row][col] == Integer.MAX_VALUE || mat[row][col] != lastVal + 1;
        if (invalidPath)
            return tempLength;

        int tempVal = mat[row][col];
        mat[row][col] = Integer.MAX_VALUE;

        int up = longestWorm(mat, row - 1, col, tempLength + 1, tempVal);
        int right = longestWorm(mat, row, col + 1, tempLength + 1, tempVal);
        int down = longestWorm(mat, row + 1, col, tempLength + 1, tempVal);
        int left = longestWorm(mat, row, col - 1, tempLength + 1, tempVal);

        mat[row][col] = tempVal;
        return max(up, right, down, left);
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
                {50, 51, 52, 29, 30},
                {51, 10, 53, 54, 55},
                {53, 12, 14, 53, 11}
        };

        System.out.println("expected 6: " + longestWorm(mat));
    }
}
