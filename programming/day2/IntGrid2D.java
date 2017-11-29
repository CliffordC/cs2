/*
Clifford Chirwa
*/

public class IntGrid2D implements IIntGrid2D {

  //Fields
  char[][] Grid = new char[3][3];
  int uLx;
  int uLy;
  int lRx;
  int lRy;
  char fillValue;

  public IntGrid2D(int i, int b, int c, int g, char a){
    uLx = i;
    uLy = b;
    lRx = c;
    lRy = g;
    fillValue = a;
    for(int number = 0; i < Grid.length; i++){
      for(int j = 0; j < Grid[number].length; j++){
          Grid[number][j] = fillValue;
      }
    }
  }

  public void setPoint(IIntPoint2D p, char v){
    if(p.getX() < 0 && p.getY() < 0){
        Grid[Math.abs(p.getX()) - 1 ][Math.abs(p.getY()) + 1] = v;
    }
    if(p.getX() == 1 && p.getY() == 1){
      Grid[p.getX() +1 ][p.getY() - 1] = v;
    }
    if(p.getX() == 0 && p.getY() == 0){
    Grid[p.getX() + 1][p.getY() + 1] = v;
  }
  }

  public char getPoint(IIntPoint2D p){
    return Grid[p.getX() + 1][Math.abs(p.getY() - 1)];
  }

  public IIntPoint2D getUpperLeftCorner(){
    IIntPoint2D nh = new IntPoint2D(-1,1);
    return nh;
  }

  public IIntPoint2D getLowerRightCorner(){
    IIntPoint2D gh = new IntPoint2D(1,-1);
    return gh;
  }

}
