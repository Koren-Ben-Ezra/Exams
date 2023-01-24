/**
 * Written by Tomer (aka CASIO15)
 * In 2023a
 */
public class Q2_tomer {
    // Time complexity: O(n)
    // Space complexity: O(1)
    /*
    Passing through the array only once,
    the inner while loop used only to minimize the "window" [l,r].
     */
    public static int smallestSub(int[] a, int k) {
        int l = 0, r = 1, sum = a[l];

        while (r < a.length) {
            sum += a[r++];
            while (sum > k) {
                sum -= a[l++];
            }
        }
        return r - l + 1;
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