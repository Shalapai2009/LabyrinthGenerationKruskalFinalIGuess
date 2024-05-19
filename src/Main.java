import java.util.List;

public class Main {

    /*
    [][][][][]
    [][][][][]
    [][][][][]
    [][][][][]
    [][][][][]
    */
    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        Graph graph = new Graph(x,y);
        graph.giveVertexAllEdges();
        graph.doKruskal();
        graph.printGraph();
        //FreackingUselles.Kruskal kruskal = new FreackingUselles.Kruskal(graph);
        System.out.println();
        System.out.println("aboba");

    }
}