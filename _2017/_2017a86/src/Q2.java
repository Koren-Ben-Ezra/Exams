/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static int countTriplets(int[] arr, int num) {
        int amountOfTriplets = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int low = i + 1, high = arr.length - 1;

            while (low < high) {

                if (arr[i] + arr[low] + arr[high] < num) {
                    amountOfTriplets += high - low;
                    low++;
                } else
                    high--;
            }
        }

        return amountOfTriplets;
    }

    public static void main(String[] args) {

        System.out.println("expected 2: " + countTriplets(new int[]{-2, 0, 1, 3}, 2));
        System.out.println("expected 4: " + countTriplets(new int[]{1, 3, 4, 5, 7}, 12));
    }
}
