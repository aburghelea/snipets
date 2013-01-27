package poo.tema.clone.without.clonable;

import java.io.Serializable;

/**
 * User: Alexandru Burghelea
 * Date: 1/3/13
 * Time: 9:40 AM
 */
public class Domain implements Serializable {
    String name;
    Boolean national;

    public Domain(String name, Boolean national) {
        this.name = name;
        this.national = national;
    }

    //    @Override
    protected Domain clone() throws CloneNotSupportedException {
        return new Domain(name, national);
    }

    @Override
    public String toString() {
        return "Domain{" +
                "name='" + name + '\'' +
                ", national=" + national +
                '}';
    }

}
