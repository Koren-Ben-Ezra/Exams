/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static boolean split3(int[] arr) {
        return split3(arr,0,0,0,0);
    }

    private static boolean split3(int[] arr, int index, int sum1, int sum2, int sum3) {
        if (index == arr.length) {
            if (sum1 == sum2 && sum1 == sum3)
                return true;
            return false;
        }

        return split3(arr, index + 1, sum1 + arr[index], sum2, sum3) ||
                split3(arr, index + 1, sum1, sum2 + arr[index], sum3) ||
                split3(arr, index + 1, sum1, sum2, sum3 + arr[index]);
    }



    public static void main(String[] args) {
        System.out.println("expected true: " + split3(new int[]{8,4,7,1,2,3,5}));
        System.out.println("expected false: " + split3(new int[]{4,7,1,2,3,5}));
    }

}
