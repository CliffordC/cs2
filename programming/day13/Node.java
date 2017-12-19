//Clifford Chirwa
public class Node<N> implements INode<N> {
  //Fields
  N value;

  public Node(N v){ value = v;}

  public void setValue(N v){ value = v;}

  public N getValue(){return value;}
}
