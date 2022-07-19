/**
 * Notes by Koren Ben Ezra
 * In 2022b
 */
public class Q2_section_a_b {

    // This question is partly recycled from 2015a 91

    /*

    what method is searching for longest sub-array that it's sum is an odd number.
    If the array is empty, or does not contain any sub-array as requested, returns 0.

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

    public static int what(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {

                int c = f(a, i, j);
                if (c % 2 == 1 && (j - i + 1) > temp)
                    temp = j - i + 1;

            }
        }
        return temp;
    }

    public static void main(String[] args) {

        int result1 = what(new int[]{1, 2, 3, 4, 5, 6, 7}); // <-- debug this line
        // 3 + 4 + 5 = 12
        System.out.println("expected true: " + result1);

        int result2 = what(new int[]{1, 2, 3, 4, 5, 6, 7}); // <-- debug this line
        // 3 + 4 + 5 = 12
        System.out.println("expected false: " + result2);
    }
}
