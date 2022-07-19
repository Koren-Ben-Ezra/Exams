/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int longOrdNum(String s) {
        if (s.equals(""))
            return 0;

        int length = longOrdNum(s, (char) (s.charAt(0) - '1'));
        int nextLength = longOrdNum(s.substring(1));

        return Math.max(length, nextLength);
    }

    private static int longOrdNum(String s, char prevChar) {

        if (s.equals(""))
            return 0;

        boolean notANumber = s.charAt(0) < '0' || s.charAt(0) > '9';
        if (notANumber)
            return 0;

        boolean invalidSequence = prevChar >= s.charAt(0);
        if (invalidSequence)
            return 0;

        return 1 + longOrdNum(s.substring(1), s.charAt(0));
    }

    public static void main(String[] args) {

        System.out.println("expected 3: " + longOrdNum("x12y3348"));
        System.out.println("expected 1: " + longOrdNum("321"));
        System.out.println("expected 0: " + longOrdNum("xyz"));
        System.out.println("expected 0: " + longOrdNum(""));
        System.out.println("expected 4: " + longOrdNum("23256812"));
        System.out.println("expected 4: " + longOrdNum("1234"));
        System.out.println("expected 1: " + longOrdNum("9"));
    }


}
