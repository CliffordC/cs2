public class DictCell<K extends Comparable<K>,V> {

  //Fields
  K key;
  V value;
  DictCell<K,V> prev;
  DictCell<K,V> next;

  public DictCell(){
    key = null;
    value = null;
    prev = null;
    next = null;
  }

  public V getValue(){
    return value;
  }

  public void setValue(V v){
    value = v;
  }

  public void setKey(K k){
    key = k;
  }

  public K getKey(){
    return key;
  }

  public DictCell<K,V> getNext(){
    return next;
  }

  public DictCell<K,V> getPrev(){
    return prev;
  }

  public void setNext(DictCell<K,V> dc){
    next = dc;
  }

  public void setPrev(DictCell<K,V> dc){
    prev = dc;
  }

}
