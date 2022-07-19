/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int findMissingIndex(int[] a) {

        int low = 0, high = a.length - 1;
        int d = a[1] - a[0];

        // if the second element is not part of the series.
        // in this case, d is greater than ( a[2] - a[1] ) for sure,
        // therefore, returns the index 1;
        // example: (1,3,4)  or  (1,2,4)
        if (d > a[2] - a[1]){
            return 1;
        }

        while (low < high){

            int mid = (low + high) / 2;
            int supposedToBe = a[0] + mid * d;

            if(supposedToBe != a[mid] && supposedToBe - d == a[mid-1])
                return mid;

            if(supposedToBe != a[mid] )
                high = mid - 1;
            else
                low = mid + 1;
        }
        return a.length;
    }

    public static void main(String[] args){

        int[] arr = {22,24,26,32,34,36,38,40};
        int missingIndex = findMissingIndex(arr);
        System.out.println("is 3: " + missingIndex);

        arr = new int[]{22, 26, 28};
        missingIndex = findMissingIndex(arr);
        System.out.println("is 1: " + missingIndex);

        arr = new int[]{2,4,6,8,10};
        missingIndex = findMissingIndex(arr);
        System.out.println("is 5: " + missingIndex);
    }
}
