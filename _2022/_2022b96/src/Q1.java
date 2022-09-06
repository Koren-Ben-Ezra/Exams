/**
 * Written by Koren Ben Ezra
 * In 2022c
 */
public class Q1 {
    public static int calc(int num, int result, int maxOp) {
        return calc(num, result, (double) num, maxOp, String.valueOf(num));

    }

    public static int calc(int num, int result, double tempResult, int maxOp, String str) {

        if (maxOp < 0)
            return 0;

        if (tempResult == result) {
            System.out.println(str + " = " + result);
            return 1;
        }
        return calc(num, result, tempResult + num, maxOp - 1, (str + " + " + num)) +
                calc(num, result, tempResult - num, maxOp - 1, (str + " - " + num)) +
                calc(num, result, tempResult * num, maxOp - 1, (str + " * " + num)) +
                calc(num, result, tempResult / num, maxOp - 1, (str + " / " + num));

    }

    public static void main(String[] args) {
        System.out.println(calc(3, 36, 5));
    }

}
