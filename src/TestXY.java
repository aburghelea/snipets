/**
 * User: Alexandru Burghelea
 * Date: 11/26/12
 * Time: 9:42 PM
 */
public class TestXY {
    public static void main(String args[]) {
        X o1 = new X(), o2 = new Y();
        Y o3 = new Y();
        o1.m(new X());
        o1.m(new Y());
        o2.m(new X());
        o2.m(new Y());
        o3.m(new X());
        o3.m(new Y());
    }
}

class X {
    void m(X ob) {
        System.out.println("A");
    }

    void m(Y ob) {
        System.out.println("B");
    }
}

class Y extends X {
    void m(Y ob) {
        System.out.println("D");
    }
}
