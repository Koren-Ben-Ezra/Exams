/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static void printAllSum(int[] a, int sum) {
        printAllSum(a, sum, 0, "");
    }

    private static void printAllSum(int[] a, int sum, int index, String str) {

        if (index == a.length) {
            if (sum == 0)
                System.out.println(str);

            return;
        }

        printAllSum(a, sum - a[index], index + 1, str + "1");
        printAllSum(a, sum, index + 1, str + "0");
    }


    public static void main(String[] args) {

        int[] a = {1, 1, 3, 7};

        System.out.println("expected:\n" +
                "1001\n" +
                "0101\n" +
                "received:");
        printAllSum(a, 8);
        System.out.println();

        System.out.println("expected:\n" +
                "0011\n" +
                "received:");
        printAllSum(a, 10);
        System.out.println();

        System.out.println("expected:\n" +
                "1111\n" +
                "received:");

        printAllSum(a, 12);
        System.out.println();

        System.out.println("expected:\n" +
                "received:");
        printAllSum(a, 6);
        System.out.println();
    }

}
