//Clifford Chirwa
//Selection Sort

public class SelectSort<T extends Comparable> implements ISort<T>{

  public void sort(T[] in){ //Takes an array in!!!!
    for(int i = 0; i < in.length - 1; i++){
      int first = i;
      for(int j = i + 1; j < in.length; j++){
        if(in[j].compareTo(in[first]) < 0 ){ //if one item is less than the other
          first = j; //matches the index
          T holder = in[first]; //Holds the lesser value
          in[first] = in[i]; //Swaps the indexed values
          in[i] = holder; //places the lesser value at the index before the one it used to be
        }
      }
    }
  }

  public String sortName(){
    return "Selection sort has been completed!";
  }
}
