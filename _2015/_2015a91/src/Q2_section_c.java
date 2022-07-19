/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_section_c {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static boolean what(int[] a, int num) {

        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];


        for (int i = 0; i < a.length; i++) {

            int tempSum = sum;

            for (int j = a.length-1; j > i; j--) {

                if(tempSum == num)
                    return true;

                tempSum -= a[j];
            }
            sum -= a[i];
        }
        return false;
    }

    public static void main(String[] args) {

        boolean result1 = what(new int[]{1, 2, 3, 4, 5, 6, 7}, 12); // <-- debug this line
        // 3 + 4 + 5 = 12
        System.out.println("expected true: " + result1);

        boolean result2 = what(new int[]{1, 2, 3, 4, 5, 6, 7}, -1); // <-- debug this line
        // 3 + 4 + 5 = 12
        System.out.println("expected false: " + result2);
    }
}
