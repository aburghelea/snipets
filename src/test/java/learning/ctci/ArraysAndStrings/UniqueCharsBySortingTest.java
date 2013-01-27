package learning.ctci.ArraysAndStrings;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;

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
