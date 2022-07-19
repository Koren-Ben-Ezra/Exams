import java.util.Arrays;
/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q2 {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int[] findUFO(Space tmp) {

        int size = tmp.getSize();
        int lowRow = 0, lowCol = 0;
        int highRow = size - 1, highCol = size - 1;


        while (lowRow <= highRow || lowCol <= highCol) {

            int midRow = (lowRow + highRow) / 2;
            int midCol = (lowCol + highCol) / 2;

            int[] directions = tmp.ask(midRow, midCol);

            if (directions[0] == 0 && directions[1] == 0)
                return new int[]{midRow, midCol};


            // If we know we need to go right, cuts left half,
            // similarly, if we know we need to go up, cuts lower half.
            // and vice versa...
            if (directions[0] == -1)
                lowRow = midRow + 1;
            else if (directions[0] == 1)
                highRow = midRow - 1;

            if (directions[1] == -1)
                lowCol = midCol + 1;
            else if (directions[1] == 1)
                highCol = midCol - 1;
        }

        // Will reach here only if the UFO isn't in space area.
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {

        Space space1 = new Space(10, 4, 8);
        System.out.println("expected [4, 8]: " + Arrays.toString(findUFO(space1)));

        Space space2 = new Space(10, 0, 0);
        System.out.println("expected [0, 0]: " + Arrays.toString(findUFO(space2)));

        Space space3 = new Space(10, 9, 9);
        System.out.println("expected [9, 9]: " + Arrays.toString(findUFO(space3)));

        Space space4 = new Space(10, 0, 9);
        System.out.println("expected [0, 9]: " + Arrays.toString(findUFO(space4)));

        Space space5 = new Space(10, 9, 0);
        System.out.println("expected [9, 0]: " + Arrays.toString(findUFO(space5)));

        Space space6 = new Space(10, 99, 99);
        System.out.print("expected [-1, -1]: " + Arrays.toString(findUFO(space6)));
        System.out.println("\t (if the UFO wasn't in space area)");

    }
}
