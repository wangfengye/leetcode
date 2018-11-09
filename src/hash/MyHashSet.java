package hash;

class MyHashSet {
    int bucket = 1000;
    int item = 1001;
    boolean[][] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        table = new boolean[bucket][];
    }

    public void add(int key) {
        int hash = hash(key);
        if (table[hash] == null) {
            table[hash] = new boolean[item];
        }
        table[hash][pos(key)] = true;
    }

    public void remove(int key) {
        if (contains(key)) table[hash(key)][pos(key)] = false;
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int hash = hash(key);
        return table[hash] != null && table[hash][pos(key)];
    }

    private int hash(int i) {
        return i % bucket;
    }

    private int pos(int i) {
        return i / bucket;
    }
}