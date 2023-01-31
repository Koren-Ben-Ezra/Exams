/**
 * Written by Tomer (aka CASIO15)
 * In 2023a
 */
public class Q2_Tomer {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int findNum(Range[] r, int n) {
        int l = 0, h = r.length - 1;

        // Regular binary search.
        while (l <= h) {
            // Get mid.
            int m = (l + h) / 2;
            // Get the range of r[m].
            int ml = r[m].getCenter() - r[m].get_radius();
            int mh = r[m].getCenter() + r[m].get_radius();

            // If n is in range, return m;
            if (ml <= n && n <= mh)
                return m;
            // If n is greater than the largest num in the range, update low.
            if (n > mh)
                l = m + 1;
                // Else update high.
            else
                h = m - 1;
        }

        // Not found, return -1.
        return -1;
    }

    public static void main(String[] args) {

        Range[] rangeA = {new Range(4, 1), new Range(12, 0), new Range(20, 1), new Range(102, 2)};

        System.out.println("expected 0: " + findNum(rangeA, 5));
        System.out.println("expected 3: " + findNum(rangeA, 101));
        System.out.println("expected -1: " + findNum(rangeA, 15));
        System.out.println("expected -1: " + findNum(rangeA, 105));
        System.out.println("expected 0: " + findNum(rangeA, 3));
        System.out.println("expected 3: " + findNum(rangeA, 104));


    }

}
