public class Edge {
    Integer weight;
    Vertex from;
    Vertex toVertex;

    public Edge(Vertex from, Vertex toVertex, Integer cost){
        this.from = from;
        this.toVertex = toVertex;
        this.weight = cost;
        this.from.addOutEdge(this);
    }

    public Integer getWeight() {
        return weight;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    //
}
