/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)

    /**
     * Answer to 2.a
     */
    public static boolean sum2(int[] arr, int num) {

        if (arr.length < 2)
            return false;

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int currSum = arr[low] + arr[high];

            if (currSum == num)
                return true;

            if (currSum < num)
                low++;
            else
                high--;
        }
        return false;
    }

// -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    // Time complexity: O(n^2)
    // Space complexity: O(1)

    /**
     * Answer to 2.b
     */
    public static boolean sum3(int[] arr, int num) {

        if (arr.length < 3)
            return false;


        for (int i = 0; i < arr.length - 2; i++) {

            int low = i + 1, high = arr.length - 1;
            while (low < high) {

                int currSum = arr[i] + arr[low] + arr[high];
                if (currSum == num)
                    return true;

                if (currSum < num)
                    low++;
                else
                    high--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {-2, 3, 5, 7, 12};
        System.out.println("expected true: " + sum2(arr, 17));
        System.out.println("expected false: " + sum2(arr, 16));
        System.out.println("expected true: " + sum3(arr, 17));
        System.out.println("expected false: " + sum3(arr, 16));
    }


}
