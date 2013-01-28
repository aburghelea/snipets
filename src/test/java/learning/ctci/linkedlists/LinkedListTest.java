package learning.ctci.linkedlists;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aburghelea
 * @since 1/28/13 - 6:10 PM
 */
public class LinkedListTest {

    LinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testEmptyList() throws Exception {
        Assert.assertEquals("Lista ar trebui sa fie goala", "", list.toString());
    }

    @Test
    public void testListWithOneElement() throws Exception {
        list.add("unu");
        Assert.assertEquals("Lista are un element", "unu;", list.toString());
    }

    @Test
    public void testListWithMultipleElements() throws Exception {
        list.add("unu");
        list.add("doi");
        list.add("trei");
        Assert.assertEquals("Lista are trei elemente", "trei -> doi -> unu;", list.toString());
    }

    @Test
    public void testRemoveDuplicatesEmptyList() throws Exception {
        list.removeDuplicates();
        Assert.assertEquals("Lista ar trebui sa fie goala", "", list.toString());
    }

    @Test
    public void testRemoveDuplicatesListWithOneElement() throws Exception {
        list.add("unu");
        list.removeDuplicates();
        Assert.assertEquals("Lista nu avea duplicate", "unu;", list.toString());
    }

    @Test
    public void testRemoveDuplicatesListWithMultipleElements() throws Exception {
        list.add("unu");
        list.add("doi");
        list.add("trei");
        list.removeDuplicates();
        Assert.assertEquals("Lista nu ar trebui sa aibe duplicate", "trei -> doi -> unu;", list.toString());
    }

    @Test
    public void testRemoveDuplicatesFromListWithAllElements() throws Exception {
        list.add("unu");
        list.add("unu");
        list.add("unu");
        list.add("unu");
        list.removeDuplicates();

        Assert.assertEquals("Lista are un element", "unu;", list.toString());
    }

    @Test
    public void testRemoveDuplicatesSlowlyEmptyList() throws Exception {
        list.removeDuplicatesSlowly();
        Assert.assertEquals("Lista ar trebui sa fie goala", "", list.toString());
    }

    @Test
    public void testRemoveDuplicatesSlowlyListWithOneElement() throws Exception {
        list.add("unu");
        list.removeDuplicatesSlowly();
        Assert.assertEquals("Lista nu avea duplicate", "unu;", list.toString());
    }

    @Test
    public void testRemoveDuplicatesSlowlyListWithMultipleElements() throws Exception {
        list.add("unu");
        list.add("doi");
        list.add("trei");
        list.removeDuplicatesSlowly();
        Assert.assertEquals("Lista nu ar trebui sa aibe duplicate", "trei -> doi -> unu;", list.toString());
    }

    @Test
    public void testRemoveDuplicatesSlowlyFromListWithAllElements() throws Exception {
        list.add("unu");
        list.add("unu");
        list.add("unu");
        list.add("unu");
        list.removeDuplicatesSlowly();

        Assert.assertEquals("Lista are un element", "unu;", list.toString());
    }
}
