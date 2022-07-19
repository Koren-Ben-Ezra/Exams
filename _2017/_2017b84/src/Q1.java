/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int ways(int k, int n) {
        int stepsLeft = k, xPosition = n;

        if (stepsLeft == 0 && xPosition != 0)
            return 0;

        if (stepsLeft == 0)
            return 1;

        return ways(stepsLeft - 1, xPosition + 1) + ways(stepsLeft - 1, xPosition - 1);
    }

    public static void main(String[] args) {
        System.out.println("expected 1: " + ways(0, 0));
        System.out.println("expected 4: " + ways(4, 2));
        System.out.println("expected 0: " + ways(4, 3));
    }
}
