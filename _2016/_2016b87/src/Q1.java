/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int count(int sum) {
        if (sum < 0)
            return 0;

        if (sum == 0)
            return 1;

        return count(sum, 1);
    }


    private static int count(int sum, int currNum) {
        // NOTE: The "if" statements order is important!

        if (sum == 0)
            return 1;

        if (sum < 0 || currNum > sum)
            return 0;

        return count(sum - currNum, currNum + 1) + count(sum, currNum + 1);
    }

    public static void main(String[] args) {

        System.out.println("expected 5: " + count(7));
        System.out.println("expected 1: " + count(0));
        System.out.println("expected 0: " + count(-1));
    }
}
