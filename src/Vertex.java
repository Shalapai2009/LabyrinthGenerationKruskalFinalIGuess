import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int x;
    private int y;
    private Type type = Type.Empty;
    private ArrayList<Edge> listEdge = new ArrayList<>();
    //private boolean isolated = true;
    public Vertex(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public void addEdge(Edge edge) {
        listEdge.add(edge);
    }
    public void addEdge(Vertex vertex1, Vertex vertex2, int rib) {
        listEdge.add(new Edge(vertex1, vertex2,rib));
    }

    public ArrayList<Edge> getListEdge() {
        return listEdge;
    }
    public Edge findInListEdgeByVertex2(Vertex vertex2) {
        for (Edge edge: listEdge) {
            if (edge.getVertex2() == vertex2) {
                return edge;
            }
        }
        return null;
    }
    public boolean isIWasHere (Vertex vertex) {
        for (Edge i : listEdge){
            if (i.getVertex2().equals(vertex)) {
                return true;
            }
        }
        return false;
    }
    public Boolean getBooleanDefiniteEdge(Edge edge) {
        return listEdge.contains(edge);
    }
    public Edge removeEdge(int x) {
        return listEdge.remove(x);
    }
    public String getStringCoordinates() {
        return Integer.toString(x)+";"+Integer.toString(y);
    }

    // Отдел типов
    public Type getType() {
        return type;
    }
    public void makeEmpty() {
        this.type = Type.Empty;
    }
    public void makeFull() {
        this.type = Type.Full;
    }
    public static enum Type {
        Empty,Full;
    }

    // Здесь отступает жизнь
    // Зажатая в тески
    // Полуденной жары
    // Надвигаются, ПЕСКИ
    private int size = 0;
    private List<Vertex> vertexChildList = new ArrayList<>();
    private Vertex vertexParent = this;


    public Vertex getVertex() {
        return this;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addChildList(Vertex vertexChild) {
        vertexChildList.add(vertexChild);
        vertexChild.setParent(this);
       // updateSize(vertexChild);
    }

    public List<Vertex> getVertexChildList() {
        return vertexChildList;
    }
    public void setParent(Vertex vertexParent) {
        this.vertexParent = vertexParent;
    }

    public Vertex getParent() {
        return vertexParent;
    }
    public Vertex getFinal() {
        Vertex mineVertex = this;
        while (mineVertex.getParent() != mineVertex) {
            mineVertex = mineVertex.getParent();
        }
        return mineVertex;
    }
    public void updateSize(Vertex vertexChild) {
        Vertex mineVertex = vertexChild;
        while (mineVertex.getParent() != mineVertex) {
            int currentSize = mineVertex.getSize();
            mineVertex = mineVertex.getParent();
            if (mineVertex.getSize() <= currentSize) {
                mineVertex.setSize(currentSize+1);
            }
        }
    }


}
