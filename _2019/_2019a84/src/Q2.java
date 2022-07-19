/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int average(int[] arr){

        int savedDiff = Integer.MIN_VALUE, savedIndex = 0;

        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length-1; i++) {

            leftSum += arr[i];
            rightSum -= arr[i];

            // (i+1) is the amount of elements within left group.
            // ( arr.length - (i+1)) is the amount of elements within right group.
            int leftAve = leftSum / (i+1);
            int rightAve = rightSum / (arr.length-(i+1));

            int currDiff = rightAve - leftAve;
            if(currDiff < 0) currDiff = -currDiff;

            if(currDiff > savedDiff){
                savedDiff = currDiff;
                savedIndex = i;
            }
        }

        return savedIndex;
    }

    public static void main(String[] args){

        System.out.println("expected 2: " + average(new int[]{5, 7, -2, 10}));
    }
}
