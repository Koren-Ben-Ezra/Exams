/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static void findFactors(int n){
        int low = 0, high = n;

        while(low < high){

            int mid = (low + high) / 2;

            if(isHighFactorInRange(n,low,mid))
                high = mid;
            else
                low = mid + 1;
        }
        int p = high;
        int q = n / p;
        System.out.println(q + " * " + p + " = " + n);
    }



    // -- -- -- -- -- Not part of the solution -- -- -- -- -- //
    private static boolean isHighFactorInRange(int n, int low, int high) {
        int p = findHighFactor(n);
        return p >= low && p <= high;
    }

    private static int findHighFactor(int n) {
        for (int i = n-1; i > 1; i--) {
            if (isPrime(i) && n % i == 0)
                return i;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        findFactors(8509);
    }
}
