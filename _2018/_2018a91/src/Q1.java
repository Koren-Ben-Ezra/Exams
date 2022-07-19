/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int cheapestRoute(int[] stations) {
        return cheapestRoute(stations, 0);
    }

    private static int cheapestRoute(int[] stations, int index) {

        if (index == stations.length - 1)
            return stations[index];

        if (index == stations.length - 2)
            return cheapestRoute(stations, index + 1);

        // Pays for the current station and jumps to the next station OR the one ofter it,
        // depends on who is the cheapest.
        return stations[index] +
                min(cheapestRoute(stations, index + 1), cheapestRoute(stations, index + 2));
    }

    private static int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }


    public static void main(String[] args) {
        int[] stations = {2, 8, 3, 4, 7, 1, 3, 2};

        System.out.println("expected 12: " + cheapestRoute(stations));
    }
}
