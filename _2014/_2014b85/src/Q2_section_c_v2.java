/**
 * Solution is taken from GeeksForGeeks
 * Source: https://www.geeksforgeeks.org/count-divisors-n-on13/
 */
public class Q2_section_c_v2 {

    /*

    NOTE: This solution is too complicated to write in the actual test,
    therefore the first solution is more than enough.
    This one is just a bonus, to show tighter time complexity.
    I don't recommend to read it ;)

     */

    // Time complexity: O( n^(1/3) )
    // Space complexity: O(1)

    public static boolean what(int n) {
        return countDivisors(n) % 2 == 0;
    }

    static void SieveOfEratosthenes(int n, boolean[] prime, boolean[] primeSquare, int[] a) {
        // Create a boolean array "prime[0..n]" and
        // initialize all entries it as true. A value
        // in prime[i] will finally be false if i is
        // Not a prime, else true.
        for (int i = 2; i <= n; i++)
            prime[i] = true;

        /* Create a boolean array "primeSquare[0..n*n+1]"
         and initialize all entries it as false.
         A value in primeSquare[i] will finally
         be true if i is square of prime,
         else false.*/
        for (int i = 0; i < ((n * n) + 1); i++)
            primeSquare[i] = false;

        // 1 is not a prime number
        prime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed,
            // then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        int j = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                // Storing primes in an array
                a[j] = p;

                // Update value in
                // primeSquare[p*p],
                // if p is prime.
                primeSquare[p * p] = true;
                j++;
            }
        }
    }

    // Function to count divisors
    static int countDivisors(int n) {
        // If number is 1, then it will
        // have only 1 as a factor. So,
        // total factors will be 1.
        if (n == 1)
            return 1;

        boolean[] prime = new boolean[n + 1];
        boolean[] primeSquare = new boolean[(n * n) + 1];

        // for storing primes upto n
        int[] a = new int[n];

        // Calling SieveOfEratosthenes to
        // store prime factors of n and to
        // store square of prime factors of n
        SieveOfEratosthenes(n, prime, primeSquare, a);

        // ans will contain total number
        // of distinct divisors
        int ans = 1;

        // Loop for counting factors of n
        for (int i = 0; ; i++) {
            // a[i] is not less than cube root n
            if (a[i] * a[i] * a[i] > n)
                break;

            // Calculating power of a[i] in n.
            // cnt is power of prime a[i] in n.
            int cnt = 1;

            // if a[i] is a factor of n
            while (n % a[i] == 0) {
                n = n / a[i];

                // incrementing power
                cnt = cnt + 1;
            }

            // Calculating the number of divisors
            // If n = a^p * b^q then total
            // divisors of n are (p+1)*(q+1)
            ans = ans * cnt;
        }

        // if a[i] is greater than cube root
        // of n

        // First case
        if (prime[n])
            ans = ans * 2;

            // Second case
        else if (primeSquare[n])
            ans = ans * 3;

            // Third case
        else if (n != 1)
            ans = ans * 4;

        return ans; // Total divisors
    }

    public static void main(String[] args) {
        System.out.println("expected true: " + what(7));
        System.out.println("expected true: " + what(6));
        System.out.println("expected false: " + what(4));
    }
}
