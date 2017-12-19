//This method is the same as the one made together in class. With minor changes.
//Clifford Chirwa
public class Stack<T> implements IStack<T> {

    //Fields
    Cell<T> top;
    int size;

    public Stack(){
      top = null;
      size = 0;
    }
    public void push(T v){
      Cell<T> newNode = new Cell<T>(v, top);
      top = newNode;
      size++;
    }

    public T pop(){
      // if(size == 0){throw new UnderFlowException();}
      T v = top.getValue();
      top = top.getNext();
      size--;
      return v;
    }
    public int size(){return size;}

    public Cell<T> top(){return top;}

}
