/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int passingCars(int[] a) {

        int numOfZeroCounted = 0;
        int sumOfPassingCars = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1)
                sumOfPassingCars += numOfZeroCounted;
            else
                numOfZeroCounted++;
        }
        return sumOfPassingCars;
    }


    public static void main(String[] args) {
        System.out.println("expected 5: " + passingCars(new int[]{0, 1, 0, 1, 1}));
    }
}
