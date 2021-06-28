import java.util.HashMap;
import java.util.Iterator;

public class STHashMap<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private HashMap<Key, Value> st;

    public STHashMap() {
        st = new HashMap<Key, Value>();
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("calls remove() with null key");
        st.remove(key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }
}