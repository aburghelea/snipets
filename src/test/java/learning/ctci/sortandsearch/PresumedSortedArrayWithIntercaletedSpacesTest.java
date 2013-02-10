package learning.ctci.sortandsearch;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aburghelea
 * @since 2/10/13 - 1:32 PM
 */
public class PresumedSortedArrayWithIntercaletedSpacesTest {


    PresumedSortedArrayWithIntercaletedSpaces sortedArrayWithIntercaletedSpaces;

    @Before
    public void setUp() throws Exception {
        sortedArrayWithIntercaletedSpaces = new PresumedSortedArrayWithIntercaletedSpaces();
    }

    @After
    public void tearDown() throws Exception {
        sortedArrayWithIntercaletedSpaces = null;
    }

    @Test
    public void testEmptyArray() throws Exception {
        Assert.assertEquals("Nu exista elementul cautat", -1, sortedArrayWithIntercaletedSpaces.search("12"));
    }

    @Test
    public void testArrayWithWhiteSpaces() throws Exception {
        for (int i = 0; i < 10; i++)
            sortedArrayWithIntercaletedSpaces.add("");
        Assert.assertEquals("Nu exista elementul cautat", -1, sortedArrayWithIntercaletedSpaces.search("12"));

    }

    @Test
    public void testNotNullExistingElement() throws Exception {
        sortedArrayWithIntercaletedSpaces.add("a");
        sortedArrayWithIntercaletedSpaces.add("b");
        sortedArrayWithIntercaletedSpaces.add("c");
        sortedArrayWithIntercaletedSpaces.add("d");
        Assert.assertEquals("Nu exista elementul cautat", 2, sortedArrayWithIntercaletedSpaces.search("c"));

    }

    @Test
    public void testNotNullExistingElementWithWhiteSpaces() throws Exception {
        sortedArrayWithIntercaletedSpaces.add("a");
        sortedArrayWithIntercaletedSpaces.add("");
        sortedArrayWithIntercaletedSpaces.add("b");
        sortedArrayWithIntercaletedSpaces.add("");
        sortedArrayWithIntercaletedSpaces.add("c");
        sortedArrayWithIntercaletedSpaces.add("d");
        Assert.assertEquals("Nu exista elementul cautat", 4, sortedArrayWithIntercaletedSpaces.search("c"));

    }

    @Test
    public void testNotNullExistingElementWithWhiteSpaces2() throws Exception {
        sortedArrayWithIntercaletedSpaces.add("a");
        sortedArrayWithIntercaletedSpaces.add("");
        sortedArrayWithIntercaletedSpaces.add("b");
        sortedArrayWithIntercaletedSpaces.add("");
        sortedArrayWithIntercaletedSpaces.add("c");
        sortedArrayWithIntercaletedSpaces.add("d");
        Assert.assertEquals("Nu exista elementul cautat", 0, sortedArrayWithIntercaletedSpaces.search("a"));

    }
}
