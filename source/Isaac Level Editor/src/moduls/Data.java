package moduls;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data<T> implements Serializable {

    public boolean uloz(T object, String path) {
        ObjectOutputStream vystup = null;
        try {
            vystup = new ObjectOutputStream(new FileOutputStream(path));
            vystup.writeObject(object);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                vystup.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                vstup.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
