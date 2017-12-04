public class SCell<T> implements ISLink<T>{

  //Fields
  ISLink<T> next;
  T value;

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public ISLink<T> getNext(){
    return next;
  }

  public void setNext(ISLink<T> c){
    next = c;
  }
}
