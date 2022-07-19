/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2_b_notFinal {

    // Time complexity: O(n)
    // Space complexity: O(1)

    /**
     * Answer for 2.a
     */
    public static int subStrC(String s, char c) {
        // for n times that 'c' is in string s,
        // if n >= 3,
        // we could tell that there are n-2 sub-strings as requested.

        int cCharCounter = 0; // ( = n )

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                cCharCounter++;
        }

        if (cCharCounter >= 3)
            return cCharCounter - 2;
        return 0;
    }

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    // Time complexity: O(n)
    // Space complexity: O(1)

    /**
     * Answer for 2.b
     */
    public static int subStrMaxC(String s, char c, int k) {
        // With the same idea, we can notice that for n times that 'c' is in string s,
        // the number of sub-strings that contain at most k times 'c' char with in them is:
        // let k be 3 and n = 6
        // for k = 0 --> 6 sub-strings
        // for k = 1 --> 5 sub-strings
        // for k = 2 --> 4 sub-strings
        // for k = 3 --> 3 sub-strings
        // We notice there is a direct connection,
        // for k >= 0, the sum of sub-strings is the sum of arithmetic sequence
        // that starts with a(1) = n and ends with a(n) = k (last element).
        // In conclusion, the number of sub-strings as requested:
        // S(n,k) = (n-k+1)*(n+k)/2.

        if (k < 0)
            return 0;

        int n = 0; // same as cCharCounter
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                n++;
        }

        // The number of elements within the arithmetic sequence.
        // {n, n-1, n-2, ... , k+2, k+1, k}

        int a = (n - k + 1);
        int b = (n + k);

        return ((n - k + 1) * (n + k)) / 2;
    }


    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    public static void main(String[] args) {
        System.out.println("expected 4: " + subStrC("abcbcabcacabcc", 'c'));


        System.out.println("expected 1: " + subStrMaxC("abcbc", 'c', 0));
        System.out.println("expected 6: " + subStrMaxC("abcbcabcacab", 'c', 2));
        System.out.println("expected 6: " + subStrMaxC("abcbcabcacab", 'c', 3));
        System.out.println("expected 0: " + subStrMaxC("abc", 'c', 2));
    }

}
