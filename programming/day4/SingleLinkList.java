public class SingleLinkList<T> implements IList<T>{

  //Fields
  int current;
  int listSize;
  ISLink<T> head;
  ISLink<T> tail;

  public SingleLinkList(){
    head = null;
    tail = null;
  }
  public void insert(int idx, T v){
    ISLink<T> node = new SCell();
    ISLink<T> after = null;
    ISLink<T> before = head;
    node.setValue(v);
    if(listSize == idx){
      append(v);
    }

    if(idx == 0){
      node.setNext(before);
      head = node;
    }
    else{
      for( int i = 0; i < idx - 1   ; i++){
          before = before.getNext();
      }
      after = before.getNext();
      before.setNext(node);
      node.setNext(after);
    }
    listSize++;
  }

  public void append(T v){
    ISLink<T> node = new SCell();
    node.setValue(v);
    if(listSize == 0){
      node.setNext(node);
      tail = node;
      head = node;
    }
    else{
      node.setNext(node);
      tail.setNext(node);
      tail = node;
    }
    listSize++;
    current = listSize - 1;
  }

  public void remove(){
    remove(current);
    prev();
  }

  public void remove(int idx){
    ISLink<T> after = null;
    ISLink<T> delete = head;
    for( int i = 0; i < idx -1  ; i++){
        delete = delete.getNext();
    }

    if(idx == 0){
      after = delete.getNext();
      head = after;
    }
    else{
      after = delete.getNext().getNext();
      delete.setNext(after);
    }

    if(current > idx){
      current--;
    }
    listSize--;
  }

  public void move(int sidx, int didx){
    ISLink<T> dude = null;
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
    ISLink<T> fetched = null;
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
    ISLink<T> fetched = null;
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
  public static void debugPrint(IList l) {
        for(int i=0; i<l.size(); i++) {
            System.out.println(i+": "+l.fetch(i));
        }
    }

  public static void main(String[] args){
    IList<Integer> slist = new SingleLinkList<Integer>();
    for(int i = 1; i <= 4; i++){
      slist.append(i);
    }
    //System.out.println(slist.fetch(1));
    debugPrint(slist);
    slist.insert(1,14);
    slist.move(1,4);
    slist.remove(1);
    System.out.println(slist.fetch(4));
    debugPrint(slist);
    //slist.remove(0);
  //  System.out.println(slist.fetch(0));

  }

}
