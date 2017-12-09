public class Dict<K extends Comparable<K>,V> implements IDict<K,V> {

    //Fields
    DictionaryDLL<K,V> dict = new DictionaryDLL<K,V>();


    public Dict(){
      //keys = (K[])new Object[0];
    }
    /**
   * Adds a value to the dictionary, replacing the existing value if any.
   * @param k key for the new value
   * @param v value
   * @return the value replaced, otherwise null
   */
    public V add(K k, V v){
      V returnvalue = null;
      for(int i = 0; i < size(); i++){
        if(k.compareTo(dict.fetch(i)) == 0){
          returnvalue = fetch(k);
          dict.remove(i);
          dict.insert(i,k,v);
          return returnvalue;
        }
      }
      dict.append(k,v);
      return null;
    }

    //Needs more work!!!!
    public V remove(K k){
      V a = ((dict.fetch(k)));
      dict.remove(k);
       return a ;
    }


    public int size(){
      return dict.getSize();
    }


    public V fetch(K k){
      return dict.fetch(k);
    }


    public K[] keys(){
      K[] keys = (K[])new Object[dict.getSize()];
      for( int i = 0; i < dict.getSize(); i++){
        K p = dict.fetch(i);
        keys[i] = p;
      }
      return keys;
    }


}
