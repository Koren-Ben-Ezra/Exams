/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int totalWays(int[][] mat, int k) {
        return totalWays(mat, k, 0, 0, '0');
    }

    private static int totalWays(int[][] mat, int turnsLeft, int row, int col, char lastAction) {

        boolean outOfBoundaries = row > mat.length - 1 || col > mat[1].length - 1 || turnsLeft < 0;
        if (outOfBoundaries)
            return 0;

        if (row == mat.length - 1 && col == mat[1].length - 1) {
            if (turnsLeft == 0)
                return 1;
            return 0;
        }


        if (lastAction == '0')
            return totalWays(mat, turnsLeft, row, col + 1, 'R') +
                    totalWays(mat, turnsLeft, row + 1, col, 'D');

        else if (lastAction == 'R')
            return totalWays(mat, turnsLeft, row, col + 1, 'R') +
                    totalWays(mat, turnsLeft - 1, row + 1, col, 'D');

        else //if (lastAction == 'D')
            return totalWays(mat, turnsLeft - 1, row, col + 1, 'R') +
                    totalWays(mat, turnsLeft, row + 1, col, 'D');
    }


    public static void main(String[] args) {

        int[][] mat = new int[3][3];
        System.out.println("expected 2: " + totalWays(mat, 1));
        System.out.println("expected 2: " + totalWays(mat, 2));
        System.out.println("expected 2: " + totalWays(mat, 3));
        System.out.println("expected 0: " + totalWays(mat, 4));

    }
}
