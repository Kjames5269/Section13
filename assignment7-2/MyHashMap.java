/*
* Anon
*
* Assignment #7 - MyHashMap, CSc 210, Spring 2017
* This class maintains a hash map with keys of type String and values of type
* double.
*/
public class MyHashMap {
    private final int DEFAULT_CAPACITY = 100;
    private final int PRIME = 98317; // a prime number used by the hash function
    private LinkedList[] map;
    private int size;
    private int capacity;

    public MyHashMap() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        map = new LinkedList[capacity];
    }

    public MyHashMap(int capacity) {
        this.size = 0;
        // throws an IllegalArgumentException if an invalid capacity is given
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        map = new LinkedList[capacity];
    }

    /*
    * insert
    * Inserts the given key/value pair into this MyHashMap
    *
    * Arguments:
    * String key - the key to be added
    * double value - the value to be added
    *
    * Return Value - does not return a value
    */
    public void insert(String key, double value) {
        int i = hash(key);
        if (map[i] == null) {
            map[i] = new LinkedList();
        }
        if (map[i].add(key, value)) {
            size++;
        }
        if (size == capacity) {
            resize();
        }
    }

    /*
    * remove
    * Removes a key/value pair from this MyHashMap based on a given key
    *
    * Arguments:
    * String key - the key of the key/value pair to be removed
    *
    * Return Value - does not return a value
    */
    public void remove(String key) {
        int i = hash(key);
        if (map[i] != null && map[i].remove(key)) {
            size--;
            if (map[i].isEmpty()) {
                map[i] = null;
            }
        }
    }

    /*
    * getValue
    * Returns the value of the key/value pair based on the given key
    *
    * Arguments:
    * String key - the key of the key/value pair which we want to find the value
    *              of
    *
    * Return Value - the value of the key/value pair based on the given key
    */
    public double getValue(String key) {
        int i = hash(key);
        if (map[i] == null) {
            return 0.0;
        }
        return map[hash(key)].getValue(key);
    }

    /*
    * contains
    * Returns true if this MyHashMap contains a key/value pair that cooresponds
    * to the given key or false if it does not.
    *
    * Arguments:
    * String key - the key of the key/value pair which we want to find
    *
    * Return Value - true if this MyHashMap contains a key/value pair that
    *                cooresponds to the given key or false if it does not
    */
    public boolean contains(String key) {
        int i = hash(key);
        if (map[i] == null) {
            return false;
        }
        return map[hash(key)].contains(key);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    /*
    * printTable
    * Prints a representation of this MyHashMap
    *
    * Return Value - does not return a value
    */
    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.println("Index " + i + ":" + map[i]);
        }
    }

    /*
    * hash
    * Given a key this function will produce a semi-unique index within the
    * map[] in which the key/value pair should be stored.
    *
    * Arguments:
    * String key - the key to be hashed
    *
    * Return Value - the hash value of a given key
    */
    private int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int)key.charAt(i) * i;
        }
        sum *= PRIME;
        return Math.abs(sum) % capacity;
    }

    /*
    * resize
    * Resizes this MyHashMap by doubling its capacity.
    *
    * Return Value - does not return a value
    */
    private void resize() {
        LinkedList[] temp = map;
        capacity *= 2;
        size = 0;
        map = new LinkedList[capacity];
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] != null) {
                Node data = temp[i].pop();
                if (data == null) {
                    break;
                }
                insert(data.getKey(), data.getValue());
            }
        }
    }
}
