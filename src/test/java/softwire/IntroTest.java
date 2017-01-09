package softwire;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:alexandru.burghelea@adswizz.com">Alexandru BURGHELEA</a>
 * @since 19/05/16
 */
public class IntroTest {

    private Intro intro;

    @Before
    public void setUp() throws Exception {
        intro = new Intro();
    }

    @Test
    public void testDefaultBehavior() throws Exception {
        String actual = intro.method();
        String expected = "Go To Hell";
        assertEquals(expected, actual);
    }
}