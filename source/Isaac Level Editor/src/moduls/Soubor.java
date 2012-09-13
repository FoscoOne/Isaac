package moduls;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Soubor<T> implements Serializable {

    public boolean uloz(T object, String path) {
        ObjectOutputStream vystup = null;
        try {
            vystup = new ObjectOutputStream(new FileOutputStream(path));
            vystup.writeObject(object);
            return true;
        } catch (IOException ex) {
        } finally {
            try {
                vystup.close();
            } catch (IOException ex) {
            }
        }
        return false;
    }

    public T nacti(T object, String path) {
        ObjectInputStream vstup = null;
        try {
            vstup = new ObjectInputStream(new FileInputStream(path));

            Object temp = vstup.readObject();
            object = (T) temp;

            return object;
        } catch (ClassNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                vstup.close();
            } catch (IOException ex) {
            }
        }
        return null;
    }
}
