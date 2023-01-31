/**
 * Written by Tomer (aka CASIO15)
 * In 2023a
 */
public class Q1_Tomer {

    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }

    private static int cntTrueReg(boolean[][] mat, int i, int j, int cnt) {
        // Iterating over the matrix (similar to how you'd iterate over it with a loop)
        // Base condition (out of bounds) return the counter.
        if (i >= mat.length)
            return cnt;

        // Iterating over the columns
        if (j < mat.length) {
            // If the cell is 'true'
            if (mat[i][j]) {
                // Mark the area as false.
                markRegionsAsVisited(mat, i, j);
                // Call the recursion with cnt incremented by 1.
                return cntTrueReg(mat, i, j, cnt + 1);
            }
            // Next col
            return cntTrueReg(mat, i, j + 1, cnt);
        }
        // Next row, col = 0.
        return cntTrueReg(mat, i + 1, 0, cnt);
    }

    private static void markRegionsAsVisited(boolean[][] mat, int i, int j) {
        // Base condition.
        if (i < 0 || i >= mat.length || j < 0 || j >= mat.length)
            return;
        // If the cell is 'false' break from the recursion.
        if (!mat[i][j])
            return;

        // Mark the cell as visited.
        mat[i][j] = false;

        markRegionsAsVisited(mat, i - 1, j);
        markRegionsAsVisited(mat, i, j + 1);
        markRegionsAsVisited(mat, i + 1, j);
        markRegionsAsVisited(mat, i, j - 1);
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
