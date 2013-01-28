package learning.ctci.ArraysAndStrings;

/**
 * @author aburghelea
 * @since 1/28/13 - 12:15 AM
 */
public class RotationTester {

    public static boolean isRotation(String original, String candidate){
        original += original;
        return original.contains(candidate);
    }
}
