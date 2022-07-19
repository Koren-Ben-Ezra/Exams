/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int shortestPath(int[][] mat) {
        return shortestPath(mat, 0, 0, mat[0][0] - 1, 0);
    }

    private static int shortestPath(int[][] mat, int row, int col, int lastVal, int steps) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return Integer.MAX_VALUE;

        if (row == mat.length - 1 && col == mat[0].length - 1)
            return steps + 1;

        boolean invalidPath = lastVal >= mat[row][col] || mat[row][col] == -1;
        if (invalidPath) {
            return Integer.MAX_VALUE;
        }


        int tempVal = mat[row][col];
        mat[row][col] = -1;

        int move1 = shortestPath(mat, row + 1, col, tempVal, steps + 1);
        int move2 = shortestPath(mat, row - 1, col, tempVal, steps + 1);
        int move3 = shortestPath(mat, row, col + 1, tempVal, steps + 1);
        int move4 = shortestPath(mat, row, col - 1, tempVal, steps + 1);

        mat[row][col] = tempVal;
        return min(move1, move2, move3, move4);
    }

    private static int min(int a, int b, int c, int d) {
        if (a < b)
            b = a;
        if (c < d)
            d = c;

        if (b < d)
            d = b;
        return d;
    }


    public static void main(String[] args) {

        int[][] mat = {
                {3, 13, 15, 28, 30},
                {40, 51, 52, 29, 30},
                {28, 10, 53, 54, 53},
                {53, 12, 55, 53, 60},
                {70, 62, 56, 20, 80},
                {80, 81, 90, 95, 100}
        };

        System.out.println("expected 10: " + shortestPath(mat));
    }
}
