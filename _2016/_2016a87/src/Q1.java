/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int minDiff(int[] arr) {
        return minDiff(arr, 0, 0, 0);
    }

    private static int minDiff(int[] arr, int index, int sum1, int sum2) {

        if (index == arr.length)
            return (sum1 - sum2 > 0) ? sum1 - sum2 : sum2 - sum1;

        return min(minDiff(arr, index + 1, sum1 + arr[index], sum2),
                minDiff(arr, index + 1, sum1, sum2 + arr[index]));
    }

    private static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }

    public static void main(String[] args){

        System.out.println("expected 1: " + minDiff(new int[]{5,2,4}));
        System.out.println("expected 0: " + minDiff(new int[]{1,2,3,4}));
        System.out.println("expected 1: " + minDiff(new int[]{1,2,7,17,6}));
    }
}
