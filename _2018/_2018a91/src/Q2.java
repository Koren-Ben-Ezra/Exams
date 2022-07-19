import java.util.Arrays;
/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(n)
    // Space complexity: O(1)

    // Time complexity is actually O(n*k), but k is constant.
    public static void sortmod(int[] a, int k){

        int newIndex = 0;

        for(int mod = 0; mod < k; mod++){

            for (int i = newIndex; i < a.length ; i++) {

                if(a[i] % k == mod){

                    // Swaps between both elements.
                    int tempVal = a[newIndex];
                    a[newIndex] = a[i];
                    a[i] = tempVal;

                    newIndex++;
                }
            }
        }
    }


    public static void main(String[] args){

        int[] a = {35,17,13,252,4,128,7,3,81};
        int[] expected  = {81,252,13,3,4,35,17,7,128};

        sortmod(a,10);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("received: " + Arrays.toString(a));
    }
}
