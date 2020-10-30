public class Edge {
    Integer weight;
    Vertex fromVertex;
    Vertex toVertex;

    // Instantiates an edge object fromVertex one vertex to another with a specified weight and adds the edge to the outedges
    // of the fromVertex.
    public Edge(Vertex fromVertex, Vertex toVertex, Integer cost){
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = cost;
        this.fromVertex.addOutEdge(this);
    }

    // Getters.
    public Integer getWeight() {
        return weight;
    }
    public Vertex getToVertex() {
        return toVertex;
    }

}
