package learning.ctci.arraysstring;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author aburghelea
 * @since 1/27/13 - 12:22 PM
 */
public class UniqueChars {
    /**
     * Tests if a string of characters
     * Time complexity is O(n log(n)) because of the sorting
     *
     * @param characters String of characters to test
     * @return <code>true</code> if every character appears only once
     */
    public boolean hasUniqueCharactersBySorting(String characters) {
        char[] chars = characters.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1])
                return false;
        }

        return true;
    }

    public boolean hasUniqueCharactesByCount(String charactes) {
        BitSet bitSet = new BitSet(256);
        for (int i = charactes.length() - 1; i >= 0; i--) {
            int pos = charactes.charAt(i) - '0';
            if (bitSet.get(pos))
                return false;
            bitSet.set(pos, true);
        }

        return true;
    }

    public String removeDuplicatesWithBigBuffer(String original) {
        StringBuilder sb = new StringBuilder();
        int size = original.length();
        boolean found;
        for (int i = 0; i < size; i++) {
            char currentChar = original.charAt(i);
            found = false;

            for (int j = sb.length() - 1; j >= 0; j--) {
                if (sb.charAt(j) == currentChar) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public char[] removeDuplicatesWithoutAditionalBuffer(char[] original) {
        int last = 1, size = original.length;
        boolean found;
        char currentChar;
        if (size <= 1)
            return original;

        for (int i = 1; i < size; i++) {
            found = false;
            currentChar = original[i];
            for (int j = 0 ; j < last; j++){
                if (original[j] == currentChar){
                    found = true;
                    break;
                }
            }
            if (!found){
                original[last] = currentChar;
                last++;
            }
        }


        return new String(original).substring(0, last).toCharArray();
    }

}
