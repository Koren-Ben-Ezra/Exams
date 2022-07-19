/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static boolean covers(int[][] mat, int[] arr, int k) {
        return covers(mat, arr, k, 0);
    }

    private static boolean covers(int[][] mat, int[] arr, int k, int row) {

        if (row > mat.length - 1 || k < 0)
            return false;

        if (allZero(arr))
            return true;

        int[] tempArr = new int[arr.length];
        copy(tempArr, arr);

        xZero(arr, mat[row]); // Marks the elements we have already seen with zeros.
        boolean unionCurrentRow = covers(mat, arr, k - 1, row + 1);

        copy(arr, tempArr); // Changes back the array and jumps to the next row without any changes.
        boolean jumpToNextRow = covers(mat, arr, k, row + 1);
        // NOTE: either way, we need to change back the array before the return.

        return unionCurrentRow || jumpToNextRow;
    }


    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //
    private static boolean allZero(int[] x) {
        for (int i = 0; i < x.length; i++)
            if (x[i] != 0)
                return false;
        return true;
    }

    private static void copy(int[] dest, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    private static void xZero(int[] x, int[] y) {
        int max = 0;
        for (int i = 0; i < y.length; i++) {
            max = Math.max(max, y[i]);
        }
        boolean[] exists = new boolean[max + 1];

        for (int i = 0; i < y.length; i++) {
            exists[y[i]] = true;
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] < exists.length && exists[x[i]])
                x[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {7, 2, 3};
        int[][] mat = {
                {1, 5, 7},
                {3, 2, 9},
                {1, 2, 3}
        };
        System.out.println("expected true: " + covers(mat, arr, 3));
        System.out.println("expected true: " + covers(mat, arr, 2));
        System.out.println("expected false: " + covers(mat, arr, 1));
    }
}
