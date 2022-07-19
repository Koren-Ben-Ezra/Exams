package Q4;

public class B extends A {

    private int _a;
    private int _b;

    public B() {
        _b = 100;
    }

    public B(int aa) {
        _a = aa;
    }

    public void set(int j) {
        _b = j;
    }

    public int get(int j) {
        return _b;
    }

    public void f1(B b) {
        System.out.println("B::f1(B)");
    }

    public void f1(Object o) {
        System.out.println("B:f1(Object)");
    }

    public void f2(B b) {
        System.out.println("B::f2(B)");
    }
}
