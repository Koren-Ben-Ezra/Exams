/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int cntTrueReg(boolean[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        // visited array by default is all false.

        return cntTrueReg(mat, visited, 0, 0);
    }

    private static int cntTrueReg(boolean[][] mat, boolean[][] visited, int row, int col) {
        if (col > mat[0].length - 1) {
            col = 0;
            row++;
        }

        if (row > mat.length - 1)
            return 0;

        if (mat[row][col] && !visited[row][col]) {
            markArea(mat, visited, row, col);
            return 1 + cntTrueReg(mat, visited, row, col + 1);
        }
        return cntTrueReg(mat, visited, row, col + 1);
    }

    private static void markArea(boolean[][] mat, boolean[][] visited, int row, int col) {
        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;

        if (outOfBoundaries)
            return;

        boolean dontWantToGoTherePath = !mat[row][col] || visited[row][col];
        // don't really use this kind of names lol...

        if(dontWantToGoTherePath)
            return;

        visited[row][col] = true;

        markArea(mat, visited, row - 1, col);
        markArea(mat, visited, row, col + 1);
        markArea(mat, visited, row + 1, col);
        markArea(mat, visited, row, col - 1);
    }


    public static void main(String[] args) {

        boolean[][] mat1 = {
                {false, false, false, false, true},
                {false, true, true, true, false},
                {true, false, true, true, false},
                {true, false, false, false, false},
                {true, true, false, false, false}
        };

        System.out.println("expected 3: " + cntTrueReg(mat1));


        boolean[][] mat2 = {
                {true, false, true, false, true},
                {false, true, false, true, false},
                {true, false, true, false, true},
                {false, true, false, true, false},
                {true, false, true, false, true},
        };

        System.out.println("expected 13: " + cntTrueReg(mat2));


    }
}
