package learning.ctci.arraysstring;


import org.junit.Assert;

/**
 * @author aburghelea
 * @since 1/27/13 - 6:04 PM
 */
public class DuplicatesWithoutBuffer extends DuplicatesAbstractTest {
    @Override
    public void check(String original, String expected) {
        char[] actual = uniqueChars.removeDuplicatesWithoutAditionalBuffer(original.toCharArray());
        Assert.assertArrayEquals("Without buffer " + original, expected.toCharArray(), actual);
    }
}
