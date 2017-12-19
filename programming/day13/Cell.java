public class Cell<T> {

    //Fields
    T value;
    Cell<T> pointer;

    public Cell(T v, Cell<T> p){
      value = v;
      pointer = p;
    }

    public T getValue(){
      return value;
    }

    public void setValue(T v){
      value = v;
    }

    public Cell<T> getPointer(){
      return pointer;
    }

    public void setPointer(Cell<T> p){
      pointer = p;
    }

    public Cell<T> getNext(){
      return pointer;
    }
}
