//Clifford Chirwa

public class IntPoint2D implements IIntPoint2D{

  int x;
  int y;

  public IntPoint2D(int _x, int _y){
      x = _x;
      y = _y;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public int manhattanDistance(IIntPoint2D o){
    int distance = Math.abs(x - o.getX()) + Math.abs(y - o.getY());
    return distance;
  }

  public double distance(IIntPoint2D o){
    double d = x - o.getX();
    double dd = Math.pow(d,2);
    double h = y - o.getY();
    double hh = Math.pow(h,2);
    double umm = Math.sqrt(dd + hh);
    return umm;
  }

  public String toString(){
    return ("(" + x + ","+ y + ")");
  }

  public boolean equals(IIntPoint2D o){
    if(x == o.getX()){
      return true;
    }
    else if(y == o.getY()){
      return true;
    }
    else{
      return false;
    }
  }

  public int hashcode(){
    int h = (x << 16) + y;
    return h;
  }


}
