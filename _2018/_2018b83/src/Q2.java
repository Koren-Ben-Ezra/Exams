/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int findSingle(int[] a) {
        if (a.length == 1)
            return a[0];

        int low = 0, high = a.length - 1;
        while (low < high) {

            int mid = (low + high) / 2;

            // Checks if the current element is the single one.
            boolean isSingle = a[mid] != a[mid + 1] && a[mid] != a[mid - 1];

            if (isSingle)
                return a[mid];

            // Sets leftInPair to be the left element between the two equal elements.
            int leftInPair = (a[mid] == a[mid + 1]) ? mid : mid - 1;

            // If all elements from index 0 to index mid are all pairs,
            // then leftInPair is even,
            // otherwise leftInPair is odd and the single element is somewhere in index 0 to index mid.
            if (leftInPair % 2 == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        // We assume that there is a single element for sure,
        // therefore it is the last one.
        return a[low];
    }

    public static void main(String[] args) {

        System.out.println("expected 12: " + findSingle(new int[]{6, 6, 18, 18, -4, -4, 12, 9, 9}));
        System.out.println("expected 4: " + findSingle(new int[]{8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4}));
        System.out.println("expected 5: " + findSingle(new int[]{5}));
    }
}