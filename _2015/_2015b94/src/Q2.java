/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int smallestSub(int[] a, int k) {
        int low = 0, high = 0;
        int tempSum = a[0];
        int savedLength = a.length + 1;

        if (tempSum > k)
            return 1;

        while (high < a.length - 1) {

            if (low < high && tempSum > k) {
                if ((high - low + 1) < savedLength)
                    savedLength = (high - low + 1);

                tempSum -= a[low++];

            } else
                tempSum += a[++high];
        }


        while (low <= high) {

            if (tempSum > k && (high - low + 1) < savedLength)
                savedLength = (high - low + 1);


            tempSum -= a[low++];
        }
        return savedLength;

    }


    public static void main(String[] args) {

        int[] arr = {1, 4, 13, 6, 0, 19};
        System.out.println("expected 3: " + smallestSub(arr, 22));
        System.out.println("expected 6: " + smallestSub(arr, 42));
        System.out.println("expected 7: " + smallestSub(arr, 43));
        System.out.println("expected 4: " + smallestSub(arr, 26));
        System.out.println("expected 1: " + smallestSub(arr, 2));
        System.out.println("expected 1: " + smallestSub(arr, 0));
    }
}
