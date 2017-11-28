/**
Anon

Assignment 6 – MyHashMap, CSC 210, Fall 2017

Purpose: This class is used to construct hash tables using a String-based hash function. Once the size of the
MyHashMap object matches its capacity, its capacity is doubled and it entries are shuffled to accomodate
the change in modular arithmetic. Collisions are managed via chaining through LinkedList objects.

Inherits From: None

Instance Variables:
     table – a LinkedList[] that holds up to as many LinkedList objects as its capacity
     capacity – an int that specifies the maximum number of entries that can be held

Constructors: Each MyHashMap object can be constructed with any positive capacity, or a default capacity of 100.
**/

public class MyHashMap {

/* Instance Variables */

     private LinkedList[] table;
     private int capacity;

/* Constructors */

     public MyHashMap() {
          this.table = new LinkedList[100];
          this.capacity = 100;
     }

     public MyHashMap(int capacity) {
          if (capacity>1) {
               this.table = new LinkedList[capacity];
               this.capacity = capacity;
          }
          else { System.err.println("capacity must be positive");
          System.exit(1); }
     }

/* Helper Methods */

     /**
     Method Name: myHashFunction

     Purpose: This method hashes a String to a particular non-negative index that is less than the current capacity of
     this MyHashMap.

     Parameters:
          word – the String to be hashsed

     Calls On: None

     Returns: int – the hashed value of String word
     **/
     private int myHashFunction(String word) {
          int hash = word.length();
          for (int i = 0; i < word.length(); i++) {
               hash = 37*hash + word.charAt(i);
          }
          hash = hash % this.capacity;
          if (hash < 0) { hash *= -2;
               hash = hash % this.capacity; }
          return hash;
     }

     /**
     Method Name: resize

     Purpose: This method resizes this MyHashMap by doubling its current capacity. It then rehashes and reinserts the
     existing entries of according to the new capacity.

     Parameters: None

     Calls On: None

     Returns: None
     **/
     private void resize() {
          MyHashMap resized = new MyHashMap(this.capacity*2);
          for (int i = 0; i < this.capacity; i++) {
               if (this.table[i]!=null) {
                    while (this.table[i].getLength()!=0) {
                         Node current = this.table[i].getHead();
                         resized.insert(current.getWord(),current.getValue());
                         this.table[i].remove(current);
                    }
               }

          }
          this.table = resized.table; this.capacity *= 2;
     }

/* Instance Methods */

     /**
     Method Name: insert

     Purpose: This method inserts a new entry into this MyHashMap. If the entry already exists, then its value is
     updated. If it does not exist, and there is a collision, the entry is appended to the end of the LinkedList
     that already exists in the bucket. Otherwise, a new LinkedList is created with the new Node as its head.

     Parameters:
          word – the String for the new Node
          value – the Double for the new Node

     Calls On: myHashFunction, size, capacity, resize

     Returns: None
     **/
     public void insert(String word, Double value) {
          int hash = this.myHashFunction(word); Node insert;
          if (this.table[hash]==null) {
               insert = new Node(word,value);
               LinkedList entry = new LinkedList(insert); this.table[hash] = entry;
               if ( this.size()==this.capacity() ) { this.resize(); }
          }
          else if (this.table[hash].containsString(word)) {
               insert = this.table[hash].findString(word); insert.setValue(value);
          }
          else {
               insert = new Node(word,value); this.table[hash].append(insert);
               if ( this.size()==this.capacity() ) { this.resize(); }
          }
     }

     /**
     Method Name: remove

     Purpose: This method removes an existing entry from this MyHashMap. If the entry does not exist, nothing happens.
     If the Node being removed is downstream of an existing LinkedList, then only that Node is removed. Otherwise,
     the bucket is reset to null.

     Parameters:
          word – the String that specifies the Node to be removed.

     Calls On: myHashFunction

     Returns: None
     **/
     public void remove(String word) {
          int hash = this.myHashFunction(word);
          if (this.table[hash]!=null) {
               this.table[hash].remove(this.table[hash].findString(word));
          }
          if (this.table[hash].getLength()==0) { this.table[hash] = null; }
     }

     /**
     Method Name: getValue

     Purpose: This method returns the value currently associated with the key passed to it. If the Node with this key as
     its instance variable is not found, then 0.0 is returned.

     Parameters:
          word – the String key associated with the value to be returned

     Calls On: contains

     Returns: Double – the current value associated with word.
     **/
     public Double getValue(String word) {
          if (this.contains(word)) {
               int hash = this.myHashFunction(word);
               return this.table[hash].findString(word).getValue();
          }
          return 0.0;
     }

     /**
     Method Name: contains

     Purpose: This method determines whether this MyHashMap currently contains a particular String key.

     Parameters:
          word – the String key to be checked

     Calls On: None

     Returns: boolean – true if this MyHashMap currently contains word, false otherwise.
     **/
     public boolean contains(String word) {
          int hash = this.myHashFunction(word);
          if (this.table[hash]!=null) {
               if (this.table[hash].containsString(word)) {
                    return true;
               }
          }
          return false;
     }

     /**
     Method Name: size

     Purpose: This method returns the current size of this MyHashMap. Size, as opposed to capacity, is the number of
     Node entries that are currently hashed and stored.

     Parameters: None

     Calls On: None

     Returns: int – the current size of this MyHashMap
     **/
     public int size() {
          int size = 0;
          for (int i = 0; i < this.capacity; i++) {
               LinkedList entry = this.table[i];
               if (entry!=null) {
                    Node current = entry.getHead();
                    while (current!=null) {
                         size++;
                         current = current.getPointer();
                    }
               }
          }
          return size;
     }

     public int capacity() { return this.capacity; }

     /**
     Method Name: printTable

     Purpose: This method prints out a String representation of this MyHashMap in the following format:
              Index 0: null                          // example of null bucket
              Index 1: HeadNode -> SecondNode        // example of collision
              Index 2: HeadNode
               .
               .
               .
              etc.

     Parameters: None

     Calls On: None

     Returns: None
     **/
     public void printTable() {
          for (int i = 0; i < this.capacity; i++) {
               System.out.println("Index "+i+": "+this.table[i]);
          }
     }

     /* –––– FOR TESTING PURPOSES ONLY; DO NOT GRADE –––– */
     /*|*/public double empty() {                      /*|*/
     /*|*/double empty = 0.00;                         /*|*/
     /*|*/for (int i = 0; i < this.capacity; i++) {    /*|*/
     /*|*/     if (this.table[i]==null) {              /*|*/
     /*|*/          empty++;                           /*|*/
     /*|*/     }                                       /*|*/
     /*|*/}                                            /*|*/
     /*|*/empty = empty - this.capacity() + this.size();
     /*|*/empty = Math.round(empty/this.size()*100);   /*|*/
     /*|*/return empty;                                /*|*/
     }                                                 /*|*/
     /* –––– FOR TESTING PURPOSES ONLY; DO NOT GRADE –––– */

}
