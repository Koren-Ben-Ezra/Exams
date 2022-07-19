/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int meetingPoint(int[] a, int[] b) {

        if (a[a.length-1] > b[b.length-1] || b[0] > a[0] )
            return -1;

        int low = 0, high;

        boolean aIsShorter = a.length < b.length;
        if (aIsShorter)
            high = a.length - 1;
        else
            high = b.length - 1;


        while (low < high){

            int mid = (low + high) / 2;

            if(a[mid] <= b[mid]){
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return low;

    }

    public static void main(String[] args){

        int[] a = {19,19,16,15,15,15,15,13,5};
        int[] b = {0,12,13,14,14,15,15,19,25,30,35};
        System.out.println("expected 5: " + meetingPoint(a,b));

        int[] c = {0,0,-2};
        System.out.println("expected 0: " + meetingPoint(c,b));

        int[] d = {36,36,36,36,36,36,36,36,36,36,35};
        System.out.println("expected 10: " + meetingPoint(d,b));
    }
}
