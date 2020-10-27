import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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
        Edge fromTo = new Edge(from, to, weight);
        Edge toFrom = new Edge(to, from, weight);
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

    public void MSTPrims(){
        int[] predecessor = new int[vertices.size()];
        int[] visited = new int[vertices.size()];
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        Arrays.fill(predecessor, -1);
        Arrays.fill(visited, 0);
        if (vertices.size() > 0){
            vertices.get(0).setDist(0);
            Q.offer(vertices.get(0));
        }
        int counter = 0;
        int MST = 0;
        while (!Q.isEmpty() && counter < vertices.size()){
            Vertex u = Q.poll();
            System.out.println("Vertex u: " + u.getName());
            int whateverName = vertices.indexOf(u);
            System.out.println("whateverName: " + whateverName);

            if (visited[whateverName] != 1) {
                ArrayList<Edge> currentOutedges = vertices.get(whateverName).OutEdges; // vertices.get(vertices.indexOf(u))

                for (int v = 0; v < currentOutedges.size(); v++) { // Go through Outedge array of vertex
                    System.out.println("currentOutedges' weight of Vertex" + u.getName() + " : " + currentOutedges.get(v).getWeight());

                    if (currentOutedges.get(v).getWeight() < currentOutedges.get(v).getTo().getDist() && !currentOutedges.get(v).getTo().getVisited()) {
                        // was the vertex the outedge leads to not visited && is the outedge weight to that vertex smaller
                        // than the previous weight to that vertex?
                        currentOutedges.get(v).getTo().setDist(currentOutedges.get(v).getWeight());
                        predecessor[vertices.indexOf(currentOutedges.get(v).getTo())] = whateverName;

                        System.out.println("currentOutedges.get(v).getTo(): " + currentOutedges.get(v).getTo().getName());
                        Q.offer(currentOutedges.get(v).getTo());
                    }
                }
                vertices.get(whateverName).setVisited(true);
                counter++;
                MST += u.getDist();
            }
        }
        System.out.println(" Minimum spanning Tree Distance: " + MST);
        printMST(predecessor);
    }

    public void printMST(int[] pred){
        for (int i = 0; i < vertices.size(); i++){
            if (pred[i] != -1){
                System.out.println(" Parent of vertex: " + vertices.get(i).getName() + " is: " + vertices.get(pred[i]).getName() + " with Edge Weight: " + vertices.get(i).getDist());
            }
        }
    }
}

