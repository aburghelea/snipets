package learning.master.adaugabil;

/**
 * @author aburghelea
 * @since: 9/15/13 - 5:42 PM
 */
public class UnSir implements Adaugabil<UnSir> {
    @Override
    public UnSir adauga(UnSir a) {
        return a;
    }
}
