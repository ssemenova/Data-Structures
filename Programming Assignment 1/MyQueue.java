/**
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/

/**
* MyQueue is a queue implemented with an array (because Antonella said to implement it with an array).
* Queues are useful data structures when you need a data structure that will let you only remove items from the front
* and only add items to the end.
*/
public class MyQueue<E> {
  private E[] queue;
  private int front;
  private int rear;
  private int size;
  private int count;

  /**
  * @param: none
  * Running time: O(1)
  * Constructor initializes all variables to 0 and creates a new queue.
  */
  public MyQueue() {
    queue = (E[]) new Object[10];
    front = 0;
    rear = 0;
    size = 0;
    count = 0;
  }

  /**
  * @param: E
  * @return: void
  * Running time: O(1)
  * Adds the item to the back of the queue, increments size and count
  */
  public void enqueue(E item) {
    queue[rear] = item;

    if (rear == queue.length - 1) {
      rear = 0;
    } else {
      rear++;
    }

    count++;
    size++;
  }

  /**
  * @param: none
  * @return: E
  * Running time: O(1)
  * Removes the item at the front of the queue and returns it
  */
  public E dequeue(){
    E x = queue[front];

    if (front == queue.length - 1)
      front = 0;
    else
      front++;

    size--;

    return x;
  }

  /**
  * @param: none
  * @return: E
  * Running time: O(1)
  * Returns the item at the front of the queue without dequeueing it
  */
  public E front() {
    return queue[front];
  }

  /**
  * @param: none
  * @return: int
  * Running time: O(1)
  * returns size of the queue
  */
  public int size() {
    return size;
  }

  /**
  * @param: none
  * @return: boolean
  * Running time: O(1)
  * Returns if the queue is empty
  */
  public Boolean empty() {
    return (size == 0);
  }

  /**
  * @param: none
  * @return: int
  * Running time: O(1)
  * Returns the amount of items that have ever been added to the queue
  */
  public int count() {
    return count;
  }
}
