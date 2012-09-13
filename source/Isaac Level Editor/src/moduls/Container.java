package moduls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Container implements Serializable {

    private ArrayList<LevelObject> container;

    public Container() {
        container = new ArrayList<LevelObject>();
    }

    public void add(LevelObject o) {
        container.add(o);
    }

    public void remove(LevelObject o) {
        container.remove(o);
    }

    public void clear() {
        container.clear();
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public Iterator<LevelObject> getIterator() {
        return container.iterator();
    }
    
    public int size() {
        return container.size();
    }
    
    public LevelObject get(int index) {
        return container.get(index);
    }
}
