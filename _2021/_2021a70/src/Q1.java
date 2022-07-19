/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int findMaxPrice(int[] prices, int n) {
        return findMaxPrice(prices, n, 1);
    }

    private static int findMaxPrice(int[] prices, int lengthLeft, int index) {
        if (index > lengthLeft || lengthLeft == 0)
            return 0;

        return max(prices[index] + findMaxPrice(prices, lengthLeft - index, index),
                findMaxPrice(prices, lengthLeft, index + 1));
    }

    private static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }

    public static void main(String[] args) {
        int[] prices = {0, 1, 3, 10, 9, 10, 17, 17, 20};
        System.out.println("expected 23: " + findMaxPrice(prices, 8));

        prices[1] = 4;
        System.out.println("expected 32: " + findMaxPrice(prices, 8));
    }
}
