/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static boolean isSum(Range[] a, int x) {

        int low = 0, high = a.length - 1;

        while (low < high) {

            int currSmallestSum = a[low].getSmallest() + a[high].getSmallest();
            int currLargestSum = a[low].getLargest() + a[high].getLargest();

            boolean isSum = (x >= currSmallestSum && x <= currLargestSum);
            if (isSum)
                return true;

            if (x < currSmallestSum)
                high--;
            else
                low++;
        }

        // for the last element in Range.

        // if the last element is a single number.
        if (a[low].getSmallest() == a[low].getLargest())
            return false;

        // [a, a+1, a+2, ... , k-2, k-1, k]
        int lastSmallestSum = a[low].getSmallest() + a[low].getSmallest() + 1;
        int lastLargestSum = a[low].getLargest() + a[low].getLargest() - 1;

        return (x >= lastSmallestSum && x <= lastLargestSum);
    }


    public static void main(String[] args) {

        Range[] rangeArr = {
                new Range(3, 5),
                new Range(12, 12),
                new Range(19, 20),
                new Range(100, 104)
        };

        System.out.println("expected true: " + isSum(rangeArr, 22));
        System.out.println("expected true: " + isSum(rangeArr, 113));
        System.out.println("expected true: " + isSum(rangeArr, 202));
        System.out.println("expected false: " + isSum(rangeArr, 38));
        System.out.println("expected false: " + isSum(rangeArr, 53));
    }
}
