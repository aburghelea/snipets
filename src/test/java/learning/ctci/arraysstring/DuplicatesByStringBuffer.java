package learning.ctci.arraysstring;

import junit.framework.Assert;

/**
 * @author aburghelea
 * @since 1/27/13 - 5:44 PM
 */
public class DuplicatesByStringBuffer extends DuplicatesAbstractTest {

    public void check(String original, String expected) {
        String actual = uniqueChars.removeDuplicatesWithBigBuffer(original);
        Assert.assertEquals("By StringBuffer " + original, expected, actual);
    }
}
