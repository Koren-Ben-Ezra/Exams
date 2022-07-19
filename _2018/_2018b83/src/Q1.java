/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int prince(int[][] drm, int i, int j) {
        return prince(drm, i, j, drm[i][j], 0);
    }

    private static int prince(int[][] mat, int row, int col, int prevVal, int count) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return -1;

        if (mat[row][col] == -1)
            return count + 1;

        // if the prince jumped to a spot that was too low or too high, or jumped to a spot that he was already at.
        boolean invalidPath = mat[row][col] == -2 || prevVal > mat[row][col] + 2 || prevVal < mat[row][col] - 1;
        if (invalidPath)
            return -1;

        int tempVal = mat[row][col];
        mat[row][col] = -2;

        int north = prince(mat, row - 1, col, tempVal, count + 1);
        int east = prince(mat, row, col + 1, tempVal, count + 1);
        int south = prince(mat, row + 1, col, tempVal, count + 1);
        int west = prince(mat, row, col - 1, tempVal, count + 1);

        mat[row][col] = tempVal;

        return specialMin(north, east, south, west);
    }

    private static int specialMin(int a, int b, int c, int d) {

        if ((b == -1) || (a != -1 && a < b))
            b = a;

        if (d == -1 || (c < d && c != -1))
            d = c;

        if (d == -1 || (b < d && b != -1))
            return b;

        return d;

    }

    public static void main(String[] args) {

        int[][] arr = {
                {2, 0, 1, 2, 3},
                {2, 3, 5, 5, 4},
                {8, -1, 6, 8, 7},
                {3, 4, 7, 2, 4},
                {2, 4, 3, 1, 2}
        };

        int length = prince(arr, 0, 0);
        System.out.println("expected 4: " + length);

        length = prince(arr, 4, 4);
        System.out.println("expected -1: " + length);
    }

}
