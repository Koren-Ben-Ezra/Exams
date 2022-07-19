/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int lcs(String s, String t) {
        return lcs(s, t, 0, 0);
    }

    private static int lcs(String s, String t, int sIndex, int tIndex) {

        // After reached the first ending, of the shorter string,
        // returns 0 to end the count.
        if (sIndex == s.length() || tIndex == t.length())
            return 0;

        // If at the current letters at each string, the characters are equal,
        // adds 1 to the count and jump one letter each string.
        if (s.charAt(sIndex) == t.charAt(tIndex))
            return 1 + lcs(s, t, sIndex + 1, tIndex + 1);


        // the characters are not equal,
        // therefore, gets the maximum value from two cases,
        // each case only one of the strings jumps 1 letter.
        return max(lcs(s, t, sIndex + 1, tIndex),
                lcs(s, t, sIndex, tIndex + 1));
    }

    private static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }


    public static void main(String[] args) {

        String a = "abcdefgh", b = "bcwxftjg", c = "xwd", d = "kmns";

        System.out.println("expected 4: " + lcs(a, b));
        System.out.println("expected 1: " + lcs(b, c));
        System.out.println("expected 0: " + lcs(a, d));
        System.out.println("expected 0: " + lcs(b, d));
        System.out.println("expected 0: " + lcs(c, d));

    }
}
