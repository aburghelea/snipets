package learning.ctci.ArraysAndStrings;

/**
 * @author aburghelea
 * @since 1/27/13 - 10:56 PM
 */
public class AnagramTester {

    private static final int length = 256;

    public static boolean check(String firstString, String secondString){

        int[] firstApperences = countApperences(firstString);
        int[] secondApperences = countApperences(secondString);

        for (int i = 0; i < length ; i++) {
            if (firstApperences[i] != secondApperences[i])
                return false;
        }

        return true;
    }

    private static int[] countApperences(String word) {
        int[] apperences = new int[length];
        for (int i = word.length() - 1 ; i >= 0; i--){
            int pos = word.charAt(i) - '0';
            apperences[pos]++;
        }

        return apperences;
    }
}
