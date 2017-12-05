//This is the same exact queue implementation that was given to us in queue.zip
//The one I made is the one called LinkQueue.java
//This one works by making use of arrays.
public class Queue<T> implements IQueue<T>{

  //Fields
  int size;
  T[] queue;

  public Queue(int s){
    size = 0;
    queue = (T[])new Object[s];
  }

  public T dequeue() throws UnderFlowException{
    if(size == 0) { throw new UnderFlowException(); }
    T r = queue[0];
    for(int i = 1; i<size; i++) {
        queue[i-1] = queue[i];
    }
    size--;
    return r;
  }

  public void enqueue(T v) throws OverFlowException{
    if(size == queue.length) { throw new OverFlowException(); }
    queue[size] = v;
    size++;
  }

  public static void main(String[] args){
  }
}
