/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int findMax(int[] arr) {

        int low = 0, high = arr.length - 1;
        int savedIndex = 0; // Initial value

        while (low < high) {

            int mid = (low + high) / 2;
            if (arr[mid] > arr[savedIndex])
                savedIndex = mid;

            if (arr[low] > arr[mid])
                high = mid - 1;

            else
                low = mid + 1;


        }
        return savedIndex;
    }

    public static void main(String[] args) {

        System.out.println("expected 1: " + findMax(new int[]{65, 70, -5, 3, 48, 49, 52}));
    }
}
