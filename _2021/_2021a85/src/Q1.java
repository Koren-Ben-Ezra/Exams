/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int minPrice(int[][] mat) {
        return minPrice(mat,0,0);
    }

    private static int minPrice(int[][] mat, int row, int col) {

        boolean outOfBoundaries = col > mat[1].length - 1 || row > col;
        if (outOfBoundaries)
            return Integer.MAX_VALUE;

        // Reached the last station within the available options, therefore have to buy the ticket.
        if (col == mat[1].length - 1)
            return mat[row][col];

        // first one: jumps to think about the next station, not buying ticket yet.
        // second one: buys ticket to the current station.
        return min(minPrice(mat, row, col + 1), mat[row][col] + minPrice(mat, row + 1, col));
    }

    private static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }


    public static void main(String[] args) {

        int[][] mat = {
                {0, 15, 80, 90},
                {-1, 0, 40, 50},
                {-1, -1, 0, 70},
                {-1, -1, -1, 0}
        };

        System.out.println("expected 65: " + minPrice(mat));

    }

}
