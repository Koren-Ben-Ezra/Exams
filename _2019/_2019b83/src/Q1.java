/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int longestPath(int[][] mat, int x, int y) {
        return longestPath(mat,x,y,0,0,0);
    }

    private static int longestPath(int[][] mat, int x, int y, int count, int row, int col) {
        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return 0;

        if (mat[row][col] != 1)
            return 0;

        if (row == x && col == y)
            return count + 1;

        mat[row][col] = 0;

        int up = longestPath(mat, x, y, count + 1, row - 1, col);
        int right = longestPath(mat, x, y, count + 1, row, col + 1);
        int down = longestPath(mat, x, y, count + 1, row + 1, col);
        int left = longestPath(mat, x, y, count + 1, row, col - 1);

        mat[row][col] = 1;
        return max(up, right, down, left);
    }

    public static int max(int a, int b, int c, int d) {
        if (a < b)
            a = b;

        if (c < d)
            c = d;

        if (a < c)
            a = c;

        return a;
    }

    public static void main(String[] args){

        int[][] mat = {
                {1,1,1,1,1,1,1},
                {1,1,0,1,0,0,1},
                {1,1,1,1,0,1,1}
        };

        int longestPath = longestPath(mat,2,5);
        System.out.println("expected 16: " + longestPath);
    }

}
