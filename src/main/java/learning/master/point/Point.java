package learning.master.point;

import java.util.ArrayList;

/**
 * @author aburghelea
 * @since 9/15/13 - 5:31 PM
 */
public class Point {
    private final int x;
    private final int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point center = new Point();
        Point first = new Point(1,1);
        Point second = new Point(-1,2);
        Point third = new Point(-3, -1);
        Point forth = new Point(3, -2);

        System.out.println(center);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(forth);
        ArrayList<Point> points = new ArrayList<Point>();
        /** The following line does not will not work because List<Object> is not a super class of List<Point> although
         * Object is the superclass of object;
         * ArrayList<Object> objects = points;
         * objects.add(new Point());
         */


    }
}
