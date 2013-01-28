package learning.ctci.arraysstring;

import junit.framework.Assert;

/**
 * @author aburghelea
 * @since 1/27/13 - 1:08 PM
 */
public class UniqueCharsByCountingTest extends UniqueCharsAbstract {

    void check(String characters, boolean expected) {
        boolean actual = uniqueChars.hasUniqueCharactesByCount(characters);
        Assert.assertEquals("By counting " + characters, expected, actual);
    }
}
