/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    /**
     * Answer to question 1.a
     */
    public static boolean isIdentity(int[][] mat, int x, int size){
        return isIdentity(mat,x,size,0);
    }

    private static boolean isIdentity(int[][] mat, int x, int size, int addToIndex){

        boolean outOfBoundaries = addToIndex+1 > size || size == 0 || x+addToIndex > mat.length-1;

        if(outOfBoundaries)
            return true;

        boolean notIdentity = mat[x][x] != 1 || mat[x][x+addToIndex] != 0 || mat[x+addToIndex][x] != 0;

        if(addToIndex == 0)
            notIdentity = mat[x][x] != 1;

        if(notIdentity)
            return false;

        return isIdentity(mat,x,size,addToIndex+1) &&
                isIdentity(mat,x+1,size-1,0);
    }

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- //

    /**
     * Answer to question 1.b
     */
    public static int maxMatrix(int[][] mat){
        return maxMatrix(mat,0);
    }

    private static int maxMatrix(int[][] mat, int subFromMiddleIndex){
        int middleIndex = mat.length/2;
        int size = 2*subFromMiddleIndex + 1;
        int x = middleIndex - subFromMiddleIndex;

        // finds the first size that the matrix is not center identity by it,
        // and returns the previous size (size - 2)
        // if center identity size is not even 1, returns 0.
        if(isIdentity(mat,x,size))
            return maxMatrix(mat,subFromMiddleIndex+1);
        return (size > 1) ? (size - 2) : 0;
    }

    public static void main(String[] args){

        int mat[][] = {
                {1,2,3,2,0,1,2},
                {0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0},
                {5,0,0,1,0,0,0},
                {7,0,0,0,1,0,0},
                {8,0,0,0,0,1,0},
                {1,0,0,0,0,0,0}
        };

        boolean isTrue, isFalse;

        isTrue = isIdentity(mat, 0,1);
        System.out.println("true: " + isTrue);
        isTrue = isIdentity(mat, 1,1);
        System.out.println("true: " + isTrue);
        isTrue = isIdentity(mat, 1,2);
        System.out.println("true: " + isTrue);
        isTrue = isIdentity(mat, 1,3);
        System.out.println("true: " + isTrue);
        isTrue = isIdentity(mat, 1,4);
        System.out.println("true: " + isTrue);
        isTrue = isIdentity(mat, 4,1);
        System.out.println("true: " + isTrue);
        isTrue = isIdentity(mat, 4,2);
        System.out.println("true: " + isTrue);
        isFalse = isIdentity(mat, 4,3);
        System.out.println("false: " + isFalse);

        int maxSize = maxMatrix(mat);
        System.out.println("is 3: " + maxSize);
    }
}
