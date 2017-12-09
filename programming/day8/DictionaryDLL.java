public class DictionaryDLL<K extends Comparable<K>,V> {

  //Fields
  int current;
  int listSize;
  DictCell<K,V> head;
  DictCell<K,V> tail;

  public DictionaryDLL(){
    head = null;
    tail = null;
  }

  public void insert(int idx, K k,V v){
    DictCell<K,V> node = new DictCell();
    DictCell<K,V> after = null;
    node.setValue(v);
    if(listSize == idx){
      append(k,v);
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
      DictCell<K,V> before = after.getPrev();
      before.setKey(k);
      before.setNext(node);
      after.setPrev(node);
      node.setNext(after);
      node.setPrev(before);
    }
    listSize++;
  }

  public void append(K k, V v){
    DictCell<K,V> node = new DictCell();
    node.setValue(v);
    node.setKey(k);
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
  }

  public void remove(){
    remove(current);
    prev();
  }

  public void remove(int idx){
    DictCell<K,V> after = null;
    DictCell<K,V> delete = null;
    DictCell<K,V> before = null;
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

  public void remove(K k){
    DictCell<K,V> after = null;
    DictCell<K,V> delete = null;
    DictCell<K,V> before = null;
    for( int i = 0; i <= listSize; i++){
      if( i == 0){
        delete = head;
      }
      else{
      delete = delete.getNext();
      }
    }
    if(listSize == 0){
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
    if(current > listSize){
      current--;
    }
    listSize--;
  }

  public void move(int sidx, int didx){
    DictCell<K,V> dude = null;
    for(int i = 0; i <= sidx ; i++){
      if(i == 0){
        dude = head;
      }
      else{
        dude = dude.getNext();
      }
    }
    remove(sidx);
    insert(didx, dude.getKey(),dude.getValue());
  }

  public V fetch(){
    DictCell<K,V> fetched = null;
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

  public K fetch(int idx){
    DictCell<K,V> fetched = null;
    for(int i = 0; i <= idx ; i++){
      if(i == 0){
        fetched = head;
      }
      else{
        fetched = fetched.getNext();
      }
    }
    return fetched.getKey();
  }

  public V fetch(K k){
    DictCell<K,V> fetched = null;
    for(int i = 0; i <= listSize ; i++){
      if(i == 0){
        fetched = head;
      }
      else if(fetched.getKey().compareTo(k) == 0){
        return fetched.getValue();
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

  public int getSize(){
    return listSize;
  }

}
