/**
 * Written by Amit Nahmias
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)

    public static int longestSequence(int[] a, int k) {
        if (a == null || a.length == 0)
            return 0;
        int low = 0, high = 0, max = 0, len = 0, zeros = 0;
        while (low <= high && high <= a.length) {
            if (high == a.length) {
                if (k == zeros)
                    max = Math.max(max, len);
                break;
            } else if (zeros <= k) {
                if (a[high] == 0)
                    zeros++;
                if (len > max)
                    max = len;
                len++;
                high++;
            } else {
                if (a[low] == 0)
                    zeros--;
                len--;
                low++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};
        int result = longestSequence(arr, 0);
        System.out.println("expected 4: " + result);
        System.out.println("expected 7: " + longestSequence(arr, 1));
        System.out.println("expected 10: " + longestSequence(arr, 2));
        System.out.println("expected 11: " + longestSequence(arr, 3));
        System.out.println("expected 12: " + longestSequence(arr, 4));
    }
}

