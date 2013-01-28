package learning.ctci.linkedlists;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aburghelea
 * @since 1/28/13 - 8:03 PM
 */
public class DigitLinkedListUtilsTest {
    DigitLinkedList first, second;

    @Before
    public void setUp() throws Exception {
        first = new DigitLinkedList();
        second = new DigitLinkedList();

    }

    @After
    public void tearDown() throws Exception {
        first = null;
        second = null;
    }

    @Test
    public void testSumWithZeroFirstOperator() throws Exception {
        first.add(1);
        first.add(2);
        first.add(3);
        DigitLinkedList result = DigitLinkedListUtils.sum(first,second);
        Assert.assertEquals("Thei didn't add", "1 -> 2 -> 3;", result.toString());
    }

    @Test
    public void testSumWithZeroSecondOperator() throws Exception {
        second.add(1);
        second.add(2);
        second.add(3);
        DigitLinkedList result = DigitLinkedListUtils.sum(first,second);
        Assert.assertEquals("Thei didn't add", "1 -> 2 -> 3;", result.toString());
    }

    @Test
    public void testWithoutCarry() throws Exception {
        second.add(1);
        second.add(2);
        second.add(3);
        first.add(1);
        first.add(2);
        first.add(3);
        DigitLinkedList result = DigitLinkedListUtils.sum(first,second);
        Assert.assertEquals("Thei didn't add", "2 -> 4 -> 6;", result.toString());
    }

    @Test
    public void testWithInnerCarry() throws Exception {
        second.add(1);
        second.add(2);
        second.add(9);
        first.add(1);
        first.add(2);
        first.add(3);
        DigitLinkedList result = DigitLinkedListUtils.sum(first,second);
        Assert.assertEquals("Thei didn't add", "2 -> 5 -> 2;", result.toString());
    }

    @Test
    public void testWithOutterCarry() throws Exception {
        second.add(9);
        second.add(2);
        second.add(8);
        first.add(9);
        first.add(2);
        first.add(8);
        DigitLinkedList result = DigitLinkedListUtils.sum(first,second);
        Assert.assertEquals("Thei didn't add", "1 -> 8 -> 5 -> 6;", result.toString());
    }
}
