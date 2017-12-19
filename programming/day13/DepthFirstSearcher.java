public class DepthFirstSearcher<N,W> {

  //Fields
  INode<N> start;
  INode<N> end;
  IGraph<N,W> graph;
  Stack<INode<N>> vis_list;
  Stack<INode<N>> going;

  public DepthFirstSearcher(IGraph<N,W> g, INode<N> s, INode<N> e){
    start = s;
    end = e;
    graph = g;
    vis_list = new Stack();
    going = new Stack();
  }

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
    if(getPath(graph,start,end) !=null){
      return true;
    }
    return false;
  }

  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
    if(start.equals(end)){
      vis_list.push(start);
    }
    else{
        vis_list.push(start);
        for(int i = 0; i < graph.getNeighbors(start).length; i++){
          going.push(graph.getNeighbors(start)[i]);
        }
        while(going.size() != 0){
          //addes start to the visited stack list
          start = going.pop();//makes start the neighbor at the top of the going stack
          vis_list.push(start);
          going.push(start); // Adds the new start node to the top of going stack
          if(start.equals(end)){//checks to see if that new node is what we want
            vis_list.push(start);
            break;
          }
          if(graph.getNeighbors(start).length > 0){ //if the node we're at has neighbors
            vis_list.push(start);
            for(int i = 0; i < graph.getNeighbors(start).length; i++){//add its neighbors to the going stack
              going.push(graph.getNeighbors(start)[i]);
            }
          }
          else{//if that node has no children and not it
            going.pop();
          }
          // This part was supposed to handle edge cases as well as times when paths doesnt exist couldn't get it to works
          // INode<N> holder = vis_list.pop();
          // vis_list.push(holder);
          // if(holder.equals(start)){
          //   while(holder.equals(start)){
          //     System.out.println("going size " + going.size());
          //     if(going.size() == 0 || start.equals(null)){
          //       break;
          //     }
          //     else{
          //       vis_list.pop();
          //       going.pop();
          //       holder = vis_list.pop();
          //       vis_list.push(holder);
          //       if(going.size() != 0){
          //       start = going.pop();
          //       going.push(start);
          //     }
          //     }
          //   }
          // }
          }
        }
    Stack<INode<N>> final_stack = new Stack();
    while(vis_list.size() !=0){
      final_stack.push(vis_list.pop());
    }
    DoubleLinkList<INode<N>> h = new DoubleLinkList();
    while(final_stack.size() != 0){
      h.append(final_stack.pop());
    }
    return h;
  }

}
