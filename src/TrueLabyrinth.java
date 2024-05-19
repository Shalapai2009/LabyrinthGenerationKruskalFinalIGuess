public class TrueLabyrinth {

    Graph graph;
    private Vertex[][] labyrinthMatrix;
    public TrueLabyrinth(Graph graph){
        this.graph = graph;
        labyrinthMatrix = new Vertex[graph.getVertexMatrix().length*2+1][graph.getVertexMatrix()[0].length*2+1];
        createField();
        fullLabyrinthMatrix();
    }
    public void createField(){
        for (int i = 0; i < labyrinthMatrix.length; i++) {
            for (int j = 0; j < labyrinthMatrix[i].length; j++) {
                labyrinthMatrix[i][j] = new Vertex(i,j);
                //listOfVertex.add(vertexMatrix[i][j]);
            }
        }
    }
    private void fullLabyrinthMatrix() {
        Vertex[][] vertexMatrix = graph.getVertexMatrix();
        for (int i = 0; i < labyrinthMatrix.length; i++) {
            for (int j = 0; j < labyrinthMatrix[i].length; j++) {
                if (i == 0 | j == labyrinthMatrix.length-1 | j == 0 | i == labyrinthMatrix.length-1) {
                labyrinthMatrix[i][j].makeFull();
                }
            }
        }
        //System.out.println(labyrinthMatrix.length-2);
        for (int i = 0; i < vertexMatrix.length; i++) {
            for (int j = 0; j < vertexMatrix[i].length; j++) {
                labyrinthMatrix[2 * i + 1][2 * j + 1] = vertexMatrix[i][j];
                if (j != vertexMatrix[i].length-1) {
                    if (vertexMatrix[i][j].findInListEdgeByVertex2(vertexMatrix[i][j + 1]).getType() == Edge.Type.WALL) {
                        labyrinthMatrix[2 * i + 1][2 * (j + 1)].makeFull();
                        if (labyrinthMatrix[2 * (i + 1)][2 * (j + 1)].getType() == Vertex.Type.Empty) {
                               labyrinthMatrix[2 * (i + 1)][2 * (j + 1)].makeFull();
                        }
                        else {
                               labyrinthMatrix[2 * i][2 * (j + 1)].makeFull();
                        }

                    } else {
              //  labyrinthMatrix[2*i+1][2*(j+1)].makeEmpty();
                    }
                }
                if (i != vertexMatrix.length-1) {
                    if (vertexMatrix[i][j].findInListEdgeByVertex2(vertexMatrix[i+1][j]).getType() == Edge.Type.WALL) {
                        labyrinthMatrix[2 * (i + 1)][2 * j + 1].makeFull();
                        if (labyrinthMatrix[2 * (i + 1)][2 * (j + 1)].getType() == Vertex.Type.Empty) {
                            labyrinthMatrix[2 * (i + 1)][2 * (j + 1)].makeFull();
                        }
                        else {
                        labyrinthMatrix[2 * (i + 1)][2 * j].makeFull();
                        }

                    } else {
                  //  labyrinthMatrix[2*(i+1)][2*j+1].makeEmpty();
                    }
                }
            }
        }
    }
    public void printLabyrinth() {
        for (int i = 0; i < labyrinthMatrix.length; i++) {
            for (int j = 0; j < labyrinthMatrix[i].length; j++) {
                if (j == labyrinthMatrix[i].length-1){
                    if (labyrinthMatrix[i][j].getType() == Vertex.Type.Full) {
                    System.out.print("▀"+" ");
                    }
                    else {
                        System.out.print(" "+" ");
                    }
                    System.out.println();
                } else {
                    if (labyrinthMatrix[i][j].getType() == Vertex.Type.Full) {
                    //System.out.print(labyrinthMatrix[i][j].getType()+" ");}
                    System.out.print("▀"+" ");
                    }
                else {
                    //System.out.print(" "+labyrinthMatrix[i][j].getType()+" ");
                    System.out.print(" "+" ");
                }
                }
            }
        }
    }

}
