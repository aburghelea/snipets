package osss;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author aburghelea
 * @since 6/19/13 - 1:59 PM
 */


public class BigestNumber {

    int[] number;
    int position;

    /**
     * Creates a big number
     * @param mydecimal interger from witch to create the number
     */
    public BigestNumber(int mydecimal) {
        this.position = 0;
        this.number = new int[100];

        while (mydecimal != 0) {
            int remeinder = mydecimal % 10;
            this.number[this.position] = remeinder;
            this.position++;
            mydecimal /= 10;
        }
    }


//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (int i = this.position - 1; i >= 0; i--) {
//            s.append(this.number[i]);
//        }
//
//        return  s.toString();
//    }

    public void add(BigestNumber two) {
        int maxPosition = Math.max(this.position, two.position);
        int carry = 0;
        for (int i = 0; i < maxPosition; i++) {
            int intermediate = this.number[i] + two.number[i] + carry;
            this.number[i] = intermediate % 10;
            carry = intermediate / 10;
        }
        if (carry > 0) {
            this.number[this.position] = carry;
            this.position++;
        }
//        printNumber();
    }

    public boolean isPrime(int nr) {

        for(int i =(int) Math.sqrt(nr); i>= 0; i++) {
            if (nr % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        BigestNumber bigestNumber = new BigestNumber(5493);
        BigestNumber secondNumber = new BigestNumber(9111);

        bigestNumber.add(secondNumber);
        System.out.println(bigestNumber);
        System.out.println(bigestNumber.toString());

        BigDecimal bigDecimal = new BigDecimal("100000000000");
        BigDecimal diveder = new BigDecimal("1001");
        BigDecimal[] result = bigDecimal.divideAndRemainder(diveder);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
