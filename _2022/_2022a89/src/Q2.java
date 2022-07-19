/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int longestSubarray (int[] a){

        int savedIndex = 0, savedLength =  1;
        int tempIndex = 0, tempLength = 1;

        for (int i = 1; i < a.length; i++) {

            boolean isValid = a[i] * a[i-1] < 0;

            if(isValid)
                tempLength++;
            else{

                if(tempLength > savedLength){
                    savedLength = tempLength;
                    savedIndex = tempIndex;
                }

                tempLength = 1;
                tempIndex = i;
            }
        }
        System.out.println("Starting index = " + savedIndex + " Ending index = " + (savedIndex + savedLength - 1));
        return savedLength;
    }

    public static void main(String[] args){

        System.out.println("expected 3: " + longestSubarray(new int[]{-1,1,-1,-5,2,2}));
        System.out.println("expected 3: " + longestSubarray(new int[]{3,3,2,-7,2,1,1,-2,-2}));
        System.out.println("expected 1: " + longestSubarray(new int[]{1,2,3,4,5,4}));
        System.out.println("expected 4: " + longestSubarray(new int[]{1,-2,3,-4,-5,4,2,4,6,2}));
    }
}
