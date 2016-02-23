/**
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/
import java.util.NoSuchElementException;

/**
* MyLinkedList is a data structure comprising of nodes that contain values and link to the next node.
*/
public class MyLinkedList<E> {
  private MyNode head;
  private MyNode tail;
  private MyNode current;
  private int size;

  /**
  * @param: none
  * The constructor for this object sets head, tail, and current equal to null and size to 0, which means the list is empty.
  */
  public MyLinkedList() {
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
      } else {
        lastNode = current;
        tail = null;
        head = null;
        current = null;
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
}
