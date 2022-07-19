/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static void findWord(char[][] arr, String word){
        int[][] numMat = new int[arr.length][arr[0].length];
        findWord(arr,numMat,word,0,0);
    }


    private static void findWord(char[][] arr, int[][] numMat ,String word, int row, int col){

        if(col > arr[0].length-1){
            col = 0;
            row++;
        }

        if(row > arr.length-1) {
            System.out.println("No Such Word");
            return;
        }

        if(arr[row][col] == word.charAt(0)) {
            boolean wordPrinted = findWord(arr, numMat, word, row, col, 1);
            if(wordPrinted)
                return;
        }

        findWord(arr,numMat,word,row,col+1);
    }


    private static boolean findWord(char[][] arr, int[][] numMat ,String word, int row, int col, int lettersCounted){

        boolean outOfBoundaries = row < 0 || col < 0 || row > arr.length-1 || col > arr[0].length-1;
        if(outOfBoundaries)
            return false;

        if(word.equals("")){
            printArr(numMat);
            return true;
        }

        if(arr[row][col] == '#')
            return false;

        if(arr[row][col] == word.charAt(0)){

            char tempChar = arr[row][col];
            arr[row][col] = '#';
            numMat[row][col] = lettersCounted;

            boolean wordPrinted =
                    findWord(arr, numMat, word.substring(1),row+1,col,lettersCounted + 1)   ||
                            findWord(arr, numMat, word.substring(1),row-1,col,lettersCounted + 1)   ||
                            findWord(arr, numMat, word.substring(1),row,col+1,lettersCounted + 1)    ||
                            findWord(arr, numMat, word.substring(1),row,col-1,lettersCounted + 1);

            arr[row][col] = tempChar;
            numMat[row][col] = 0;

            return wordPrinted;
        }
        return false;
    }


    // -- -- -- -- --   NOT PART OF THE SOLUTION   -- -- -- -- -- //
    public static void printArr (int[][] numMat){

        for (int i = 0; i < numMat.length; i++) {
            for (int j = 0; j < numMat[0].length; j++) {
                System.out.print(" " + numMat[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < numMat.length ; i++) {
            System.out.print(" _");
        }
        System.out.println();
    }

    public static void main(String[] args){
        char[][] arr = {
                {'t', 'z', 'x', 'c', 'd'},
                {'s', 'h', 'a', 'z', 'x'},
                {'h', 'w', 'l', 'o', 'm'},
                {'o', 'r', 'n', 't', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };

        String word = "shalom";
        findWord(arr,word);

        char[][] arr2 = {
                {'t', 'z', 'x', 'c', 'd'},
                {'s', 'h', 'a', 'z', 'x'},
                {'h', 'w', 'l', 'o', 'm'},
                {'k', 'o', 'r', 'e', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };

        word = "koren";
        findWord(arr2,word);

        char[][] arr3 = {
                {'m', 'n', 'o', 'p', 'q'},
                {'l', 'c', 'd', 'e', 'r'},
                {'k', 'b', 'a', 'f', 's'},
                {'j', 'i', 'h', 'g', 't'},
                {'y', 'x', 'w', 'v', 'u'}
        };

        word = "abcdefghijklmnopqrstuvwxy";
        findWord(arr3,word);

        char[][] arr4 = {
                {'t', 'z', 'x', 'c', 'd'},
                {'s', 'h', 'a', 'z', 'x'},
                {'h', 'w', 'l', 'o', 'm'},
                {'k', 'o', 'r', 'e', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };

        word = "notinhere";
        findWord(arr4,word);
    }
}
