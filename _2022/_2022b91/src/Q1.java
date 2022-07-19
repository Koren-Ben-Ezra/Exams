/**
 * Written by Koren Ben Ezra
 * In 2022c
 */
public class Q1 {

    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        return cheapRt(stations, step1, step2, limit, 0, "", 0);
    }

    private static int cheapRt(int[] stations, int step1, int step2, int limit, int index, String str, int totalSum) {
        boolean outOfBoundaries = index > stations.length - 1 || limit < 0;
        if (outOfBoundaries)
            return Integer.MAX_VALUE;

        int lastIndex = stations.length - 1;
        if (index == lastIndex) {
            str += lastIndex;
            totalSum += stations[lastIndex];
            System.out.println(str + " = " + totalSum);
            return totalSum;
        }

        int route1 = cheapRt(stations, step1, step2, limit, index + step1, (str + index), totalSum + stations[index]);
        int route2 = cheapRt(stations, step1, step2, limit - 1, index + step2, (str + index), totalSum + stations[index]);
        return Math.min(route1, route2);
    }

    public static void main(String[] args) {

        //
    }
}
