/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // This question is partly recycled from 2014a85

    /*

    Min and max values can be found in O(log n) complexity,
    but finding sum has to be in O(n) due to comparing all relevant values to each other.

    Go to 2014a85 if you want to see the first part in O(log n).

     */


    // Time complexity: O(n)
    // Space complexity: O(1)
    public static boolean findSum(int[] a, int sum) {
        int low = 0, high = a.length - 1; // default value.

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                low = i;
                high = i - 1;
                break;
            }
        }

        while (low != high) {

            int tempSum = a[low] + a[high];

            if (tempSum == sum)
                return true;

            else if (tempSum > sum)
                high--;
            else
                low++;

            if (low > a.length - 1)
                low = 0;
            if (high < 0)
                high = a.length - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {65, 70, -5, 3, 48, 49, 52};
        System.out.println("expected true: " + findSum(arr, 44));
        System.out.println("expected false: " + findSum(arr, 45));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && !findSum(arr, arr[i] + arr[j]))
                    System.out.println("something is wrong with index " + i + " and " + j + ".");
            }
        }
    }
}
