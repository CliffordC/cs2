public class DCell<N> implements IDLink<N> {


  //Fields
  IDLink<N> previous;
  IDLink<N> next;
  N value;

  public DCell(){
    previous = null;
    next = null;
    value = null;
  }

  public N getValue(){
    return value;
  }

  public void setValue(N v){
    value = v;
  }

  public IDLink<N> getNext(){
    return next;
  }

  public IDLink<N> getPrev(){
    return previous;
  }

  public void setNext(IDLink<N> c){
    next = c;
  }

  public void setPrev(IDLink<N> c){
    previous = c;
  }
}
