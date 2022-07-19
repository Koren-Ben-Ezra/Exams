/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static boolean sumPower3(int num) {
        return sumPower3(num, 0);
    }

    private static boolean sumPower3(int num,int power) {

        if (num == 0)
            return true;

        if (num < 0 || threePowered(power) > num)
            return false;


        return sumPower3(num - threePowered(power), power + 1) ||
                sumPower3(num, power + 1);
    }

    private static int threePowered(int power) {
        if (power == 0)
            return 1;
        return 3 * threePowered(power - 1);
    }

    public static void main(String[] args) {

        System.out.println("expected true: " + sumPower3(37));
        System.out.println("expected false: " + sumPower3(38));
    }
}
