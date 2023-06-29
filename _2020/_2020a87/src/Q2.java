/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static void printTriplets(int[] a, int num){

        for (int i = 0; i < a.length-2; i++) {
            int low = i+1, high = a.length-1;

            while (low < high) {

                int currTriplet = a[i] * a[low] * a[high];
                if (currTriplet == num){
                    System.out.println(a[i] + "\t" + a[low] + "\t" + a[high]);
                    break;
                }
                if(currTriplet > num)
                    high--;
                else
                    low++;
            }
        }
    }

    public static void main(String[] args){

        int[] a = {1,2,3,4,5,6,7,8,9};

        System.out.println(
                "expected:\n" +
                        "1   5   8\n" +
                        "2   4   5\n" +
                        "received:");
        printTriplets(a,40);

        int[] b = {1,3,6,8};

        System.out.println("----------------");

        System.out.println(
                "expected:\n" +
                        "received:");
        printTriplets(b,40);
    }
}
