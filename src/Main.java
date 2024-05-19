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
        graph.doKruskal();
        graph.printGraph();
        //FreackingUselles.Kruskal kruskal = new FreackingUselles.Kruskal(graph);
        System.out.println();
        TrueLabyrinth trueLabyrinth = new TrueLabyrinth(graph);
        trueLabyrinth.printLabyrinth();
        System.out.println("aboba");

    }
}