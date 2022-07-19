/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int howManyNegativeNumbers(int[][] arr) {
        int negSum = 0, high = arr[0].length - 1;

        for (int row = 0; row < arr.length; row++) {

            while (high >= 0 && arr[row][high] >= 0)
                high--;

            negSum += high + 1;
        }
        return negSum;
    }


    public static void main(String[] args) {

        int[][] arr = {
                {-99, -72, -64, -55, -28, -10, -5},
                {-72, -53, -46, -38, 11, 13, 22},
                {-63, -48, -27, -12, 14, 16, 23},
                {-44, -29, -10, 0, 18, 20, 28},
                {0, 12, 14, 20, 28, 30, 35}
        };
        System.out.println("expected 18: " + howManyNegativeNumbers(arr));
    }
}
