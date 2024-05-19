import java.util.*;

public class Graph {
    private Vertex[][] vertexMatrix;
    private List<Edge> listOfEdges = new ArrayList<>();
    private List<Vertex> listOfVertex = new ArrayList<>();
    public Graph(int x, int y) {
        vertexMatrix = new Vertex[x][y];
        createField();
       // giveVertexAllEdges();
       // printGraph();

    }
    public Vertex getVertex(int x, int y) {
        try {
            return vertexMatrix[x][y];
        }
        catch (Exception e) {
            return null;
        }
    }

    public int[] getVertexCoordinates(Vertex vertex) {
        int[] vertexCoordinates = new int[2];
        for (int i = 0; i < vertexMatrix.length; i++) {
            for (int j = 0; j < vertexMatrix[i].length; j++) {
                if (vertexMatrix[i][j] == vertex) {
                    vertexCoordinates[0] = i; vertexCoordinates[1] = j;
                    return vertexCoordinates;
                }
            }
        }
        return null;
    }
    public void createField() {
        for (int i = 0; i < vertexMatrix.length; i++) {
            for (int j = 0; j < vertexMatrix[i].length; j++) {
                vertexMatrix[i][j] = new Vertex(i, j);
                listOfVertex.add(vertexMatrix[i][j]);
            }
        }
    }
    public void giveVertexAllEdges() {
        Deque<Vertex> deque = new ArrayDeque<>();
        deque.add(vertexMatrix[0][0]);
        while (deque.size() > 0) {
            Vertex currentVertex = deque.pop();
            int[] currentVertexCoordinates = getVertexCoordinates(currentVertex);
            int currentVertexX = currentVertexCoordinates[0];
            int currentVertexY = currentVertexCoordinates[1];
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i != 0 & j == 0) || (i == 0 & j != 0)) {
                        Vertex mineVertex = getVertex(currentVertexX + i,currentVertexY + j);
                        if (mineVertex != null && (!currentVertex.isIWasHere(mineVertex))) {
                            int RandomRib = (int) (Math.random() * (10));
                            Edge mineEdge = new Edge(currentVertex, mineVertex, RandomRib);
                            currentVertex.addEdge(mineEdge);
                            mineEdge.setBROTHA();
                            mineVertex.addEdge(mineEdge.getBROTHA());
                            listOfEdges.add(mineEdge);
                            deque.add(mineVertex);
                        }
                    }
                }
            }
        }

    }
    public void giveVertexEdgesDefinite() {
        for (Edge edge: this.doKruskal()) {

        }
    }
    public List<Edge> doKruskal() {
        Collections.sort(listOfEdges);
        SpanningTree spanningTree = new SpanningTree(this);
        spanningTree.createDaFuckingTrulyGoddessSpanningTree();
        List<Edge> listOfTrue = spanningTree.getListOfTrue();
        System.out.println("whomp whomp");
        return listOfTrue;
    }

    public List<Edge> getListOfEdges() {
        return listOfEdges;
    }
    public List<Vertex> getListOfVertex() {
        return listOfVertex;
    }

    public void setVertexMatrix(Vertex[][] vertexMatrix) {
        this.vertexMatrix = vertexMatrix;
    }

    public Vertex[][] getVertexMatrix() {
        return vertexMatrix;
    }
    public void DeleteEdge(Edge edge){
    }
    public void printGraph() {
        int k =0;
        for (int i = 0; i < vertexMatrix[0].length; i++) {
            System.out.print("______");
        }
        System.out.println();
        for (int i = 0; i < vertexMatrix.length; i++) {
            for (int j = 0; j < vertexMatrix[i].length; j++) {
                if (j == vertexMatrix[i].length-1 ) {
                    if (i != vertexMatrix[i].length-1) {
                        if (vertexMatrix[i][j].findInListEdgeByVertex2(vertexMatrix[i + 1][j]).getType() == Edge.Type.WALL) {
                            System.out.print("_" + "_"+ "_" + "|");
                            System.out.println();
                        }
                        else {
                            //System.out.print( vertexMatrix[i][j].getStringCoordinates() + "|");
                            System.out.print( "   " + "|");
                            System.out.println();
                        }
                    } else {
                        //System.out.print(vertexMatrix[i][j].getStringCoordinates()+"|");
                        System.out.print("   "+"|");
                    System.out.println();
                    }

                } else {
                    if (j == 0) {
                        System.out.print("|");
                    }
                    if (i != vertexMatrix[i].length-1) {
                        if (vertexMatrix[i][j].findInListEdgeByVertex2(vertexMatrix[i + 1][j]).getType() == Edge.Type.WALL) {
                            System.out.print("_" + "_"+ "_");
                        }
                        else {//System.out.print(vertexMatrix[i][j].getStringCoordinates());
                            System.out.print("   ");
                             }
                    } else{
                     //System.out.print(vertexMatrix[i][j].getStringCoordinates());
                        System.out.print("   ");
                    }

                    if (vertexMatrix[i][j].findInListEdgeByVertex2(vertexMatrix[i][j + 1]).getType() == Edge.Type.WALL) {
                        System.out.print(" | ");
                    } else System.out.print("   ");
                }
            }
        }
        for (int i = 0; i < vertexMatrix[0].length; i++) {
            System.out.print("¯¯¯¯¯¯");
        }

    }
}
