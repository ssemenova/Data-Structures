/*
* Class MyQueue implements a queue using an array.
*
*/
public class MyQueue<E> {
  private E[] queue;
  private int front;
  private int rear;
  private int size;
  private int count;

  /*
  * Constructor for a MyQueue object
  */
  public MyQueue() {
    queue = (E[]) new Object[10];
    front = 0;
    rear = 0;
    size = 0;
    count = 0;
  }

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

  public E dequeue(){
    E x = queue[front];

    if (front == queue.length - 1)
      front = 0;
    else
      front++;

    size--;

    return x;
  }

  public E front() {
    return queue[front];
  }

  public int size() {
    return size;
  }

  public Boolean empty() {
    return (size == 0);
  }

  public int count() {
    return count;
  }
}
