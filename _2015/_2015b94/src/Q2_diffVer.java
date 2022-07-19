/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_diffVer {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int smallestSub(int[] a, int k) {

        int savedLength = a.length + 1;

        int currSum = a[0];
        int low = 0, high = 0;

        while (high < a.length - 1 || low < a.length) {

            int currLength = high - low + 1;
            if (currSum > k && currLength < savedLength)
                savedLength = currLength;

            if (currSum > k)
                currSum -= a[low++];

            else if (high == a.length - 1)
                // If reached here, then there is no chance for shorter sub-array than the one that have found.
                return savedLength;

            else
                currSum += a[++high];
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