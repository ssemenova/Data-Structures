import java.util.NoSuchElementException;

/*
* Class MyStack implements a stack using a linked list.
* It has the methods push, pop, empty, top, and size as the standard stack methods.
* The reason I've chosen to implement it with a linked list
* is because our stack needs to be able to handle any arbitrary amount of values in it
* and a linked list is more scalable than an array.
* It uses generic data types to handle different data types.
*/
public class MyStack<E> {
  private MyLinkedList<E> stack;
  private int size;

    /**
    * @param: none
    * The constructor creates a new stack and sets its size as 0.
    */
    public MyStack() {
      stack = new MyLinkedList<E>();
      size = 0;
    }

    /**
    * @param: none
    * @return: boolean
    * Running time: O(1)
    * Returns if the stack is empty
    */
    public boolean empty() {
        return size == 0;
    }

    /**
    * @param: E
    * @return: void
    * Running time: O(1)
    * Pushes the item specified onto the top of the stack and increments size
    */
    public void push(E item) {
      size++;
      stack.insert(item);
    }

    /**
    * @param: none
    * @return: E
    * Running time: O(1)
    * Pops the element at the top of the stack and decrements size.
    * Returns the element
    */
    public E pop() throws NoSuchElementException{
      if(empty())
        throw new NoSuchElementException("Cannot pop from empty stack");
      else
        size--;
        return stack.deleteLast();
    }

    /**
    * @param: none
    * @return: int
    * Running time: O(1)
    * returns size of the stack
    */
    public int size(){	//O(1)
        return size;
    }
}
