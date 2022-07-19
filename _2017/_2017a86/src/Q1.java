/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int edit(String str1, String str2) {
        return edit(str1, str2, 0);
    }

    private static int edit(String str1, String str2, int count) {

        if (str2.equals("") && str1.equals(""))
            return count;

        // "removes" 1 character to str1
        if (str2.equals(""))
            return edit(str1.substring(1), str2, count + 1);


            // "adds" 1 character to str1
        else if (str1.equals(""))
            return edit(str1, str2.substring(1), count + 1);

        // Both characters at the current index are equal
        // doesn't need to add anything to the count.
        else if (str1.charAt(0) == str2.charAt(0))
            return edit(str1.substring(1), str2.substring(1), count);

        // Both characters at the current index are different,
        // "adds" a character to str1, and "removes" a character.
        // returns the smaller value received.
        else
            return min(edit(str1.substring(1), str2, count + 1), edit(str1, str2.substring(1), count + 1));
    }

    private static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }

    public static void main(String[] args){

        System.out.println("expected 1: " + edit("geek","gesek"));
        System.out.println("expected 4: " + edit("sunday","saturday"));

    }

}
