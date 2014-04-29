package learning.master.adaugabil;

/**
 * @author aburghelea
 * @since: 9/15/13 - 5:42 PM
 */
public class TestAdaugabil {

    public static void main(String[] args) {
        UnSir unSir = new UnSir();
        UnSir altSir = new UnSir();
        OLista oLista = new OLista();
        OLista altaLista = new OLista();
        unSir.adauga(altSir);
        oLista.adauga(altaLista);
//        unSir.adauga(oLista);
//        altaLista.adauga(altSir);
    }
}
