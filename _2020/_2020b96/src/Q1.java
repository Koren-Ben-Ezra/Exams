/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int maxSumKnight(int[][] mat) {
        return maxSumKnight(mat, 0, 0, mat[0][0], 0);
    }

    private static int maxSumKnight(int[][] mat, int row, int col, int prevVal, int sum) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat.length - 1;
        if (outOfBoundaries)
            return -1;

        boolean invalidPath = Math.abs(mat[row][col] - prevVal) > 1 || mat[row][col] == -1;
        if (invalidPath)
            return -1;

        if (row == mat.length - 1 && col == mat.length - 1)
            return sum + mat[row][col];

        int tempVal = mat[row][col];
        mat[row][col] = -1;

        int d1 = maxSumKnight(mat, row + 2, col + 1, tempVal, sum + tempVal);
        int d2 = maxSumKnight(mat, row + 2, col - 1, tempVal, sum + tempVal);
        int d3 = maxSumKnight(mat, row - 2, col + 1, tempVal, sum + tempVal);
        int d4 = maxSumKnight(mat, row - 2, col - 1, tempVal, sum + tempVal);
        int d5 = maxSumKnight(mat, row + 1, col + 2, tempVal, sum + tempVal);
        int d6 = maxSumKnight(mat, row - 1, col + 2, tempVal, sum + tempVal);
        int d7 = maxSumKnight(mat, row + 1, col - 2, tempVal, sum + tempVal);
        int d8 = maxSumKnight(mat, row - 1, col - 2, tempVal, sum + tempVal);

        mat[row][col] = tempVal;

        return max(d1, d2, d3, d4, d5, d6, d7, d8);
    }

    private static int max(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8) {
        return max(max(max(a1, a2), max(a3, a4)), max(max(a5, a6), max(a7, a8)));
    }

    private static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {4, 5, 6, 7, 1},
                {3, 5, 1, 7, 4},
                {4, 5, 6, 5, 8},
                {3, 4, 7, 7, 9},
                {6, 2, 2, 7, 6}
        };

        System.out.println("expected 28: " + maxSumKnight(mat));
    }
}
