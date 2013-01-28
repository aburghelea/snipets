package learning.ctci.arraysstring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author aburghelea
 * @since 1/28/13 - 12:21 AM
 */
public class RotationTesterTest {

    @Test(expected = NullPointerException.class)
    public void testNullStrings() throws Exception {
        RotationTester.isRotation(null, null);
        fail("Should have failed");
    }

    @Test
    public void testIdenticalWords() throws Exception {
        assertTrue(RotationTester.isRotation("gigel", "gigel"));
    }

    @Test
    public void testOnLeftRotation() throws Exception {
        assertTrue(RotationTester.isRotation("gigel", "igelg"));
    }

    @Test
    public void testRightRotation() throws Exception {
        assertTrue(RotationTester.isRotation("gigel", "lgigel"));
    }

    @Test
    public void testRandomStrings() throws Exception {
        assertFalse(RotationTester.isRotation("gigsadasasdel", "lgig2el"));

    }

    @Test
    public void testWatterBottle() throws Exception {
        assertTrue(RotationTester.isRotation("waterbottle", "erbottlewat"));

    }
}
