package softwire;

/**
 * @author <a href="mailto:alexandru.burghelea@adswizz.com">Alexandru BURGHELEA</a>
 * @since 20/05/16
 */
public class Keplekar {

    public static void main(String[] args) {
        Keplekar checker = new Keplekar();

        int counter = 0;
        for (long i = 0; i < 1000000; i++) {
            if (checker.matches(i, 10)) {
                counter++;
                System.out.println(i);
            }
        }
        System.out.println("Base 10 numbers " + counter);
        counter = 0;
        for (long i = 0; i < 1000000; i++) {
            if (checker.matches(i, 16)) {
                counter++;
            }
        }

        System.out.println("Base 16 numbers " + counter);
    }

    public boolean matches(Long n, int base) {
        if (n < 0) {
            return false;
        }

        String square =String.valueOf(Long.valueOf(String.valueOf(n * n), base));
        if (n <= 3) {
            square = "0" + square;
        }

        int midpoint = square.length() / 2;
        String firstPart = square.substring(0, midpoint);
        String secondPart = square.substring(midpoint);

        Long first = Long.valueOf(firstPart,base);
        Long second = Long.valueOf(secondPart,base);

        return first + second == n || (first/base*base == first && first / base + second == n);

    }

    public String test(Long n, int base) {
        return n + " " + matches(n,base);
    }
}
