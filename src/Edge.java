import java.util.List;

public class Edge implements Comparable<Edge>{
    private Vertex vertex1;
    private Vertex vertex2;
    private Type type = Type.WALL;
    private Edge BROTHA;

    private int rib;
    public Edge(Vertex vertex1, Vertex vertex2, int rib) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.rib = rib;
    }

    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }



    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public void setRib(int rib) {
        this.rib = rib;
    }

    public int getRib() {
        return rib;
    }


    @Override
    public int compareTo(Edge o) {
        return this.getRib() - o.getRib();
    }

    // отдел БРАТАНА
    public Edge getBROTHA() {
        return BROTHA;
    }

    public void setBROTHA(Vertex vertex1, Vertex vertex2, int rib) {
        this.BROTHA = new Edge(vertex2,vertex1,rib);
        BROTHA.setBROTHA(this);
    }
    public void setBROTHA(Edge edge) {
        this.BROTHA = edge;
        //BROTHA.setBROTHA();
    }
    public void setBROTHA() {
        this.BROTHA = new Edge(vertex2,vertex1,rib);
        BROTHA.setBROTHA(this);
    }

    // Отдел по типу ребер
    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    public void makeWall() {
        this.type = Type.WALL;
    }
    public void makeWay() {
        this.type = Type.WAY;
    }

    public static enum Type {
        WALL, WAY;
    }


}
