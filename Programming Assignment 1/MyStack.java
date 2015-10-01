import java.util.NoSuchElementException;

/*
* Class MyStack implements a stack using an array.
* It has the methods push, pop, empty, top, and size as the standard stack methods,
* as well as increaseSize in the case that the user tries to add more elements than the array has room for.
* It uses generic data types to handle different data types.
*/
public class MyStack<E> {
  private MyLinkedList<E> stack;
  private int size;

    /*
    * Constructor for a MyStack object
    */
    public MyStack() {
      stack = new MyLinkedList<E>();
      size = 0;
    }


    public boolean empty(){	//O(1)
        return size == 0;
    }

    public void push(E item) {
      size++;
      stack.insert(item);
    }

    public E pop() throws NoSuchElementException{
      if(empty())
        throw new NoSuchElementException("Cannot pop from empty stack");
      else
        size--;
        return stack.deleteLast();
    }

    public int size(){	//O(1)
        return size;
    }

    public void clear(){    //O(1)
        stack.clear();
    }
}
