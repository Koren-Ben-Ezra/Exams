/**
 * Written by Koren Ben Ezra
 * In 2023a
 */
public class Q3 {

    public static boolean isWay(int[] a) {
        // Starting point set to index 0.
        return isWay(a, 0);
    }

    private static boolean isWay(int[] a, int index) {
        if (index == a.length - 1)
            // Reached the last index --> Valid way exist.
            // Ending point set to the last index.
            return true;

        if (index < 0 || index > a.length - 1)
            // Passed the array's boundaries --> Invalid way.
            return false;

        // Changing the current number temporarily to avoid endless loops.
        // If by chance the index returns to that specific spot --> throws the index away from the array boundaries.
        int tempVal = a[index];
        a[index] = a.length;

        // Sent new two ways from current location.
        boolean rightWay = isWay(a, index + tempVal);
        boolean leftWay = isWay(a, index - tempVal);

        // Changing back the number to its original value.
        a[index] = tempVal;

        // Checks if at least one of the ways are valid.
        return rightWay || leftWay;
    }

    public static void main(String[] args) {

        System.out.println("expected true: " + isWay(new int[]{2, 4, 1, 6, 4, 2, 4, 3, 5}));
        System.out.println("expected false: " + isWay(new int[]{1, 4, 3, 1, 2, 4, 3}));

    }
}
