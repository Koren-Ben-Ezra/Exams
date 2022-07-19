/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    /**
     * Answer to 1.a
     */
    public static int where(int[] vec) {
        return where(vec, 0, 1, vec.length - 1);
    }

    private static int where(int[] vec, int left, int p, int right) {
        if (p == vec.length)
            return -1;

        int tempP;
        if (sum(vec, left, p - 1) == sum(vec, p, right))
            tempP = p;
        else
            tempP = -1;

        if (tempP == -1)
            return where(vec, left, p + 1, right);
        return tempP;
    }

// -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    /**
     * Answer to 1.b
     */
    public static boolean isBalanced(int[] vec, int k) {

        return isBalanced(vec, k, 0, 0, vec.length - 1);
    }

    private static boolean isBalanced(int[] vec, int k, int low, int p, int high) {

        if (k == 0)
            return true;

        p = where(vec, low, p, high);
        if (p == -1)
            return false;

        if (isBalanced(vec, k - 1, low, low + 1, p - 1) &&
                isBalanced(vec, k - 1, p, p + 1, high))
            return true;

        return isBalanced(vec, k, low, p + 1, high);
    }


    // -- -- -- NOT PART OF THE SOLUTION -- -- -- //
    private static int sum(int[] vec, int lo, int hi) {
        if (lo > hi)
            return 0;

        return vec[lo] + sum(vec, lo + 1, hi);
    }


    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    public static void main(String[] args) {
        System.out.println("expected 2: " + where(new int[]{5, 6, 1, 2, 8}));
        int[] arr = {1, 2, 2, 1, 3, 2, 1, 3, 4, -1, 3, 3};
        System.out.println("expected true: " + isBalanced(arr, 3));

        arr[10] = 4;
        arr[11] = 2;
        System.out.println("expected false: " + isBalanced(arr, 3));
        System.out.println("expected true: " + isBalanced(arr, 2));
    }

}
