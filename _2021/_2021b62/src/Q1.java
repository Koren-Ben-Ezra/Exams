/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static boolean equalSplit(int[] arr) {
        if ((arr.length % 2) == 1)
            return false;

        return equalSplit(arr, 0, 0,  0, 0);
    }

    private static boolean equalSplit(int[] arr, int index, int sum1, int sum2, int elementsInSum1) {

        if (index == arr.length) {
            if (elementsInSum1 == arr.length / 2 && sum1 == sum2)
                return true;

            return false;
        }

        return equalSplit(arr, index + 1, sum1 + arr[index], sum2, elementsInSum1 + 1) ||
                equalSplit(arr, index + 1, sum1, sum2 + arr[index], elementsInSum1);

    }


    public static void main(String[] args) {

        System.out.println("expected true: " + equalSplit(new int[]{-3, 5, 12, 14, -9, 13}));
        System.out.println("expected false: " + equalSplit(new int[]{-3, 5, -12, 14, -9, 13}));
        System.out.println("expected false: " + equalSplit(new int[]{-3, 5, -12, 14, -9}));
    }


}


