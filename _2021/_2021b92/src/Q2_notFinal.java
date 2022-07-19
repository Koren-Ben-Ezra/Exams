/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_notFinal {
    // SOLUTION IS NOT FINAL !
//    public static int longestSequence(int[] a, int k) {
//
//        int numOfZeros = 0;
//        for (int i = 0; i < a.length; i++)
//            if (a[i] == 0)
//                numOfZeros++;
//
//        int savedLow = 0, savedHigh = a.length - 1;
//        int low = 0, high = a.length - 1;
//        int leftLength = 0, rightLength = 0; // length of one's
//
//        while (numOfZeros > k) {
//            if (a[low] == 0 && a[high] == 0) {
//                numOfZeros--;
//                if (leftLength < rightLength)
//                    savedLow = ++low;
//                else
//                    savedHigh = --high;
//
//                rightLength = 0;
//                leftLength = 0;
//
//            } else if (a[low] == 0) {
//                rightLength++;
//                high--;
//            } else {
//                leftLength++;
//                low++;
//            }
//        }
//        return savedHigh - savedLow + 1;
//    }
}
