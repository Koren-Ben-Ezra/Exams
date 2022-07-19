package Q4;

public class A {

    private int _a;

    public A() {
        _a = 1;
    }

    public void set(int j) {
        _a = j;
    }

    public void set() {
        set(2);
    }

    public int get() {
        return _a;
    }

    public void f1(A a) {
        if (a instanceof B)
            f1((B) a);
        else
            System.out.println("Nothing");
    }

    public void f2(B b) {
        System.out.println("A::f2(B)");
    }

    public void f2(A a) {
        f2((B) a);
    }
}
