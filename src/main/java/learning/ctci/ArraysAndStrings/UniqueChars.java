package main.java.learning.ctci.ArraysAndStrings;

import java.util.Arrays;

/**
 *
 * @author aburghelea
 * @since 1/27/13 - 12:22 PM
 */
public class UniqueChars {
    boolean hasUniqueCharactersBySorting(String characters){
        char[] chars = characters.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++){
            if (chars[i] == chars[i-1])
                return true;
        }

        return false;
    }
}
