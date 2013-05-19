package learning.misc;

import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aburghelea
 * @since 4/21/13 - 3:30 PM
 */
public class GenericsTest {

    @Test
    public void testGenericAddDivegingSubclass() throws Exception {
        BigDecimal bigDecimalOne = BigDecimal.ONE;
        List<Serializable> list = new ArrayList<>();
        String stringTwo = "2";
        list.add(bigDecimalOne);
        list.add(stringTwo);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

    @Test
    public void addSubclass() throws Exception {
        BigDecimal bigDecimalOne = BigDecimal.ONE;
        List<Number> list = new ArrayList<>();
        list.add(bigDecimalOne);
        System.out.println(list.get(0));
    }

}
