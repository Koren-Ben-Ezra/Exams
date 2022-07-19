/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_easier {


    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int getMedian(int[] a, int[] b) {

        int n = a.length + b.length;
        int[] unionArr = new int[n];

        int aIndex = 0, bIndex = 0;
        for (int i = 0; i < n; i++) {

            if (bIndex == b.length)
                unionArr[i] = a[aIndex++];

            else if (aIndex < a.length && a[aIndex] < b[bIndex])
                unionArr[i] = a[aIndex++];
            else
                unionArr[i] = b[bIndex++];
        }

        if (n % 2 == 1)
            return unionArr[n / 2];

        int mid = unionArr[n / 2];
        int beforeMid = unionArr[(n / 2) - 1];
        return (mid + beforeMid) / 2;
    }

    public static void main(String[] args) {

        System.out.println("expected 16: " + getMedian(new int[]{1, 12, 15, 26, 38}, new int[]{12, 13, 18, 30, 46}));
        System.out.println("expected 40: " + getMedian(new int[]{1, 12, 15, 26, 38}, new int[]{40, 50, 60, 70, 80, 90}));
        System.out.println("expected 40: " + getMedian(new int[]{10, 20, 30, 60, 70}, new int[]{40, 50}));
        System.out.println("expected 30: " + getMedian(new int[]{10, 20, 30, 60}, new int[]{10, 40, 50}));


    }
}
