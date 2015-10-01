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

  public void shiftNodeTo(int n) {
    
  }

  public void print() {
    current = head;
    for (int i = 0; i < 6; i++) {
          System.out.println(current.getValue()+", ");
          current=current.getNext();
    }
  }

  public static void main(String[] args) {
    MyCircularLinkedList<Integer> test = new MyCircularLinkedList<Integer>();
    test.insert(1);
    test.insert(2);
    test.insert(3);
    test.print();
  }
}
