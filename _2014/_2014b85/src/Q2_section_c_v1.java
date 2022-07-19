/**
 * Solution is taken from GeeksForGeeks
 * Source: https://www.geeksforgeeks.org/count-divisors-n-on13/
 */
public class Q2_section_c_v1 {

    // Time complexity: O( n^(1/2) )
    // Space complexity: O(1)
    public static boolean what(int n) {
        return countDivisors(n) % 2 == 0;
    }

    // function to count the divisors
    static int countDivisors(int n) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal,
                // count only one
                if (n / i == i)
                    cnt++;

                else // Otherwise count both
                    cnt = cnt + 2;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("expected true: " + what(7));
        System.out.println("expected true: " + what(6));
        System.out.println("expected false: " + what(4));
    }
}
