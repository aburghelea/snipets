package learning.ctci.arraysstring;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author aburghelea
 * @since 1/27/13 - 11:03 PM
 */
public class AnagramTesterTest {


    @Test
    public void testDifferentIdenicalLetters() throws Exception {
        String first = "a";
        String second = "b";
        boolean areAnagrams = AnagramTester.check(first, second);
        assertFalse(first + " " + second + " are anagrams", areAnagrams);
    }

    @Test
    public void testDifferentIdenicalWords() throws Exception {
        String first = "aaabbb";
        String second = "aaaxbb";
        boolean areAnagrams = AnagramTester.check(first, second);
        assertFalse(first + " " + second + " are anagrams", areAnagrams);
    }

    @Test
         public void testReverseString() throws Exception {
        String first = "abcdef";
        String second = "fedcba";
        boolean areAnagrams = AnagramTester.check(first, second);
        assertTrue(first + " " + second + " are anagrams", areAnagrams);
    }


    @Test
    public void testRandomStrings() throws Exception {
        String first = "abc34rdef";
        String second = "fadcsdabe";
        boolean areAnagrams = AnagramTester.check(first, second);
        assertFalse(first + " " + second + " are anagrams", areAnagrams);
    }

    @Test
    public void testRandomAnagrams() throws Exception {
        String first = "abcdef";
        String second = "fadcbe";
        boolean areAnagrams = AnagramTester.check(first, second);
        assertTrue(first + " " + second + " are anagrams", areAnagrams);
    }
    @Test
    public void testCheckIdenicalLetters() throws Exception {
        String first = "a";
        String second = "a";
        boolean areAnagrams = AnagramTester.check(first, second);
        assertTrue(first + " " + second + " are anagrams", areAnagrams);
    }

    @Test
    public void testCheckIdenicalWords() throws Exception {
        String first = "aaabbb";
        String second = "aaabbb";
        check(first, second);
    }

    private void check(String first, String second) {
        boolean areAnagrams = AnagramTester.check(first, second);
        assertTrue(first + " " + second + " are anagrams", areAnagrams);
    }
}
