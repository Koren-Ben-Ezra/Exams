/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Space {
    private int _x;
    private int _y;
    private int _size;

    public Space(int n) {
        // lol what... hell no, i'm not messing with random...
    }

    public Space(int n, int x, int y) {
        _x = x;
        _y = y;
        _size = n;
    }

    public int getSize() {
        return _size;
    }

    public int[] ask(int x, int y) {
        int[] directions = new int[2];
        // NOTE: Default value is [0, 0]

        if (x < _x)
            directions[0] = -1;
        else if (x > _x)
            directions[0] = 1;

        if (y < _y)
            directions[1] = -1;
        else if (y > _y)
            directions[1] = 1;

        return directions;
    }
}
