/**
 * Written by Koren Ben Ezra
 * In 2022c
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int findTriplet(int[] arr) {

        int[] twoLowestNeg = {0, 0};
        // twoLowestNeg = [_1stLowest, _2ndLowest]

        int[] savedValues = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        // savedValues = [_1stBiggest, _2ndBiggest, _3rdBiggest]

        // Goes over all the array once, and saves the 3 highest numbers and the 2 lowest negative numbers.
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > savedValues[0]) {
                savedValues[2] = savedValues[1];
                savedValues[1] = savedValues[0];
                savedValues[0] = arr[i];

            } else if (arr[i] > savedValues[1]) {
                savedValues[2] = savedValues[1];
                savedValues[1] = arr[i];

            } else if (arr[i] > savedValues[2]) {
                savedValues[2] = arr[i];
            }

            if (arr[i] < twoLowestNeg[0]) {
                twoLowestNeg[1] = twoLowestNeg[0];
                twoLowestNeg[0] = arr[i];

            } else if (arr[i] < twoLowestNeg[1]) {
                twoLowestNeg[1] = arr[i];
            }
        }

        // Compares between the two intended multiplies, returns the highest one.
        int mul1 = savedValues[0] * savedValues[1] * savedValues[2];
        int mul2 = savedValues[0] * twoLowestNeg[0] * twoLowestNeg[1];
        // if there is only one negative number, or not even one, mul2 = 0.

        if (mul1 > mul2) {
            System.out.println(savedValues[0] + " " + savedValues[1] + " " + savedValues[2]);
            return mul1;
        }

        System.out.println(savedValues[0] + " " + twoLowestNeg[0] + " " + twoLowestNeg[1]);
        return mul2;
    }



    public static void main(String[] args) {

        int[] arr = {-4, 1, -8, 9, 6};
        System.out.println("expected \"-4, -8, 9\" and 288: " + findTriplet(arr));
    }
}
