/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths,k,num,0);
    }

    private static int makeSum(int[] lengths, int k, int num, int index) {
        if (num < 0 || k < 0 || index > lengths.length-1)
            return 0;

        if (k == 0)
            return 1;

        return makeSum(lengths, k - lengths[index], num - 1, index) +
                makeSum(lengths, k, num, index + 1);
    }


    public static void main(String[] args){

        int[] lengths = {2,5,10,20,50};
        System.out.println("expected 4: " + makeSum(lengths,40,4));
        System.out.println("expected 1: " + makeSum(lengths,2,4));
        System.out.println("expected 0: " + makeSum(lengths,1,4));

    }
}
