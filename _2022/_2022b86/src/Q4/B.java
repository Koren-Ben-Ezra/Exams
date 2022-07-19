package Q4;

public class B extends A {

    public B(int n) {
        super(n);
    }

    public int f(B b) {
        System.out.print("in B ");
        setNum(b.getNum() * 2);
        return getNum();
    }
}
