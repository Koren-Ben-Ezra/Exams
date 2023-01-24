/**
 * Written by Koren Ben Ezra
 * In 2023a
 */
public class Q1 {

    // Time complexity: O(n)
    // Space complexity: O(1)

    public static int alternating(String s) {
        // Checks every even index if it is equals to the first number,
        // if not, then one change is needed for that number,
        // the other number that we need to change from is in the odd index,
        // so we can simply ignore it xD.

        int firstNum = s.charAt(0);
        int numberOfChanges = 0;

        for (int i = 2; i < s.length(); i += 2) {
            if (s.charAt(i) != firstNum)
                numberOfChanges++;
        }

        int numberOfChangesOfOpposite = s.length() / 2 - numberOfChanges;
        return Math.min(numberOfChanges, numberOfChangesOfOpposite);
    }

    public static void main(String[] args) {
        System.out.println("expected 2: " + alternating("00011011"));
        System.out.println("expected 3: " + alternating("00101011"));
    }
}
