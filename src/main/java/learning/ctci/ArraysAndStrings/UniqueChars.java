package learning.ctci.ArraysAndStrings;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author aburghelea
 * @since 1/27/13 - 12:22 PM
 */
public class UniqueChars {

    public boolean hasUniqueCharactersBySorting(String characters) {
        char[] chars = characters.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1])
                return false;
        }

        return true;
    }

    public boolean hasUniqueCharactesByCount(String charactes){
        BitSet bitSet = new BitSet(256);
        for (int i = charactes.length() - 1 ; i >= 0 ; i--) {
            int pos = charactes.charAt(i) - '0';
            if (bitSet.get(pos))
                return false;
            bitSet.set(pos,true);
        }

        return true;
    }
}
