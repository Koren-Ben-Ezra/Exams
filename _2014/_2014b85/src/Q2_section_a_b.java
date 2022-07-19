/**
 * Edited by Koren Ben Ezra
 * In 2022b
 */
public class Q2_section_a_b {

    /*

    The method 'what' receive a number,
    and return true if the number of possible dividers is even.
    else, returns false.

    Time complexity: O(n)
    Space complexity: O(1)
     */


    public static boolean what(int n) {
        return (f(n) % 2 == 0);
    }

    public static int f(int n) {
        int c = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                c++;
        }
        return c;
    }

    public static void main(String[] args){
        System.out.println("expected true: " + what(7));
        System.out.println("expected true: " + what(6));
        System.out.println("expected false: " + what(4));

        System.out.println(f(600));
        System.out.println(f(3000));

    }
}
