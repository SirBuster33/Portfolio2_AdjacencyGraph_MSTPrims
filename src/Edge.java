public class Edge {
    Integer weight;
    Vertex from;
    Vertex to;

    public Edge(Vertex from, Vertex to, Integer cost){
        this.from = from;
        this.to = to;
        this.weight = cost;
        this.from.addOutEdge(this);
    }

    public Integer getWeight() {
        return weight;
    }

    public Vertex getTo() {
        return to;
    }

    //
}
