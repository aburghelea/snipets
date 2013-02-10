package learning.ctci.sortandsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aburghelea
 * @since 2/10/13 - 1:22 PM
 */
public class PresumedSortedArrayWithIntercaletedSpaces {

    private List<String> list;

    public PresumedSortedArrayWithIntercaletedSpaces() {
        this.list = new ArrayList<>();
    }

    public int search(String element){
        return search(element, 0, list.size()-1);
    }
    private int search(String element, int left, int right) {
        if (left > right)
            return -1;
        int middle = (left + right) / 2;
        int middleRight = middle;
        if (middle == 0)
        while ("".equals(list.get(middle)))
            middle--;

        if (element.equals(list.get(middle)))
            return middle;

        if (element.compareTo(list.get(middle)) > 0)
            return search(element, middleRight + 1, right);

        return search(element, left, middle - 1);
    }

    public boolean add(String s) {
        return list.add(s);
    }


}
