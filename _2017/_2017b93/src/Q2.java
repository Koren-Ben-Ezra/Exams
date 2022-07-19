/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // space complexity: O(1)
    public static int findNum(Range[] rangeA, int num) {
        int low = 0, high = rangeA.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;
            int biggerNum = rangeA[mid].getCenter() + rangeA[mid].get_radius();

            if (num > biggerNum)
                low = mid + 1;
            else
                high = mid - 1;
        }

        int a = rangeA[low].getCenter() - rangeA[low].get_radius();
        int b = rangeA[low].getCenter() + rangeA[low].get_radius();

        if (num >= a && num <= b)
            return low;

        return -1;
    }


    public static void main(String[] args){

        Range[] rangeA = {new Range(4,1), new Range(12,0), new Range(20,1), new Range(102,2)};

        System.out.println("expected 0: " + findNum(rangeA,5));
        System.out.println("expected 3: " + findNum(rangeA,101));
        System.out.println("expected -1: " + findNum(rangeA,15));
        System.out.println("expected -1: " + findNum(rangeA,105));
        System.out.println("expected 0: " + findNum(rangeA,3));
        System.out.println("expected 3: " + findNum(rangeA,104));


    }

}
