public class Main {

    public static void main(String[] args) {

        // Create a new AdjacencyGraph "grid"
        AdjacencyGraph grid = new AdjacencyGraph();

        // Add the data provided in the Assignment to grid
        addData(grid);

        // Print out grid
        grid.printGraph();

        // Find MST using Prims algorithm and prints the result
        grid.MSTPrims();



        /*// Matrix graph
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


        // thisGraph.mstPrisms();

        /* int[] pred = thisGraph.shortestPath(0);
        thisGraph.printPath(pred, 6);
        thisGraph.printPath(pred, 5);*/



    }

    public static AdjacencyGraph addData(AdjacencyGraph grid){

        // Create a vertex for each of the 16 locations.
        Vertex Eskildstrup = new Vertex("Eskildstrup");
        Vertex Haslev = new Vertex("Haslev");
        Vertex Holbaek = new Vertex("Holbaek");
        Vertex Jaegerspris = new Vertex("Jaegerspris");
        Vertex Kalundborg = new Vertex("Kalundborg");
        Vertex Korsoer = new Vertex("Korsoer");
        Vertex Koege = new Vertex("Koege");
        Vertex Maribo = new Vertex("Maribo");
        Vertex Naestved = new Vertex("Naestved");
        Vertex Ringsted = new Vertex("Ringsted");
        Vertex Slagelse = new Vertex("Slagelse");
        Vertex NykoebingF = new Vertex("NykoebingF");
        Vertex Vordingborg = new Vertex("Vordingborg");
        Vertex Roskilde = new Vertex("Roskilde");
        Vertex Soroe = new Vertex("Soroe");
        Vertex Nakskov = new Vertex("Nakskov");

        // Add the vertices to our grid.
        grid.addVertex(Eskildstrup);
        grid.addVertex(Haslev);
        grid.addVertex(Holbaek);
        grid.addVertex(Jaegerspris);
        grid.addVertex(Kalundborg);
        grid.addVertex(Korsoer);
        grid.addVertex(Koege);
        grid.addVertex(Maribo);
        grid.addVertex(Naestved);
        grid.addVertex(Ringsted);
        grid.addVertex(Slagelse);
        grid.addVertex(NykoebingF);
        grid.addVertex(Vordingborg);
        grid.addVertex(Roskilde);
        grid.addVertex(Soroe);
        grid.addVertex(Nakskov);

        // Add edges (bidirectional) between vertices
        grid.addEdge(Eskildstrup, Maribo, 28);
        grid.addEdge(Eskildstrup, NykoebingF, 13);
        grid.addEdge(Eskildstrup, Vordingborg, 24);

        grid.addEdge(Haslev, Korsoer, 60);
        grid.addEdge(Haslev, Koege, 24);
        grid.addEdge(Haslev, Naestved, 25);
        grid.addEdge(Haslev, Ringsted, 19);
        grid.addEdge(Haslev, Roskilde, 47);
        grid.addEdge(Haslev, Slagelse, 48);
        grid.addEdge(Haslev, Soroe, 34);
        grid.addEdge(Haslev, Vordingborg, 40);


        grid.addEdge(Holbaek, Jaegerspris, 34);
        grid.addEdge(Holbaek, Kalundborg, 44);
        grid.addEdge(Holbaek, Korsoer, 66);
        grid.addEdge(Holbaek, Ringsted, 36);
        grid.addEdge(Holbaek, Roskilde, 32);
        grid.addEdge(Holbaek,Slagelse, 46);
        grid.addEdge(Holbaek,Soroe, 34);

        grid.addEdge(Jaegerspris, Korsoer, 95);
        grid.addEdge(Jaegerspris, Koege, 58);
        grid.addEdge(Jaegerspris, Ringsted, 56);
        grid.addEdge(Jaegerspris, Roskilde, 33);
        grid.addEdge(Jaegerspris, Slagelse, 74);
        grid.addEdge(Jaegerspris, Soroe, 63);

        grid.addEdge(Kalundborg, Ringsted, 62);
        grid.addEdge(Kalundborg, Roskilde, 70);
        grid.addEdge(Kalundborg, Slagelse, 39);
        grid.addEdge(Kalundborg, Soroe, 51);

        grid.addEdge(Korsoer,Naestved, 45);
        grid.addEdge(Korsoer, Slagelse, 20);

        grid.addEdge(Koege, Naestved, 45);
        grid.addEdge(Koege, Ringsted, 28);
        grid.addEdge(Koege, Roskilde, 25);
        grid.addEdge(Koege, Vordingborg, 60);

        grid.addEdge(Maribo, Nakskov, 27);
        grid.addEdge(Maribo, NykoebingF, 26);

        grid.addEdge(Naestved, Roskilde, 57);
        grid.addEdge(Naestved, Ringsted, 26);
        grid.addEdge(Naestved, Slagelse, 37);
        grid.addEdge(Naestved, Soroe, 32);
        grid.addEdge(Naestved, Vordingborg, 28);

        grid.addEdge(Ringsted, Roskilde, 31);
        grid.addEdge(Ringsted, Soroe, 15);
        grid.addEdge(Ringsted, Vordingborg, 58);

        grid.addEdge(Slagelse, Soroe, 14);

        return grid;

    }
}
