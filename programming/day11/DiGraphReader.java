import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    Graph<String,Double> r = new Graph();
    INode<String> one;
    INode<String> two;
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
          BufferedReader br=new BufferedReader(new FileReader(filename));
          String h = br.readLine();

          while(h != null){
            String u[] =  h.split(":");
            if(u.length == 3){
              one = r.addNode(u[0]);
              two = r.addNode(u[1]);
              Double b = Double.parseDouble(u[2]);
              r.addEdge(one,two,b);
            }

            h = br.readLine();
          }
        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        // For each line, add the nodes and edge

        // Return the graph instance
        return r;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader rr = new DiGraphReader();
        IGraph<String,Double> g = rr.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length - 1 ; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
