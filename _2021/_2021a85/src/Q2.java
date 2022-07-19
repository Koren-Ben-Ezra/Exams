/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static boolean findAverage(int[] arr, double x) {
        int low = 0, high = arr.length - 1;
        double tempsum = 0;

        for (int i = 0; i < arr.length; i++) {
            tempsum += arr[i];
        }


        while (low <= high) {

            double tempAve = tempsum / (high - low + 1);

            if (tempAve == x)
                return true;

            else if (tempAve > x)
                tempsum -= arr[high--];
            else
                tempsum -= arr[low++];
        }
        return false;
    }


    public static void main(String[] args) {

        int[] arr = {2, 3, 8, 14, 15, 35};
        System.out.println("expected true: " + findAverage(arr, 8));
        System.out.println("expected true: " + findAverage(arr, 2.5));
        System.out.println("expected true: " + findAverage(arr, 10));
        System.out.println("expected false: " + findAverage(arr, 8.5));
    }
}
