/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int minPath(char[][] minChess, int i, int j) {
        return minPath(minChess, 0, i, j);
    }

    private static int minPath(char[][] minChess, int steps, int row, int col) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > minChess.length - 1 || col > minChess[0].length - 1;
        if (outOfBoundaries)
            return Integer.MAX_VALUE;

        if (minChess[row][col] == '#')
            return Integer.MAX_VALUE;


        if (minChess[row][col] == 'K')
            return steps;

        char tempChar = minChess[row][col];
        // It's not necessary here to save the last char, it's always the same.
        // but for good practice we would save it.
        minChess[row][col] = '#';

        int move1 = minPath(minChess, steps + 1, row + 2, col + 1);
        int move2 = minPath(minChess, steps + 1, row + 2, col - 1);
        int move3 = minPath(minChess, steps + 1, row - 2, col + 1);
        int move4 = minPath(minChess, steps + 1, row - 2, col - 1);
        int move5 = minPath(minChess, steps + 1, row + 1, col + 2);
        int move6 = minPath(minChess, steps + 1, row - 1, col + 2);
        int move7 = minPath(minChess, steps + 1, row + 1, col - 2);
        int move8 = minPath(minChess, steps + 1, row - 1, col - 2);

        minChess[row][col] = tempChar;
        // As said on top, we could replace this row with:
        // minChess[row][col] = '0';

        return min(move1, move2, move3, move4, move5, move6, move7, move8);
    }

    private static int min(int m1, int m2, int m3, int m4, int m5, int m6, int m7, int m8) {

        int a = min(m1, m2, m3, m4);
        int b = min(m5, m6, m7, m8);

        if (a < b)
            b = a;
        return b;
    }

    private static int min(int m1, int m2, int m3, int m4) {
        if (m1 < m2)
            m2 = m1;

        if (m3 < m4)
            m4 = m3;

        if (m2 < m4)
            m4 = m2;

        return m4;
    }


    public static void main(String[] args) {

        char[][] minChess1 = {
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', 'K', '0'},
                {'H', '0', '0', '0'}
        };
        System.out.println("expected 1: " + minPath(minChess1, 3, 0));

        char[][] minChess2 = {
                {'0', '0', '0', '0'},
                {'0', '0', 'K', '0'},
                {'0', '0', '0', '0'},
                {'H', '0', '0', '0'}
        };
        System.out.println("expected 4: " + minPath(minChess2, 3, 0));

        char[][] minChess3 = {
                {'0', '0', 'K', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'H', '0', '0', '0'}
        };
        System.out.println("expected 3: " + minPath(minChess3, 3, 0));
    }
}
