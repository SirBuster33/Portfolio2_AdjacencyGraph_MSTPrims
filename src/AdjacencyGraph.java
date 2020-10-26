import java.util.ArrayList;

public class AdjacencyGraph {
    ArrayList<Vertex> vertices;

    public AdjacencyGraph(){
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    public void addEdge(Vertex from, Vertex to, Integer weight){
        if (!(vertices.contains(from) && vertices.contains(to))){
            System.out.println("Error: At least one of the vertices given are not in the graph.");
            return;
        }
        Edge e = new Edge(from, to, weight);

    }

    public void printGraph(){
        for (int i = 0; i < vertices.size(); i++){
            System.out.println(" From Vertex: " + vertices.get(i).name);
            Vertex currentFrom = vertices.get(i);
            for (int j = 0; j < currentFrom.OutEdges.size(); j++){
                Edge currentEdge = currentFrom.OutEdges.get(j);
                System.out.println(" To: " + currentEdge.to.name + " (weight: " + currentEdge.weight + ")");
            }
            System.out.println("");
        }
    }
}

