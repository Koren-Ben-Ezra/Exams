/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat,0,0);
    }

    private static int howManyPaths(int[][] mat, int row, int col) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length-1 || col > mat[0].length-1;
        if(outOfBoundaries)
            return 0;

        if(row == mat.length-1 && col == mat[0].length-1)
            return 1;

        int k = mat[row][col];
        mat[row][col] = mat.length;

        int amount = howManyPaths(mat,row+k,col) +
                howManyPaths(mat,row-k,col) +
                howManyPaths(mat,row,col+k) +
                howManyPaths(mat,row,col-k);

        mat[row][col] = k;
        return amount;
    }

    public static void main(String[] args){

        int[][] mat = {
                {1,3,1,6},
                {2,8,1,2},
                {6,2,7,5},
                {2,4,1,3}
        };

        System.out.println("expected 2: " + howManyPaths(mat));
        mat[0][0] = 4;
        System.out.println("expected 0: " + howManyPaths(mat));
    }
}
