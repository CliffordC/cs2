/*
*Clifford Chirwa
*Organizes "node" objects.
*/
public class LinkQueue<T> implements IQueue<T>{

  //Fields
  QueueCell<T> first;
  QueueCell<T> last;
  int size;

  public T dequeue() throws UnderFlowException{
    if(size == 0){throw new UnderFlowException();}
    T turkey = first.getValue(); //saves the value
    first = first.getNext();//first is now the node after the one saved in turkey
    size--;
    return turkey;
  }

  public void enqueue(T v) throws OverFlowException{
    QueueCell<T> node = new QueueCell(); //creates the new node
    node.setValue(v);//sets the value for the node.
    if(size == 0){
      node.setPrev(null);
      node.setNext(null);
      first = node;
      last = node;
    }
    else{
      node.setPrev(last);
      node.setNext(null);
      last.setNext(node);
      last = node;
    }
    size++;
  }

}
