/**
*Clifford Chirwa
*ArrayList!
*/

public class ArrayList<T> implements IList<T> {

  //Fields
  T[] _arrayList;
  int front = 0;
  int back = 0;
  int current = 0;
  T placeVal;

  public ArrayList(){
    _arrayList = (T[])new Object[0];
  }

  public void insert(int idx, T v){
    T[] _tempArray = (T[])new Object[_arrayList.length + 1];
    for(int i = 0; i < _arrayList.length+1; i++){
      if( i == idx){
        _tempArray[idx] = v;
      }
      else if(i > idx){
        _tempArray[i] = _arrayList[i - 1];
      }
      else{
        _tempArray[i] = _arrayList[i];
      }
    }
    _arrayList = _tempArray;
  }

  public void append(T v){
      T[] _tempArray = (T[])new Object[_arrayList.length + 1];
      for(int i = 0; i < _arrayList.length; i++){
        _tempArray[i] = _arrayList[i];
      }
      current = _arrayList.length - 1;
      _tempArray[_tempArray.length - 1] = v;
      _arrayList = _tempArray;
  }

  public void remove(){
    T[] _tempArray = (T[])new Object[_arrayList.length - 1];
    remove(current);
    if(current == 0){
      current =0;
    }
    else{
      current--;
    }
  }

  public void remove(int idx){
    T[] _tempArray = (T[])new Object[_arrayList.length - 1];
    for(int i = _arrayList.length - 1; i > -1; i--) {
        if(i == idx) {
        }
        else if(i < idx) {
            _tempArray[i] = _arrayList[i];
        }
        else {
            _tempArray[i - 1] = _arrayList[i];
        }
    }
    _arrayList = _tempArray;
  }

  public void move(int sidx, int didx){
    placeVal = _arrayList[sidx];
    remove(sidx);
    insert(didx, placeVal);
  }

  public T fetch(){
    return _arrayList[current];
  }

  public T fetch(int idx){
    return  _arrayList[idx];
  }

  public void next(){
    if(current < (_arrayList.length - 1)){
      current++;
    }
  }

  public void prev(){
    if(current > 0){
      current--;
    }
  }

  public void jumpToTail(){
    current = _arrayList.length - 1;
  }

  public void jumpToHead(){
    current = 0;
  }

  public int size(){
    int t = _arrayList.length;
    return t;
  }

  public void debug(){
    for(T e : _arrayList)
      System.out.println(e);
  }

  public static void main(String[] args){
    ArrayList jk = new ArrayList();
    for(int i = 0; i < 10; i++){
      jk.append(i);
    }
    jk.remove(2);
    jk.debug();
    jk.insert(2,2);
    jk.debug();
    //System.out.println(jk.fetch(2));
  }

}
