package hashmap;

import java.util.LinkedList;

public class DesignHashSet705 {

    private static final int SIZE = 10_000;
    private LinkedList[] storage;
    public DesignHashSet705() {
        storage = new LinkedList[SIZE];
        for (int i=0;i<SIZE;i++){
            storage[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        if (contains(key))
            return;
        storage[hash(key)].add(key);
    }

    public void remove(int key) {
        if (!contains(key))
            return;
        storage[hash(key)].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hashKey = hash(key);
        return storage[hashKey].contains(key);
    }

    private int hash(int key){
        return key % SIZE;
    }

}
