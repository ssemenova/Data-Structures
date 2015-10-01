import java.util.NoSuchElementException;

/*
* Class MyStack implements a stack using an array.
* It has the methods push, pop, empty, top, and size as the standard stack methods,
* as well as increaseSize in the case that the user tries to add more elements than the array has room for.
* It uses generic data types to handle different data types.
*/
public class MyStack<E> {
  private E[] stack;
  private int size;

  /*
  * Constructor for a MyStack object
  */
  public MyStack() {
    stack = (E[]) new Object[10];
    size = 0;
  }

  //O(1)
  /*
  *
  */
  public void push(E item) {
    if (size() == stack.length - 1)
      increaseSize();

    size++;
    stack[size] = item;
  }

  public E pop() throws NoSuchElementException{
    if(empty())
      throw new NoSuchElementException("Cannot pop from empty stack");
    else {
      size--;
      return stack[size + 1];
    }
  }

  //O(1)
  public Boolean empty() {
    return (size == 0);
  }

  //O(1)
  public E top() {
    return stack[size - 1];
  }

  //O(1)
  public int size() {
    return size;
  }

  public void increaseSize() {
    E[] stack2 = (E[]) new Object[stack.length * 2];
    System.arraycopy(stack, 0, stack2, 0, stack.length);

    stack = stack2;
  }
}
