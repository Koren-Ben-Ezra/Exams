/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Q1 {

    public static int knapSack(Item[] items, int w) {
        return knapSack(items, w, 0, 0);
    }

    private static int knapSack(Item[] items, int w, int index, int value) {

        if(w < 0)
            return 0;

        if(w == 0 || index > items.length-1)
            return value;

        // returns the max value between taking the current item or not.
        return max(knapSack(items, w, index + 1, value),
                knapSack(items, w - items[index].getWeight(), index + 1, value + items[index].getValue()));
    }

    private static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }

    public static void main(String[] args) {

        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120),
                new Item(15, 200)
        };

        System.out.println("expected 260: " + knapSack(items, 30));
        System.out.println("expected 360: " + knapSack(items, 50));
    }
}
