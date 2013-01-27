package learning.ctci.ArraysAndStrings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aburghelea
 * @since 1/27/13 - 12:47 PM
 */
public abstract class UniqueCharsAbstract {
    UniqueChars uniqueChars;

    abstract void check(String characters, boolean expected);

    @Before
    public void setUp() throws Exception {
        uniqueChars = new UniqueChars();
    }

    @After
    public void tearDown() throws Exception {
        uniqueChars = null;
    }

    @Test
    public void testIfNullStringHasUniqueCharacts() throws Exception {
        check("", true);
    }

    @Test
    public void testStringWithOneCharacter() throws Exception {
        check("a", true);
    }

    @Test
    public void testStringWithSameCharacter() throws Exception {
        check("aa", false);
    }

    @Test
    public void testStringWithInterlacingDuplicates() throws Exception {
        check("ababc", false);
    }

    @Test
    public void testStringWithFolowingDuplicates() throws Exception {
        check("aabb", false);
    }

    @Test
    public void testStringWithNoDuplicates() throws Exception {
        check("aBsd3", true);
    }
}
