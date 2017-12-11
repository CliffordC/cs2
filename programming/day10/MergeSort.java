//Clifford Chirwa
//Merge Sort!!!

public class MergeSort<T extends Comparable> implements ISort<T>{

  //Fields
  int left;
  int right;
  int mid;

  public MergeSort(){
    left = 0;
    right = 0;
    mid = 0;
  }

  public void sort(T[] in){
    left = 0;
    right = in.length - 1;
    sort(in,left,right);
  }

  public void sort(T[] in, int m, int r){
    left = m;
    right = r;
    if(left < right){ //Creates two halves to be sorted
      mid = ((left + right) / 2);
      sort(in,left,mid);
      sort(in, mid + 1, right);
      merge(in, left, mid, right);
    }
  }

  public void merge(T[] in, int left, int mid, int right){
    int halfOne = mid - left + 1;
    int halfTwo = right - mid;
    T[] leftArr = (T[])new Comparable[halfOne];
    T[] rightArr = (T[])new Comparable[halfTwo];
    for(int i = 0; i < halfOne; i++){
      leftArr[i] = in[left + 1];
    }
    for(int k = 0; k < halfTwo; k++){
      rightArr[k] = in[mid + k + 1];
    }
    int smallerArray = 0;
    int secondSmallerArray = 0;
    int lefHolder = left;
    while(smallerArray < halfOne && secondSmallerArray < halfTwo){
      if(leftArr[smallerArray].compareTo(rightArr[secondSmallerArray]) == 0 && leftArr[smallerArray].compareTo(rightArr[secondSmallerArray]) > 0){
        in[lefHolder] = leftArr[smallerArray];
        smallerArray++;
        lefHolder++;
      }
      else{
        in[lefHolder] = rightArr[secondSmallerArray];
        secondSmallerArray++;
        lefHolder++;
      }
    }

  }

  public String sortName(){
    return "Merge sort has been completed!";
  }


}
