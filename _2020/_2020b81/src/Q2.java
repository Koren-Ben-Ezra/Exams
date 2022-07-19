/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static void minimumSubK(int[] arr, int k) {
        if (k > arr.length) return;

        int tempSum = 0;
        int savedIndex = 0, savedSum = 0;

        for (int i = 0; i < k; i++) {
            tempSum += arr[i];
        }
        savedSum = tempSum;

        for (int high = k; high < arr.length; high++) {

            int low = high - k + 1;
            tempSum -= arr[low - 1];
            tempSum += arr[high];

            if (tempSum < savedSum) {
                savedSum = tempSum;
                savedIndex = low;
            }
        }
        System.out.println("Minimum sum sub-array is (" + savedIndex + "," + (savedIndex + k - 1) + ")");
    }

    public static void main(String[] args) {

        int[] arr = {10, 4, 2, 5, 6, 3, 8, 1, 5, 9};
        System.out.println("expected: Minimum sum sub-array is (1,3)");
        System.out.print("received: ");
        minimumSubK(arr, 3);
        System.out.println("-----------------------------------------");

        System.out.println("expected: Minimum sum sub-array is (1,2)");
        System.out.print("received: ");
        minimumSubK(arr, 2);
    }
}
