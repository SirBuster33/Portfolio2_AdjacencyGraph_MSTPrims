public class Main {

    public static void main(String[] args) {

        // Matrix graph
        MatrixGraph thisGraph = new MatrixGraph(7);
        thisGraph.addEdge(0,1,1);
        thisGraph.addEdge(0, 2, 5);
        thisGraph.addEdge(0, 4, 3);
        thisGraph.addEdge(1, 4, 1);
        thisGraph.addEdge(1, 5, 7);
        thisGraph.addEdge(2, 4, 1);
        thisGraph.addEdge(2, 3, 1);
        thisGraph.addEdge(3, 4, 1);
        thisGraph.addEdge(3, 6, 1);
        thisGraph.addEdge(4, 3, 3);
        thisGraph.addEdge(4, 5, 3);
        thisGraph.addEdge(4, 6, 4);
        thisGraph.addEdge(5, 6, 1);
        thisGraph.printGraph();

        AdjacencyGraph myGraph = new AdjacencyGraph();
        Vertex a = new Vertex("0");
        Vertex b = new Vertex("1");
        Vertex c = new Vertex("2");
        Vertex d = new Vertex("3");
        Vertex e = new Vertex("4");
        Vertex f = new Vertex("5");
        Vertex g = new Vertex("6");

        myGraph.addVertex(a);
        myGraph.addVertex(b);
        myGraph.addVertex(c);
        myGraph.addVertex(d);
        myGraph.addVertex(e);
        myGraph.addVertex(f);
        myGraph.addVertex(g);

        myGraph.addEdge(a, b, 1);
        myGraph.addEdge(a, c, 5);
        myGraph.addEdge(a, e, 3);
        myGraph.addEdge(b, e, 1);
        myGraph.addEdge(b, f, 7);
        myGraph.addEdge(c, d, 1);
        myGraph.addEdge(d, e, 1);
        myGraph.addEdge(d, g, 1);
        myGraph.addEdge(e, c, 1);
        myGraph.addEdge(e, d, 3);
        myGraph.addEdge(e, f, 3);
        myGraph.addEdge(e, g, 4);
        myGraph.addEdge(f, g, 1);

        myGraph.printGraph();

        // AdjacencyGraph Portfolio2

        // thisGraph.mstPrisms();

        /* int[] pred = thisGraph.shortestPath(0);
        thisGraph.printPath(pred, 6);
        thisGraph.printPath(pred, 5);*/



    }
}
