/**
Anon

Assignment 6 – LinkedList Class, CSC 210, Fall 2017

Purpose: This class serves as the builder for the MyHashTable class.

Inherits From: None

Instance Variables:
     head – a Node that is the current first element of this LinkedList
     length – an Integer that is current length of this LinkedList

Constructors: Each LinkedList can be constructed with or without a head Node.
**/

public class LinkedList {

/* Instance Variables */

     private Node head = null;
     private Integer length = 0;

/* Constructors */

     public LinkedList() {}

     public LinkedList(Node node) {
          this.head = node; this.length++;
     }

/* Instance Methods */

     public void setHead(Node node) {
          if (this.isEmpty()) { this.head = node; this.length++; }
          else { System.err.println("empty list before setting head"); }
     }

     public Node getHead() {
          if (this.head!=null) { return this.head; }
          else { System.err.println("cannot return head; list is empty");
               return null; }
     }

     public int getLength() { return this.length; }

     public boolean isEmpty() { return (this.length==0); }

     /**
     Method Name: append

     Purpose: This method appends a specified Node to the end of this LinkedList. If this LinkedList is empty, then the
     Node is set as the head.

     Parameters:
          node – the Node to be appended to this LinkedList

     Calls On: isEmpty, setHead

     Returns: None
     **/
     public void append(Node node) {
          if (this.isEmpty()) { this.setHead(node); }
          else {
               Node current = this.head;
               while (current.getPointer()!=null) {
                    current = current.getPointer();
               }
               current.setPointer(node); this.length++;
          }
     }

     /**
     Method Name: remove

     Purpose: This method removes a specified Node from this LinkedList. If the LinkedList is empty or does not contain
     the Node to be removed, an error message is printed.

     Parameters:
          node – the Node to be removed from this LinkedList

     Calls On: containsString

     Returns: None
     **/
     public void remove(Node node) {
          if (this.head==null) { System.err.println("cannot remove; list is empty"); }
          else if (!this.containsString(node.getWord()))
               { System.err.println("cannot remove; node not in list"); }
          else if (node.getWord().equals(this.head.getWord()))
               { this.head = this.head.getPointer(); node.setPointer(null); this.length--; }
          else {
               Node current = this.head;
               while (current.getPointer()!=node) {
                    current = current.getPointer();
               }
               current.setPointer(node.getPointer());
               node.setPointer(null); this.length--;
          }
     }

     /**
     Method Name: containsString

     Purpose: This method is used to determine if this LinkedList currently has a Node with a particular String as its
     instance variable.

     Parameters:
          word – the String that is to be checked

     Calls On: None

     Returns: boolean – true if there is a Node in this LinkedList with String word as its instance variable, false
     otherwise
     **/
     public boolean containsString(String word) {
          if (this.length==0) { return false; }
          else {
               Node current = this.head;
               while (current!=null) {
                    if (current.getWord().equals(word)) { return true; }
                    current = current.getPointer();
               } return false; }
     }

     /**
     Method Name: findString

     Purpose: This method is used to find the Node in this LinkedList with a particular String as its instance variable.

     Parameters:
          word – the String that is to be checked

     Calls On: containsString

     Returns: Node – the Node in this LinkedList that has String word as its instance variable. If no Node in this
     LinkedList contains String word, then a null Node is returned.
     **/
     public Node findString(String word) {
          if (this.containsString(word)) {
               Node current = this.head;
               while (current!=null) {
                    if (current.getWord().equals(word)) {
                         return current;
                    }
                    current = current.getPointer();
               }
          }
          return null;
     }

     /**
     Method Name: toString

     Purpose: This method overrides the toString() method from the Object superclass.

     Parameters: None

     Calls On: None

     Returns: String – the representation of this LinkedList in its current form in the following format:
                       HeadNode -> SecondNode -> ... -> LastNode
     **/
     public String toString() {
          if (this.isEmpty()) { return "null"; }
          else {
               String list = "";
               Node current = this.head;
               while (current.getPointer()!=null) {
                    list += current.toString()+" -> ";
                    current = current.getPointer();
               }
               list += current;
               return list;
          }
     }

}
