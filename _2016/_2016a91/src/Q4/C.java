package Q4;

public class C extends A{
    public void f2() {
        System.out.println("C::f2()");
    }

    public void f3(A a) {
        f2();
    }
}
