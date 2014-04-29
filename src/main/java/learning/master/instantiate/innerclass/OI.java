package learning.master.instantiate.innerclass;

/**
 * @author aburghelea
 * @since: 9/15/13 - 4:49 PM
 */
public class OI {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner = new Outer().new Inner();
    }
}
