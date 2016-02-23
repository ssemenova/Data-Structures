/**
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/
import java.util.NoSuchElementException;

/**
* MyCircularLinkedList is a data structure that is almost the same as linked list
* but the tail always points to the head, so there are never any null pointers (or "end" of the list).
* This data structure is useful when index does not matter but order does, and you want to easily traverse the linked list
* without worrying about hitting an end.
*/
public class MyCircularLinkedList<E> {
  private MyNode head;
  private MyNode tail;
  private MyNode current;
  private int size;

  /**
  * @param: none
  * The constructor for this object sets head, tail, and current equal to null and size to 0, which means the list is empty.
  */
  public MyCircularLinkedList() {
    head = null;
    tail = null;
    size = 0;
    current = null;
  }

  /**
  * @param: none
  * @return: boolean
  * Running time: O(1)
  * Returns if the list is empty
  */
  public boolean empty() {
    return head == null;
  }

  /**
  * @param: none
  * @return: void
  * Running time: O(1)
  * Inserts a value at the tail
  */
  public void insert(E value) {
    MyNode<E> newNode = new MyNode<E>(value);

    if (head == null) {
      current = newNode;
      tail = newNode;
      head = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }

    tail.setNext(head);
    size++;
  }

  /**
  * @param: none
  * @return: E
  * Running time: O(1)
  * Deletes the node at the head and resets the head to the next node
  */
  public E deleteFirst() {
    if (head != null) {
      MyNode<E> firstNode = head;
      head = head.getNext();
      current = current.getNext();
      tail.setNext(head);
      return firstNode.getValue();
    } else {
      System.out.println("List is empty!");
      return null;
    }
  }

  /**
  * @param: none
  * @return: E
  * Running time: O(n) where n is the size of the linked list
  * Deletes the node at the tail and returns that node
  */
  public E deleteLast() {
    MyNode<E> lastNode;
    current = head;

    if (head != null) {
      if(current.getNext() != null) {
        while (current.getNext().getNext() != null)
          current = current.getNext();
        lastNode = current.getNext();
        tail = current;
        current.setNext(null);
        current = head;
        tail.setNext(head);
      } else {
        lastNode = current;
        tail = null;
        head = null;
        current = null;
        tail.setNext(head);
      };

      size--;
      return lastNode.getValue();
    } else {
      System.out.println("List is empty!");
      return null;
    }
  }

  /**
  * @param: none
  * @return: int
  * Running time: O(1)
  * returns the size of the list
  */
  public int getSize() {
    return size;
  }

  /**
  * @param: none
  * @return: void
  * Running time: O(1)
  * clears the list
  */
  public void clear(){
      tail = null;
      head = null;
      current = null;
  }

  /**
  * @param: none
  * @return: MyNode
  * Running time: O(1)
  * returns the node that is at the head of the list
  */
  public MyNode getHead() {
    return head;
  }

  /**
  * @param: int
  * @return: E
  * Running time: O(n) where n is the amount of indexes to move
  * Sets current to be n spaces away from where it currently is
  * and returns the value at that node
  */
  public E shiftNodeTo(int n) {
    if (n < 0)
      n = size + n;

    for (int i = 0; i < n; i++)
      current = current.getNext();

    E valueAtCurrent = (E) current.getValue();

    return valueAtCurrent;
  }

  /**
  * @param: E
  * @return: void
  * Running time: O(1)
  * sets the value of the current node to the specified value
  */
  public void setValueOfCurrent(E value) {
    current.setValue(value);
  }

  /**
  * @param: none
  * @return: String
  * Running time: O(n) where n is the length of the list
  * Returns a formatted string representation of the list
  */
  public String toString() {
    current = head;

    String s = "[";

    while (current != tail) {
        s += current.getValue() + ", ";
        current = current.getNext();
    }
    s += current.getValue();
    current = head;
    return s + "]";
  }
}
