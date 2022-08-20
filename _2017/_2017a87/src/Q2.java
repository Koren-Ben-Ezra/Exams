/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static boolean isPythagorean(int[] arr) {

        for (int c = 2; c < arr.length; c++) {

            int low = 0, high = c - 1;

            while (low < high - 1) {

                if (arr[low] * arr[low] + arr[high] * arr[high] < arr[c] * arr[c])
                    low++;
                else
                    high--;
            }
            if (arr[low] * arr[low] + arr[high] * arr[high] == arr[c] * arr[c])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("expected true: " + isPythagorean(new int[]{1, 3, 4, 5, 6}));
        System.out.println("expected false: " + isPythagorean(new int[]{4, 5, 6, 10, 12}));
    }
}
