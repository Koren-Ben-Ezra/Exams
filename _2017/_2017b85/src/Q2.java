public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static void printClosest(int[] a, int[] b, int x) {

        int lowA = 0, highB = b.length - 1;
        int savedDiff = Integer.MAX_VALUE;
        int savedA = lowA, savedB = highB;

        while (lowA <= highB) {

            int currDiff = a[lowA] + b[highB] - x;
            if (currDiff < 0) currDiff = -currDiff;

            if (currDiff < savedDiff) {
                savedDiff = currDiff;
                savedA = lowA;
                savedB = highB;
            }

            if (a[lowA] + b[highB] < x)
                lowA++;
            else
                highB--;
        }

        int lastDiff = a[lowA] + b[highB] - x;
        if (lastDiff < 0) lastDiff = -lastDiff;

        if (lastDiff < savedDiff)
            System.out.println(a[lowA] + " and " + b[highB]);
        else
            System.out.println(a[savedA] + " and " + b[savedB]);


    }

    public static void main(String[] args) {

        int[] a = {0, 4, 6, 11, 11};
        int[] b = {10, 20, 30, 40};
        System.out.print("expected \"0 and 10\": ");
        printClosest(a, b, 11);

        System.out.print("expected \"4 and 10\": ");
        printClosest(a, b, 13);

        System.out.print("expected \"10 and 6\" or \"0 and 20\" : ");
        printClosest(a, b, 18);

        System.out.print("expected \"11 and 40\": ");
        printClosest(a, b, 70);
    }
}
