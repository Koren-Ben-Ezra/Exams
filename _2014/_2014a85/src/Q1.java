public class Q1 {

    /*

    This algorithm finds the longest valid hill.
    Actually I couldn't think of something else, but this one is good as well.
    I added another solution that more suitable for the question.

     */
    public static void printPath(int[][] mat) {

        String path = printPath(mat, 0, 0, mat[0][0] - 1, "");
        System.out.println(path);
    }

    private static String printPath(int[][] mat, int row, int col, int prevVal, String pathDoc) {

        boolean outOfBoundaries = row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1;
        if (outOfBoundaries)
            return pathDoc;

        boolean invalidPath = mat[row][col] <= prevVal;
        if (invalidPath)
            return pathDoc;

        pathDoc += "(" + row + "," + col + ")";

        String up = printPath(mat, row - 1, col, mat[row][col], pathDoc);
        String right = printPath(mat, row, col + 1, mat[row][col], pathDoc);
        String down = printPath(mat, row + 1, col, mat[row][col], pathDoc);
        String left = printPath(mat, row, col - 1, mat[row][col], pathDoc);

        return getMaxLength(up, down, right, left);
    }

    private static String getMaxLength(String a, String b, String c, String d) {

        if (a.length() < b.length())
            a = b;

        if (c.length() < d.length())
            c = d;

        if (a.length() < c.length())
            a = c;

        return a;
    }


    public static void main(String[] args) {


        int[][] mat = {
                {3, 8, 7, 1},
                {5, 15, 2, 4},
                {12, 14, -13, 22},
                {13, 16, 17, 52}
        };
        System.out.print("expected: (0,0)(1,0)(2,0)(2,1)(3,1)(3,2)(3,3) \n" +
                "received: ");
        printPath(mat);

        System.out.println("The method found different valid path.");
    }


}
