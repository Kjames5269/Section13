/*
* Anon
*
* Assignment #7 - LinkedList, CSc 210, Spring 2017
* This class maintains a linked list of Node objects. Nodes are used to store
* a String "key" and a double "value".
*/
public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    /*
    * add
    * Adds a Node with the given key and value to the end of this LinkedList.
    *
    * Arguments:
    * String key - the key of the Node to be added
    * double value - the value of the Node to be added
    *
    * Return Value - returns true if the added Node was not already in this
    *                LinkedList or false if the Node was already in this
    *                LinkedList
    */
    public boolean add(String key, double value) {
        if (isEmpty()) {
            head = new Node (key, value);
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.getKey().equals(key)) {
                    temp.setValue(value);
                    return false;
                }
                temp = temp.getNext();
            }
            temp = head;
            head = new Node(key, value);
            head.setNext(temp);
        }
        return true;
    }

    /*
    * remove
    * Removes a Node with the given key from this LinkedList.
    *
    * Arguments:
    * String key - the key of the Node to be removed
    *
    * Return Value - returns true if a Node was removed and false if no Node was
    *                removed
    */
    public boolean remove(String key) {
        if (isEmpty()) {
            return false;
        } else {
            if (head.getKey().equals(key)) {
                head = head.getNext();
                return true;
            } else {
                Node temp = head;
                while (temp.getNext() != null) {
                    if (temp.getNext().getKey().equals(key)) {
                        temp.setNext(temp.getNext().getNext());
                        return true;
                    }
                    temp = temp.getNext();
                }
            }
        }
        return false;
    }

    /*
    * getValue
    * Returns the value of a Node within this LinkedList given a key, but if no
    * such Node exists, then 0.0 is returned instead.
    *
    * Arguments:
    * String key - the key of the Node we want to find the value of
    *
    * Return Value - the value of a Node within this LinkedList given a key, but
    *                if no such Node exists, then 0.0 is returned instead
    */
    public double getValue(String key) {
        if (isEmpty()) {
            return 0.0;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.getKey().equals(key)) {
                    return temp.getValue();
                }
                temp = temp.getNext();
            }
        }
        return 0.0;
    }

    /*
    * contains
    * Returns true if this LinkedList contains a Node with the given key or
    * false if it does not.
    *
    * Arguments:
    * String key - the key of the Node we want to find
    *
    * Return Value - true if this LinkedList contains a Node with the given key
    *                or false if it does not
    */
    public boolean contains(String key) {
        if (isEmpty()) {
            return false;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.getKey().equals(key)) {
                    return true;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    /*
    * pop
    * Returns and removes the Node at the "head" of this LinkedList.
    *
    * Return Value - the Node at the "head" of this LinkedList
    */
    public Node pop() {
        Node temp = head;
        if (!isEmpty()) {
            head = head.getNext();
        }
        return temp;
    }

    /*
    * isEmpty
    * Returns true if this LinkedList is empty or false if it is not.
    *
    * Return Value - true if this LinkedList is empty or false if it is not
    */
    public boolean isEmpty() {
        return head == null;
    }

    /*
    * toString
    * Returns a string representation of this LinkedList.
    *
    * Return Value - a string representation of this LinkedList
    */
    public String toString() {
        String result = "";
        Node temp = head;
        while (temp != null) {
            result += temp;
            temp = temp.getNext();
        }
        return result;
    }
}
