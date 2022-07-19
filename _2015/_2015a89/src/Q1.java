/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static boolean splitEqualMult(int[] a) {
        return splitEqualMult(a, 0, 1, 1);
    }

    private static boolean splitEqualMult(int[] a, int index, int multiGrp1, int multiGrp2) {
        if (index == a.length)
            return multiGrp1 == multiGrp2;

        return splitEqualMult(a, index + 1, multiGrp1 * a[index], multiGrp2) ||
                splitEqualMult(a, index + 1, multiGrp1, multiGrp2 * a[index]);
    }

    public static void main(String[] arg) {

        System.out.println("expected true: " + splitEqualMult(new int[]{2, 15, 3, 4, 2, 5}));
        System.out.println("expected false: " + splitEqualMult(new int[]{2, 4, 6, 2, 3, 4}));
    }
}
