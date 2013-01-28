package learning.ctci.arraysstring;

import junit.framework.Assert;

/**
 * @author aburghelea
 * @since 1/27/13 - 1:05 PM
 */
public class UniqueCharsBySortingTest extends UniqueCharsAbstract {

    void check(String characters, boolean expected) {
        boolean actual = uniqueChars.hasUniqueCharactersBySorting(characters);
        Assert.assertEquals("By sorting " + characters, expected, actual);
    }
}
