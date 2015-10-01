import java.util.NoSuchElementException;

/*
*/
public class MyLinkedList<E> {
  private MyNode head;

  public LinkList() {
    head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insert(int d1, double d2) {
    MyNode link = new MyNode(d1, d2);
    link.nextLink = head;
    head = link;
  }

  public MyNode delete() {
    MyNode temp = head;
    head = head.nextLink;
    return temp;
  }
}
