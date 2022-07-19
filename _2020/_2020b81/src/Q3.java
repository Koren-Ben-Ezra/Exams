/**
 * Notes by Koren Ben Ezra
 * In 2022b
 */
public class Q3 {
    private static int what(Node root) {

        if (root == null)
            return 0;

        int num1 = what(root.getLeftSon());
        int num2 = what(root.getRightSon());


        // -- -- -- UNCOMMENT THIS LINE TO SEE LIVE PROGRESS OF THE PROGRAM -- -- -- //
        //System.out.println("node: " + root.getNumber() + "\t num1: " + num1 + " num2: " + num2);
        if (Math.abs(num1 - num2) > 1)
            return 0;

        return Math.max(num1, num2) + 1;
    }

    public static boolean whatBool(Node root) {
        return what(root) > 0;
    }


    public static void main(String[] args) {

        Node root = new Node(60);

        // Right side of the root.
        root.setRightSon(new Node(70));
        root.getRightSon().setRightSon(new Node(100));

        // Left-Right side of the root.
        root.setLeftSon(new Node(20));
        root.getLeftSon().setRightSon(new Node(10));
        root.getLeftSon().getRightSon().setRightSon(new Node(90));
        root.getLeftSon().getRightSon().setLeftSon(new Node(80));
        root.getLeftSon().getRightSon().getLeftSon().setRightSon(new Node(40));

        // Left-Left side of the root.
        root.getLeftSon().setLeftSon(new Node(30));
        root.getLeftSon().getLeftSon().setLeftSon(new Node(50));

        System.out.println("\n -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ");
        System.out.println("Let node be some node within the binary tree.\n" +
                "The program checks if all routes that starts from node, \n" +
                "are at most 1 length different from the others.\n" +
                "It checks that for every node within the tree.\n");
        System.out.println("For the original binary tree,\n" +
                "the left side of the tree contain upholds at most 1 length for each route,\n" +
                "but for the right side of the tree, itself doesn't make that claim, \n" +
                "therefore, the final calc for root, num1 = 4, num2 = 2.\n" +
                "and we will receive:");
        System.out.println("what(root) = " + what(root) + " --> boolWhat(root) = " + whatBool(root));

        // Minimal change, Removing node (40).
        root.getLeftSon().getRightSon().getLeftSon().setRightSon(null);

        System.out.println("\nAfter minimal change, removing node (40), \n" +
                "that so the num1 received for the last calc will be 3 instead of 4, num2 is already 2.\n" +
                "the final calc of root, num1 = 3, num2 = 2.");
        System.out.println("what(root) = " + what(root) + " --> boolWhat(root) = " + whatBool(root));
        System.out.println(" -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ");

    }

}
