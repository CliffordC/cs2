/*
*Clifford Chirwa
*This creates the "nodes" that are referenced in the LinkQueue.java
*/
public class QueueCell<T>{

  //Fields
  T value;
  QueueCell<T> next;
  QueueCell<T> prev;

  public QueueCell(){
    value = null;
    next = null;
    prev = null;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public QueueCell<T> getNext(){
    return next;
  }

  public void setNext(QueueCell<T> p){
    next = p ;
  }

  public QueueCell<T> getPrev(){
    return prev;
  }

  public void setPrev(QueueCell<T> p){
    prev = p;
  }
}
