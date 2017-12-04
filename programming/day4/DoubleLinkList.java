public class DoubleLinkList<T> implements IList<T> {

  //Fields
  int current;
  int listSize;
  IDLink<T> head;
  IDLink<T> tail;

  public DoubleLinkList(){
    head = null;
    tail = null;
  }

  public void insert(int idx, T v){
    IDLink<T> node = new DCell();
    IDLink<T> after = null;
    node.setValue(v);
    if(listSize == idx){
      append(v);
    }
    else{
      for( int i = 0; i <= idx; i++){
        if( i == 0){
          after = head;
        }
        else{
        after = after.getNext();
        }
      }
      IDLink<T> before = after.getPrev();
      before.setNext(node);
      after.setPrev(node);
      node.setNext(after);
      node.setPrev(before);
    }
    listSize++;
  }

  public void append(T v){
    IDLink<T> node = new DCell();
    node.setValue(v);
    if(listSize == 0){
      node.setPrev(node);
      node.setNext(node);
      tail = node;
      head = node;
    }
    else{
      node.setPrev(tail);
      node.setNext(node);
      tail.setNext(node);
      tail = node;
    }
    listSize++;
    current = listSize - 1;
  //  System.out.println(v);
  }

  public void remove(){
    remove(current);
    prev();
  }

  public void remove(int idx){
    IDLink<T> after = null;
    IDLink<T> delete = null;
    IDLink<T> before = null;
    for( int i = 0; i <= idx; i++){
      if( i == 0){
        delete = head;
      }
      else{
      delete = delete.getNext();
      }
    }
    if(idx == 0){
      after = delete.getNext();
      after.setPrev(after);
      head = after;
    }
    else{
      after = delete.getNext();
      before = delete.getPrev();
      before.setNext(after);
      after.setPrev(before);
    }
    if(current > idx){
      current--;
    }
    listSize--;
  }

  public void move(int sidx, int didx){
    IDLink<T> dude = null;
    for(int i = 0; i <= sidx ; i++){
      if(i == 0){
        dude = head;
      }
      else{
        dude = dude.getNext();
      }
    }
    remove(sidx);
    insert(didx, dude.getValue());
  }

  public T fetch(){
    IDLink<T> fetched = null;
    for(int i = 0; i <= current ; i++){
      if(i == 0){
        fetched = head;
      }
      else{
        fetched = fetched.getNext();
      }
    }
    return fetched.getValue();
  }

  public T fetch(int idx){
    IDLink<T> fetched = null;
    for(int i = 0; i <= idx ; i++){
      if(i == 0){
        fetched = head;
      }
      else{
        fetched = fetched.getNext();
      }
    }
    return fetched.getValue();
  }

  public void next(){
    if(current < listSize - 1){
      current++;
    }
  }

  public void prev(){
    if( current > 0){
      current--;
    }
  }

  public void jumpToTail(){
    current = listSize - 1;
  }

  public void jumpToHead(){
    current = 0;
  }

  public int size(){
    return listSize;
  }
  // public static void main(String[] args){
  //   IList<Integer> doublelist = new DoubleLinkList<Integer>();
  //   for(int i = 0; i < 3; i++){
  //     doublelist.append(i);
  //   }
  //   doublelist.insert(1,2);
  // }
}
