import java.util.ArrayList;
import java.util.List;

public class SpanningTree {
    Graph graph;
   private Vertex SpanningVertex;
    List<Edge> listOfTrue = new ArrayList<>();

    public SpanningTree(Graph graph) {
        this.graph = graph;
    }

    public void createDaFuckingTrulyGoddessSpanningTree() {
        List<Edge> listOfEdge = graph.getListOfEdges();
        for (Edge edge: listOfEdge) {
            if (edge.getVertex2().getFinal() != edge.getVertex1().getFinal()) {
                if (edge.getVertex1().getSize() > edge.getVertex2().getSize()){
                    edge.getVertex1().addChildList(edge.getVertex2().getFinal());
                    SpanningVertex = edge.getVertex1();
                }
                else {
                    edge.getVertex2().addChildList(edge.getVertex1().getFinal());
                    SpanningVertex = edge.getVertex2();
                }
                edge.makeWay();
                edge.getBROTHA().makeWay();
                listOfTrue.add(edge);

            }
        }


    }

    public List<Edge> getListOfTrue() {
        return listOfTrue;
    }

    public Vertex getSpanningVertex() {
        Vertex maxSizeVertex = new Vertex(0,0);
        for (Edge edge: listOfTrue) {
            if (maxSizeVertex.getSize()< edge.getVertex1().getSize()){
                maxSizeVertex = edge.getVertex1();
            }
            if (maxSizeVertex.getSize() < edge.getVertex2().getSize()){
                maxSizeVertex = edge.getVertex2();
            }
        }
        return maxSizeVertex;
    }
}
