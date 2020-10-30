import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist = Integer.MAX_VALUE;
    boolean visited = false;
    int predecessor = -1;

    // Constructor.
    public Vertex(String id){
        this.name = id;
        this.OutEdges = new ArrayList<Edge>();
    }

    // Getters and Setters.
    public String getName() {
        return name;
    }
    public Integer getDist() {
        return dist;
    }
    public Boolean getVisited() {
        return visited;
    }
    public int getPredecessor() {
        return predecessor;
    }
    public void setDist(Integer dist) {
        this.dist = dist;
    }
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
    public void setPredecessor(Integer newPredecessor){
        this.predecessor = newPredecessor;

    }

    // Adds an edge to the list of outedges of the vertex.
    public void addOutEdge(Edge e){
        OutEdges.add(e);
    }

    // Redefines the compareTo method from the Comparable interface to suit this assignment's needs.
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
