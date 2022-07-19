/**
 * Notes by Koren Ben Ezra
 * In 2022b
 */
public class Q2_section_a_b {

    /*
    what method is searching for sub-array that it's sum equals to num.

    f: Time complexity O(n), Space complexity O(1)
    --> what: Time complexity O(n^2 * n), Space complexity O(1)

    In conclusion, what: Time complexity O(n^3), Space complexity O(1)
     */

    private static int f(int[] a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];

        return res;
    }

    public static boolean what(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (f(a, i, j) == num)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        boolean result1 = what(new int[]{1, 2, 3, 4, 5, 6, 7}, 12); // <-- debug this line
        // 3 + 4 + 5 = 12
        System.out.println("expected true: " + result1);

        boolean result2 = what(new int[]{1, 2, 3, 4, 5, 6, 7}, -1); // <-- debug this line
        // 3 + 4 + 5 = 12
        System.out.println("expected false: " + result2);
    }
}
