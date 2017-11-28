/*
* Anon
*
* Assignment #7 - Node, CSc 210, Spring 2017
* This class maintains a node that stores a String "key", a double "value", and
* a "next" pointer.
*/
public class Node {
    private String key;
    private double value;
    private Node next;

    public Node(String key, double value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    /*
    * toString
    * Returns a string representation of this Node.
    *
    * Return Value - a string representation of this Node
    */
    public String toString() {
        return "(" + key + ", " + value + ")->";
    }
}
