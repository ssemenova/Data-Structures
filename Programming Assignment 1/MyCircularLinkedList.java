import java.util.NoSuchElementException;

public class MyCircularLinkedList<E> {
  private MyNode head;
  private MyNode tail;
  private MyNode current;
  private int size;

  public MyCircularLinkedList() {
    head = null;
    tail = null;
    size = 0;
    current = null;
  }

  public boolean empty() {
    return head == null;
  }

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
  public int getSize() {
    return size;
  }

  public void clear(){
      tail = null;
      head = null;
      current = null;
  }

  public MyNode getHead() {
    return head;
  }

  public E shiftNodeTo(int n) {
    if (n < 0)
      n = size + n;

    for (int i = 0; i < n; i++)
      current = current.getNext();

    E valueAtCurrent = (E) current.getValue();

    return valueAtCurrent;
  }

  public void setValueOfCurrent(E value) {
    current.setValue(value);
  }

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
