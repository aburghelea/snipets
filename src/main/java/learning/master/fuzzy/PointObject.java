package learning.master.fuzzy;

import learning.master.point.Point;

/**
 * @author aburghelea
 * @since: 9/15/13 - 5:45 PM
 */
public class PointObject {
    public static void main(String[] args) {
        Point[] a = new Point[10];
        Object[] b;
        b = a;
        b[0] = "success";
    }
}
