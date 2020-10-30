import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdjacencyGraph {
    ArrayList<Vertex> vertices;

    // Constructor for AdjacencyGraph instantiates a new arrayList of vertices.
    public AdjacencyGraph(){
        vertices = new ArrayList<Vertex>();
    }

    // Allows us to add vertices to the graph.
    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    // Adds an edge between two vertices using a given weight.
    // Because we are working with a MST, the edge is created twice, once for each direction.
    public void addEdge(Vertex from, Vertex to, Integer weight){
        if (!(vertices.contains(from) && vertices.contains(to))){
            System.out.println("Error: At least one of the vertices given are not in the graph.");
            return;
        }
        Edge fromTo = new Edge(from, to, weight);
        Edge toFrom = new Edge(to, from, weight);
    }

    // Prints out all the vertices from the graph with their respective outedges and the edges' weight.
    public void printGraph(){
        for (int i = 0; i < vertices.size(); i++){
            System.out.println(" From Vertex: " + vertices.get(i).name);
            Vertex currentFrom = vertices.get(i);
            for (int j = 0; j < currentFrom.OutEdges.size(); j++){
                Edge currentEdge = currentFrom.OutEdges.get(j);
                System.out.println(" To: " + currentEdge.toVertex.name + " (weight: " + currentEdge.weight + ")");
            }
            System.out.println("");
        }
    }

    // Prims algorithm for AdjacencyGraphs, creates a minimum spanning tree (MST) using the lowest weight edges
    // to connect all the vertices.
    public void MSTPrims(){
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        if (vertices.size() > 0){
            vertices.get(0).setDist(0);
            Q.offer(vertices.get(0));
        }
        int counter = 0;
        int MST = 0;

        // While the priority queue contains elements and we have not visited all vertices yet
        while (!Q.isEmpty() && counter < vertices.size()){
            Vertex u = Q.poll();
            System.out.println("Vertex u: " + u.getName());
            int indexOfCurrentVertex = vertices.indexOf(u);
            System.out.println("indexOfCurrentVertex: " + indexOfCurrentVertex);

            if (!u.getVisited()) { //visited[indexOfCurrentVertex] != 1
                ArrayList<Edge> outEdgesOfCurrentVertex = u.OutEdges; // vertices.get(indexOfCurrentVertex)

                // Go through Outedge array of vertex
                for (int v = 0; v < outEdgesOfCurrentVertex.size(); v++) {
                    System.out.println("currentOutedges' weight of Vertex" + u.getName() + " : " + outEdgesOfCurrentVertex.get(v).getWeight());

                    // was the vertex the outedge leads to not visited && is the outedge weight to that vertex smaller
                    // than the previous weight to that vertex?
                    if (outEdgesOfCurrentVertex.get(v).getWeight() < outEdgesOfCurrentVertex.get(v).getToVertex().getDist()
                            && !outEdgesOfCurrentVertex.get(v).getToVertex().getVisited()) {

                        // Update the distance to the vertex using the smaller weight from our current vertex.
                        outEdgesOfCurrentVertex.get(v).getToVertex().setDist(outEdgesOfCurrentVertex.get(v).getWeight());

                        // Replace the old predecessor to the vertex by our current vertex
                        outEdgesOfCurrentVertex.get(v).getToVertex().setPredecessor(indexOfCurrentVertex);

                        System.out.println("currentOutedges.get(v).getTo(): " + outEdgesOfCurrentVertex.get(v).getToVertex().getName());

                        // Add the toVertex of the edge to our priority Queue.
                        Q.offer(outEdgesOfCurrentVertex.get(v).getToVertex());
                    }
                }
                // Update our Visited boolean of the current vertex to true.
                vertices.get(indexOfCurrentVertex).setVisited(true);

                counter++;

                // Update the total distance of the MST.
                MST += u.getDist();
            }
        }
        System.out.println(" Minimum spanning Tree Distance: " + MST);
        printMST();
    }

    // Prints out the MST, displaying all vertices with their respective parents and edge weights.
    public void printMST(){

        System.out.println(" Starting vertex: " + vertices.get(0).getName());


        for (int i = 0; i < vertices.size(); i++){
            if (vertices.get(i).getPredecessor() != -1){
                System.out.println(" Parent of vertex: " + vertices.get(i).getName() + " is: " + vertices.get(i).getPredecessor() + " with Edge Weight: " + vertices.get(i).getDist());
            }
        }
    }
}

