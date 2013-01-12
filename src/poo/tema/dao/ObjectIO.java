package poo.tema.dao;

import poo.tema.clone.without.clonable.Domain;

import java.io.*;
import java.util.Date;

/**
 * User: Alexandru Burghelea
 * Date: 1/10/13
 * Time: 2:36 PM
 */
public class ObjectIO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Domain domain = new Domain("ObjectIO", false);
        String test = "TEST";
        File objectIO = new File("ObjectIO");
        if (objectIO.exists())
            objectIO.delete();
        objectIO.createNewFile();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectIO));
        objectOutputStream.writeObject(domain);
        objectOutputStream.writeObject(test);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectIO));
        System.out.println(objectInputStream.readObject());
        System.out.println(objectInputStream.readObject());
    }
}
