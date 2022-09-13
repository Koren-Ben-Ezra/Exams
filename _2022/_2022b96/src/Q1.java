/**
 * Written by Koren Ben Ezra
 * In 2022c
 */
public class Q1 {
    
    public static int calc(int num, int result, int maxOp) {
        // Call the overridden function with the starting values:
        // tempResult = num
        // equationStr = num, as string.
        return calc(num, result, num, maxOp, String.valueOf(num));
    }

    private static int calc(int num, int result, int tempResult, int maxOp, String equationStr) {
        
        // Checks if passed max operations.
        if (maxOp < 0)
            return 0;

        // Checks if the current equation equals to result.
        // if so, prints the equation as requested.
        if (tempResult == result) {
            // Prints suitable equation.
            System.out.println(equationStr + " = " + result);
            return 1;
        }
        
        // Create new 4 recurtion calls with all possible operations as changing the right data. (tempResult and equationStr)
        return calc(num, result, tempResult + num, maxOp - 1, (equationStr + " + " + num)) +
                calc(num, result, tempResult - num, maxOp - 1, (equationStr + " - " + num)) +
                calc(num, result, tempResult * num, maxOp - 1, (equationStr + " * " + num)) +
                calc(num, result, tempResult / num, maxOp - 1, (equationStr + " / " + num));

    }

    public static void main(String[] args) {
        System.out.println(calc(3, 36, 5));
    }

}
