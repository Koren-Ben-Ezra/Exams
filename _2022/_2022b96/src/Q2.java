/**
 * Written by Koren Ben Ezra
 * In 2022c
 */
public class Q2 {
    public static int kAlmostSearch(int[] a, int num) {

        int low = 0, high = a.length - 1;

        // I used '<=' instead of '<' in 'low <= high'
        // So the last loop will check the last number when low == high.
        // Checking after the while loop if 'a[low] == num' is good as well.
        while (low <= high) {

            int mid = (low + high) / 2;

            // First check if the middle number is the requested number.
            if (a[mid] == num)
                return mid;

            while (mid > low && a[mid] == 0)
                // Time complexity: O(1).
                // O(k) but k is constant.
                mid -= 1;

            // Second check is necessary, we moved to another index, maybe thats our number.
            if (a[mid] == num)
                return mid;

            // The number in mid-index is not our number,
            // moves to the right or left half of the as requested.
            if (a[mid] < num)
                low = mid + 1;

            else
                high = mid - 1;

        }

        // num is not within the array.
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("expected 11: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 5));

        System.out.println("expected 5: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 4));

        System.out.println("expected 0: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 1));

        System.out.println("expected 12: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 6));

        System.out.println("expected 3: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 2));
    }
}
