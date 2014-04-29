package learning.master.iteration;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author aburghelea
 * @since: 9/15/13 - 7:35 PM
 */
public class Copac {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        for (Integer x : set){
            System.out.println(x);
        }
        set.add(1);
        set.add(2);
        set.add(-5);
        for (Iterator<Integer> i = set.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }
}
