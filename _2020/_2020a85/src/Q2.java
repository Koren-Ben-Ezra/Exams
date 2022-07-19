/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int strictlyIncreasing(int[] a) {
        /*
        for strictly increasing series within length 2,
        we can assemble 1 strictly increasing sub-series.

        for length 3, we can assemble 3  strictly increasing sub-series.
        for length 4, we can assemble 6  strictly increasing sub-series.
        for length 5, we can assemble 10 strictly increasing sub-series.

        we can see that there is direct connection between the values,
        let S(k) be the sum of the arithmetic sequence {1,2,3, .. , (k-1)}

            -->  S(k) = (k-1)*(1+(k-1)) / 2 = k*(k-1) / 2

         */

        int totalSubSeries = 0, tempLength = 1;

        for (int i = 1; i < a.length; i++) {

            if (a[i] > a[i - 1])
                tempLength++;
            else {
                totalSubSeries += (tempLength * (tempLength - 1)) / 2;
                tempLength = 1;
            }
        }
        totalSubSeries += (tempLength * (tempLength - 1)) / 2;
        return totalSubSeries;
    }

    public static void main(String[] args){

        System.out.println("expected 4:" + strictlyIncreasing(new int[]{1,2,4,4,5}));
        System.out.println("expected 1:" + strictlyIncreasing(new int[]{1,3,2}));
        System.out.println("expected 0:" + strictlyIncreasing(new int[]{5,4,3,2,1}));
    }


}
