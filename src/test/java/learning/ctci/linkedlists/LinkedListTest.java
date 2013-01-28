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
        Assert.assertEquals("Stiva ar trebui sa fie goala", "", list.toString());
    }

    @Test
    public void testListWithOneElement() throws Exception {
        list.add("unu");
        Assert.assertEquals("Stiva ar trebui sa fie goala", "unu;", list.toString());
    }

    @Test
    public void testListWithMultipleElements() throws Exception {
        list.add("unu");
        list.add("doi");
        list.add("trei");
        Assert.assertEquals("Stiva ar trebui sa fie goala", "trei -> doi -> unu;", list.toString());
    }
}
