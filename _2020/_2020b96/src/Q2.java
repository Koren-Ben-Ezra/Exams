/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int minimalPositive(Range[] rangeA) {
        int low = 0, high = rangeA.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;

            if (rangeA[mid].getSmall() < 0 && rangeA[mid].getBig() > 0)
                return 1;

            else if (rangeA[mid].getSmall() > 0)
                high = mid-1;
            else
                low = mid+1;
        }

        if(rangeA[low].getSmall() > 0)
            return rangeA[low].getSmall();

        else if(rangeA[low].getBig() > 0)
            return rangeA[low].getBig();

        return -1;
    }


    public static void main(String[] args) {
        Range[] rangeA = {new Range(-7, -3),
                new Range(-1, -1),
                new Range(4, 6),
                new Range(20, 22)};

        int minimalPositiveNum = minimalPositive(rangeA);
        System.out.println("expected 4: " + minimalPositiveNum);


        Range[] rangeB = {new Range(3, 5),
                new Range(12, 12),
                new Range(19, 20),
                new Range(100, 104)};

        minimalPositiveNum = minimalPositive(rangeB);
        System.out.println("expected 3: " + minimalPositiveNum);


        Range[] rangeC = {new Range(-100, -50),
                new Range(-52, -30),
                new Range(-20, -10),
                new Range(-5, -1)};

        minimalPositiveNum = minimalPositive(rangeC);
        System.out.println("expected -1: " + minimalPositiveNum);


        Range[] rangeD = {new Range(-100, -50),
                new Range(-52, -30),
                new Range(-20, -10),
                new Range(-5, 1)};

        minimalPositiveNum = minimalPositive(rangeD);
        System.out.println("expected 1: " + minimalPositiveNum);
    }
}
