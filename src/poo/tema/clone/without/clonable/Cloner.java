package poo.tema.clone.without.clonable;

/**
 * User: Alexandru Burghelea
 * Date: 1/3/13
 * Time: 9:41 AM
 */
public class Cloner {
    public static void main(String[] args) {
        Domain original = new Domain("NAME", true);
        try {
            Domain clone = original.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
