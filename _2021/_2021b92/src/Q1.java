/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int printExpr(int[] arr, int num) {
        return printExpr(arr, num, 0, "");
    }

    private static int printExpr(int[] arr, int num, int index, String str) {

        if (num == 0) {
            System.out.println(str);
            return 1;
        }
        if (index == arr.length)
            return 0;

        return printExpr(arr, num - arr[index], index + 1, str + "+" + arr[index]) +
                printExpr(arr, num + arr[index], index + 1, str + "-" + arr[index]) +
                printExpr(arr, num, index + 1, str);
    }

    public static void main(String[] args) {
        System.out.println("expected 5: " + printExpr(new int[]{1, 3, 6, 2}, 4));
        System.out.println("expected 4: " + printExpr(new int[]{1, 3, 6, 2}, 3));
    }
}
