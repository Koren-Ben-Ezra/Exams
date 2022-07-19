package Q4;

public class C extends B {

    public C(int n) {
        super(n);
    }

    public int f(A a) {
        System.out.print("in C ");
        if (a instanceof C)
            return a.getNum() + 1;
        return super.f(a);
    }
}
