package Q4;
/**
 * Written by Koren Ben Ezra
 * In 2022b
 */
public class Driver {

    public static void main(String[] args) {

        A aa = new A(0, 1);
        A ab = new B(0, 1);
        B bb = new B(-2, -1);

        int result = (ab.f());  // Write command here for debug.
        System.out.println(result);

    }
}
