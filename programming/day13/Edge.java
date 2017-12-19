//Clifford Chirwa
public class Edge<N,W> implements IEdge<N,W> {

    //Fields
    W weight;
    INode<N> nodeBefore;
    INode<N> nodeAfter;

    public Edge(INode<N> source, INode<N> dest, W weigh){
      weight = weigh;
      nodeBefore = source;
      nodeAfter = dest;
    }

    public INode<N> getSource(){ return nodeBefore;}

    public INode<N> getDestination(){ return nodeAfter;}

    public W getWeight(){ return weight;}

    public boolean equals(Object o){
      Edge d = (Edge) o;
      if(nodeAfter.equals(d.getDestination()) && nodeBefore.equals(d.getSource()) ){
        return true;
      }
      return false;
    }
}
