/**
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/

/**
* MyNode is an implementation of a node. A node has a value (the data in the node) and a pointer to either another node or null.
* This is used by my linked list and circular linked list objects.
*/
public class MyNode<E> {
  private E value;
  public MyNode next;

  /**
  * @param: E
  * Running time: O(1)
  * Constructor initializes a new node with the value that is specified and a pointer to null
  */
  public MyNode(E value) {
    this.value = value;
    next = null;
  }

  /**
  * @param: none
  * Running time: O(1)
  * Constructor initializes a new node with nothing in it
  */
  public MyNode() {
    value = null;
    next = null;
  }

  /**
  * @param: MyNode
  * @return: void
  * Running time: O(1)
  * Sets the pointer of the current node to the specified node
  */
  public void setNext(MyNode n) {
    next = n;
  }

  /**
  * @param: E
  * @return: void
  * Running time: O(1)
  * Sets the value of the current node to the specified value
  */
  public void setValue(E value) {
    this.value = value;
  };

  /**
  * @param: none
  * @return: MyNode
  * Running time: O(1)
  * Returns the node that the current node is pointing at
  */
  public MyNode<E> getNext() {
    return next;
  }

  /**
  * @param: none
  * @return: E
  * Running time: O(1)
  * Returns the value of the current node
  */
  public E getValue() {
    return value;
  }
}
