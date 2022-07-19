/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static boolean splitTo3(int[] arr) {

        // NOTE: leftSum, rightSum, limit1, limit2 initializations is set to their limits,
        // considering the 3rd and 4th examples.


        if (arr.length < 3)
            return false;

        int leftSum = 0;
        int midSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.length; i++)
            midSum += arr[i];


        int limit1 = -1, limit2 = arr.length - 1;

        // [0, limit1]   [limit1 + 1, limit2]   [limit2 + 1, arr.length-1]
        while (limit1 < limit2) {

            if (leftSum <= 0 && midSum == 0 && rightSum >= 0)
                return true;

            // The series is rising, if midSum is positive,
            // we would like to make it smaller to be closer to 0.
            // therefore, we add the next element to rightSum
            // and cut the last element from midSum.
            // Similarly, with the other case.
            if (midSum > 0) {
                rightSum += arr[limit2];
                midSum -= arr[limit2];
                limit2--;
            } else {
                leftSum += arr[limit1 + 1];
                midSum -= arr[limit1 + 1];
                limit1++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("expected true: " + splitTo3(new int[]{-8, -7, -5, -3, -2, 5, 8}));
        System.out.println("expected false: " + splitTo3(new int[]{-8, -7, -5, -3, -2, 7, 8}));
        System.out.println("expected true: " + splitTo3(new int[]{-8, -7, -5, -3, -2, -1, 1}));
        System.out.println("expected true: " + splitTo3(new int[]{-8, -7, 15, 23, 32, 37, 38}));
    }
}
