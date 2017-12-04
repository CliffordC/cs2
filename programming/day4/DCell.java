public class DCell<T> implements IDLink<T> {


  //Fields
  IDLink<T> previous;
  IDLink<T> next;
  T value;

  public DCell(){
    previous = null;
    next = null;
    value = null;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public IDLink<T> getNext(){
    return next;
  }

  public IDLink<T> getPrev(){
    return previous;
  }

  public void setNext(IDLink<T> c){
    next = c;
  }

  public void setPrev(IDLink<T> c){
    previous = c;
  }
}
