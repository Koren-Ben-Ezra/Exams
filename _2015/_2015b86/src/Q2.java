/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static void printPairs(int[] a, int k) {

        int low = 0, high = 1;

        while (low < a.length) {

            int diffOfPair = a[high] - a[low];
            if (diffOfPair == k)
                System.out.println("Pair Found:(" + a[low] + "," + a[high] + ")");


            if (high == a.length - 1)
                low++;
            else if (diffOfPair < k || low + 1 == high)
                high++;
            else
                low++;
        }
    }

    public static void main(String[] args) {

        int[] a = {-7, -3, 0, 1, 3, 5, 12, 14, 17, 19, 25, 30};

        System.out.println("-- -- -- -- -- -- --");
        printPairs(a, 2);  // expected 4 pairs printed
        System.out.println("-- -- -- -- -- -- --");
        printPairs(a, 6);  // expected 2 pairs printed
        System.out.println("-- -- -- -- -- -- --");
        printPairs(a, 23); // expected 0 pairs printed
        System.out.println("-- -- -- -- -- -- --");
    }
}
