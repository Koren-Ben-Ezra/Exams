package Q4;

public class A {
    public int _a;
    private int _b;

    public A(int a, int b) {
        _a = a;
        _b = b;
    }

    public int getB() {
        return _b;
    }

    public int f() {
        return f(0);
    }

    public int f(int c) {
        return _b + c;
    }

    public String toString() {
        return "a= " + _a + " , b= " + _b;
    }
}
