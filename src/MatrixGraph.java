import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class MatrixGraph {
    int[][] matrixedgegraph;
    int[][] matrixweightgraph;

    public MatrixGraph(int vertices){
        matrixedgegraph = new int[vertices][vertices];
        matrixweightgraph = new int[vertices][vertices];
    }

    public void addEdge(int from, int to, int weight){
        matrixedgegraph[from][to] = 1;
        matrixweightgraph[from][to] = weight;
    }

    public void printGraph(){
        for (int fromi = 0; fromi < matrixedgegraph.length; fromi++){
            System.out.println("Edges from vertex " + fromi);
            for (int toj = 0; toj < matrixedgegraph.length; toj++){
                if (matrixedgegraph[fromi][toj] == 1){
                    System.out.print("To " + toj);
                    System.out.println(" weight " + matrixweightgraph[fromi][toj]);
                }
            }
            System.out.println("");
        }
    }

    public void MSTPrims(){
        int[] Distance = new int[matrixedgegraph.length];
        int[] predecessor = new int[matrixedgegraph.length];
        int[] visited = new int[matrixedgegraph.length];
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>();
        Arrays.fill(Distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        Arrays.fill(visited, 0);
        if (matrixedgegraph.length > 0){
            Distance[0] = 0;
            Q.offer(new Pair(0, 0));
        }
        int counter = 0;
        int MST = 0;
        while (!Q.isEmpty() && counter < matrixedgegraph.length){
            Pair u = Q.poll();
            if (visited[u.index] != 1) {
                for (int v = 0; v < matrixedgegraph.length; v++) {
                    if (matrixedgegraph[u.index][v] == 1 && matrixweightgraph[u.index][v] < Distance[v]) {
                        Distance[v] = matrixweightgraph[u.index][v];
                        predecessor[v] = u.index;
                        Q.offer(new Pair(Distance[v], v));
                    }

                }
                visited[u.index] = 1;
                counter++;
                MST += Distance[u.index];
            }
        }
        System.out.println(" Minimum spanning Tree Distance: " + MST);
        printMST(predecessor, Distance);
    }

    public void printMST(int[] pred, int[] dist){
        for (int i = 0; i < matrixedgegraph.length; i++){
            System.out.println(" Parent of vertex: " + i + " is: " + pred[i] + " with Edge Weight: " + dist[i]);
        }
    }

    /*public int[] shortestPath(int source){
        int[] Distance = new int[matrixedgegraph.length];
        int[] predecessor = new int[matrixedgegraph.length];
        int[] visited = new int[matrixedgegraph.length];
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>();
        Arrays.fill(Distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        Arrays.fill(visited, 0);
        if (matrixedgegraph.length > 0){
            Distance[source] = 0;
            Q.offer(new Pair(0, source));
        }
        int counter = 0;
        while (!Q.isEmpty() && counter < matrixedgegraph.length) {
            Pair i = Q.poll();
            for (int j = 0; j < matrixedgegraph.length; j++){
                if (matrixedgegraph[i.index][j] == 1 && visited[j] != 1) {
                    if (Distance[i.index] + matrixweightgraph[i.index][j] < Distance[j.index]){
                        Distance[j] = Distance[i.index] + matrixweightgraph[i.index][j];
                        predecessor[j] = i.index;
                        Q.offer(new Pair(Distance[j], j));
                    }
                }
            }
            counter++;
            visited[i.index] = 1;
        }
        return predecessor;
    }*/

    public void printPath(int[] pred, int target){
        String s = null;

        Stack<Integer> reversePath = new Stack<Integer>();
        int current = target;
        while(current != -1){
            reversePath.push(current);
            current = pred[current];
        }
        int pathlength = 0;
        current = reversePath.pop();
        while(!reversePath.isEmpty()){
            int tovertex = reversePath.pop();
            s += "From " + current + " to " + tovertex + " distance " + matrixweightgraph[current][tovertex] + "\n";
            pathlength += matrixweightgraph[current][tovertex];
            current = tovertex;
        }
        s += "\nTotal distance: " + pathlength;
        System.out.println(s);
    }
}
