/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_section_c {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static int what(int[] a) {

        int sum = 0, savedLength = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];


        for (int i = 0; i < a.length; i++) {

            int tempSum = sum;

            for (int j = a.length - 1; j > i; j--) {

                if (tempSum % 2 == 1 && (j - i + 1) > savedLength)
                    savedLength = (j - i + 1);

                tempSum -= a[j];
            }
            sum -= a[i];
        }
        return savedLength;
    }

    public static void main(String[] args) {

        int result1 = what(new int[]{1, 2, 3, 4, 5, 6, 7}); // <-- debug this line
        System.out.println("expected ??: " + result1);
        // 1 + 2 + 3 + 4 + 5 + 6 = 21
        // or
        // 2 + 3 + 4 + 5 + 6 + 7 = 27
        // they are both in length 6 and the sum is an odd number.
        // but 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28 ( <-- even sum)
    }

}
