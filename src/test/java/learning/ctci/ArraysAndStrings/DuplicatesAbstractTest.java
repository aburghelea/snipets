package learning.ctci.ArraysAndStrings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aburghelea
 * @since 1/27/13 - 5:42 PM
 */
public abstract class DuplicatesAbstractTest {

    UniqueChars uniqueChars;

    public abstract void check(String original, String expected);

    @Before
    public void setUp() throws Exception {
        uniqueChars = new UniqueChars();
    }

    @After
    public void tearDown() throws Exception {
        uniqueChars = null;
    }

    @Test
    public void testNullString() throws Exception {
        check("", "");
    }

    @Test
    public void testConsecutiveDuplicates() throws Exception {
        check("aaabbbcccc", "abc");
    }

    @Test
    public void testRandomDuplicates() throws Exception {
        check("abcabccabe", "abce");
    }

    @Test
    public void testUniqueChars() throws Exception {
        check("abcde32", "abcde32");
    }

    @Test
    public void testSingleChar() throws Exception {
        check("a", "a");
    }

    @Test
    public void testMultiChar() throws Exception {
        check("bbbb", "b");
    }
}
