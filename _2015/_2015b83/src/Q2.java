import java.util.Arrays;
/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)

    public static void replace(int[] a) {

        int tempMax = 0;

        int high = a.length - 1;
        while (high >= 0) {

            int tempVal = a[high];
            a[high] = tempMax;

            if (tempVal > tempMax)
                tempMax = tempVal;

            high--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {6, 7, 4, 3, 5, 2};
        int[] expected = {7, 5, 5, 5, 2, 0};
        replace(arr);

        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("received: " + Arrays.toString(arr));
    }
}
