/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int oneFiveSeven(int n) {

        if (n == 0)
            return 0;

        if (n < 0)
            return Integer.MAX_VALUE;

        // NOTE: Integer.MAX_VALUE + 1 == Integer.MIN_VALUE
        // But the addition of 1 is outside in min() func.
        // so its okay.
        return 1 + min(oneFiveSeven(n - 1), oneFiveSeven(n - 5), oneFiveSeven(n - 7));
    }

    private static int min(int a, int b, int c) {

        if (a < b)
            b = a;
        if (b < c)
            c = b;
        return c;
    }

    public static void main(String[] args) {
        System.out.println("expected 2: " + oneFiveSeven(10));
        System.out.println("expected 1: " + oneFiveSeven(5));
        System.out.println("expected 2: " + oneFiveSeven(6));
    }
}
