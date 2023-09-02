package hashmap;

import java.util.LinkedList;
import java.util.Objects;

public class DesignHashMap706 {

    class Entry{
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    private LinkedList<Entry> storage[];
    private static final int SIZE = 1000;
    public DesignHashMap706() {
        storage = new LinkedList[SIZE];
        for (int i=0;i<SIZE;i++)
            storage[i] = new LinkedList<>();
    }

    private int hashcode(int key){
        return key % SIZE;
    }

    public void put(int key, int value) {
        Entry entry = new Entry(key, value);
        int hasCode = hashcode(key);
        if (!storage[hasCode].contains(entry))
            storage[hasCode].add(entry);
        else
            storage[hasCode].get(storage[hasCode].indexOf(entry)).value = value;
    }

    public int get(int key) {
        int idx = storage[hashcode(key)].indexOf(new Entry(key,0));
        if (idx >= 0)
            return storage[hashcode(key)].get(idx).value;
        return -1;
    }

    public void remove(int key) {
        int idx = storage[hashcode(key)].indexOf(new Entry(key,0));
        if (idx >= 0)
            storage[hashcode(key)].remove(idx);
    }

    public static void main(String[] args) {
        DesignHashMap706 map = new DesignHashMap706();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2,1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));

    }
}
