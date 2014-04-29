package learning.master.polymorphism;

/**
 * @author aburghelea
 * @since: 9/15/13 - 5:15 PM
 */
public class TestMasina {

    public static void main(String[] args) {
        Vehicul vehicul;
        Masina masina;
        vehicul = new Vehicul();
        masina = new Masina();
        vehicul.conduce();
        masina.conduce();
        vehicul = masina;
        vehicul.conduce();
    }
}
