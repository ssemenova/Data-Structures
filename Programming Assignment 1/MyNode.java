/*
*/
public class MyNode<E> {
  private E value;
  public MyNode next;

  public MyNode(E value) {
    this.value = value;
    next = null;
  }

  public MyNode() {
    value = null;
    next = null;
  }

  public void setNext(MyNode n) {
    next = n;
  }

  public void setValue(E value) {
    this.value = value;
  };

  public MyNode<E> getNext() {
    return next;
  }

  public E getValue() {
    return value;
  }
}

// /**
//  * Created by Seth on 9/30/2015.
//  */
// public class MyNode<E> {
//     public MyNode next;
//     public E data;
//
//     public MyNode(){
//         this(null);
//     }
//
//     public MyNode(E data){
//         next = null;
//         this.data=data;
//     }
//
//     public E getData(){
//         return this.data;
//     }
//
//     public MyNode getNext(){
//         return this.next;
//     }
//
//     public void setData(E data){
//         this.data=data;
//     }
//
//     public void setNext(MyNode next){
//         this.next=next;
//     }
//
//     public String toString(){
//         return ""+data;
//     }
// }
