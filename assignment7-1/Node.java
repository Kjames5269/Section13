/**
Anon

Assignment 6 – Node Class, CSC 210, Fall 2017

Purpose: This class serves as the builder for the LinkedList class.

Inherits From: None

Instance Variables:
     value - a Double that represents the value of this Node
     word – a String that represents the word for this Node
     pointer – the Node that this one points to

Constructors: Each Node must be constructed with a String and a Double. The pointer can only be set after construction.
**/

public class Node {

/* Instance Variables */

     private String word;
     private Double value;
     private Node pointer;

/* Constructors */

     public Node(String word, Double value) {
          this.value = value; this.word = word;
     }

/* Instance Methods */

     /* The only methods written for this class are accessors, mutators, and toString(). Every method is basically
     self-explanatory and contains no more than two lines of code, so no additional documentation has been been
     written. */

     public void setValue(Double value) { this.value = value; }
     public Double getValue() { return this.value; }

     public void setWord(String word) { this.word = word; }
     public String getWord() { return this.word; }

     public void setPointer(Node node) { this.pointer = node; }
     public Node getPointer() {
          if (this.pointer!=null) { return this.pointer; }
          else { return null; }
     }

     public String toString() {
          return "("+this.word+","+this.value+")";
     }

}
