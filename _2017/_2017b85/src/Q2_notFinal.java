/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_notFinal {

    /**
     * Does not work for every case.. but still :)
     * Solution for the test should be O(n).
     */
    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static void printClosest(int[] a, int[] b, int x) {

        int lowA = 0;
        int highA = a.length - 1;

        int lowB = 0;
        int highB = b.length - 1;

        int savedA = 0, savedB = 0, savedDiff = Integer.MAX_VALUE;

        while (lowA < highA || lowB < highB) {

            int midA = (lowA + highA) / 2;
            int midB = (lowB + highB) / 2;

            if (a[midA] + b[midB] == x) {
                System.out.println(a[midA] + " and " + a[midB]);
                return;
            }

            // Compares current difference to the shortest difference yet.
            // If the current is smaller, saves it.
            int currDiff = a[midA] + b[midB] - x;
            if (currDiff < 0) currDiff = -currDiff;

            if (currDiff < savedDiff) {
                savedA = a[midA];
                savedB = b[midB];
                savedDiff = currDiff;
            }



            // If the sum of both elements is smaller, cuts the upper half
            // of the array that gives smaller change to the current sum.
            // that means, we will find the next sum if we cut each one's upper half,
            // who will give the smaller change.
            if (a[midA] + b[midB] < x) {

                int intendedMidA = (midA + 1 + highA) / 2;
                int intendedMidB = (midB + 1 + highB) / 2;

                if ((lowA < highA && a[intendedMidA] < b[intendedMidB]) || lowB == highB)
                    lowA = intendedMidA;
                else
                    lowB = intendedMidB;
            }

            // If the sum of but elements is bigger, cuts the lower half
            // of the array that gives smaller change to the current sum.
            // Similarly to the first case.
            else {
                int intendedMidA = (lowA + midA) / 2;
                int intendedMidB = (lowB + midB) / 2;

                if ((lowB < highB && a[intendedMidA] < b[intendedMidB]) || lowA == highA)
                    highB = intendedMidB;
                else
                    highA = intendedMidA;
            }
        }

        // Last check to the current difference.
        int lastDiff = a[lowA] + b[lowB] - x;
        if (lastDiff < 0) lastDiff = -lastDiff;

        if (lastDiff < savedDiff)
            System.out.println(a[lowA] + " and " + b[lowB]);
        else
            System.out.println(savedA + " and " + savedB);
    }


    public static void main(String[] args) {

        int[] a = {0, 4, 8, 12, 12, 16};
        int[] b = {10,20,30,40,50,60,70};

        System.out.print("expected \"4 and 70\": ");
        printClosest(a, b, 73);

//
//        int[] a = {0, 4, 6, 11, 11};
//        int[] b = {10, 20, 30, 40};
//        System.out.print("expected \"0 and 10\": ");
//        printClosest(a, b, 11);
//
//        System.out.print("expected \"4 and 10\": ");
//        printClosest(a, b, 13);
//
//        System.out.print("expected \"10 and 6\" or \"0 and 20\" : ");
//        printClosest(a, b, 18);
//
//        System.out.print("expected \"11 and 40\": ");
//        printClosest(a, b, 70);
    }
}
