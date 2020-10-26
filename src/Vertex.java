import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist = Integer.MAX_VALUE;

    public Vertex(String id){
        this.name = id;
        this.OutEdges = new ArrayList<Edge>();
    }

    public void addOutEdge(Edge e){
        OutEdges.add(e);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.dist < o.dist){
            return -1;
        }
        if (this.dist > o.dist){
            return 1;
        }
        return 0;
    }
}
