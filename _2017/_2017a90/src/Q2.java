/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int findSmallest(int[] arr) {
        int smallestNum = 1;

        for (int i = 0; i < arr.length; i++) {

            if(smallestNum < arr[i])
                break;

            // adds the current element to smallestNum.
            smallestNum += arr[i];
            }
        return smallestNum;
    }


    public static void main(String[] args){

        System.out.println("expected 4: " + findSmallest(new int[]{1,2,6,10,11,15}));
        System.out.println("expected 5: " + findSmallest(new int[]{1,1,1,1}));
        System.out.println("expected 10: " + findSmallest(new int[]{1,1,3,4}));
        System.out.println("expected 2: " + findSmallest(new int[]{1,3,5,10,20,40}));
        System.out.println("expected 8: " + findSmallest(new int[]{1,2,4,10,11,15}));
    }
}
