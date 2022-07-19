/**
 * Taken from the official solutions in MEGA doc
 */
public class Q1_anotherSolution {

    public static void printPath(int[][] mat) {
        printPath(mat, 0, 0);
    }

    private static void printPath(int[][] mat, int row, int col) {

        System.out.print("(" + row + "," + col + ")");

        int currVal = mat[row][col];
        // The recursion will NOT go to a place the matrix is not defined,
        // so it's okay to get the current value without checking for boundaries.

        if ((row - 1) >= 0 && mat[row - 1][col] > currVal)
            printPath(mat, row - 1, col);

        else if ((col + 1) <= mat[0].length && mat[row][col + 1] > currVal)
            printPath(mat, row, col + 1);

        else if ((row + 1) <= mat.length && mat[row + 1][col] > currVal)
            printPath(mat, row + 1, col);

        else if ((col - 1) >= 0 && mat[row][col - 1] > currVal)
            printPath(mat, row, col - 1);

        else{
            System.out.println(); // End the printed line.
            //return;
        }
    }


    public static void main(String[] args) {


        int[][] mat = {
                {3, 8, 7, 1},
                {5, 15, 2, 4},
                {12, 14, -13, 22},
                {13, 16, 17, 52}
        };
        System.out.print("expected: (0,0)(0,1)(1,1) \n" +
                "received: ");
        printPath(mat);
    }
}
