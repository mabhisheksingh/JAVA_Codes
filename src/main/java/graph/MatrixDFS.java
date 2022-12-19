package graph;

public class MatrixDFS {

    private static int [][] graph ={{1,1,0,0},{1,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,0,0}};
    public static final int ROW = 5;
    public static final int COLUMN = 4;

    public static void printGraph(int[][] graph,int row,int column) {
        System.out.println("\n----------------printing start ------------------\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\n----------------printing end ------------------\n");

    }

    public static void travelISLAND(int [][] graph,int i,int j,int rowLimit,int columnLimit){
        if( i<0 || j<0 || (i >= rowLimit) ||  (j >= columnLimit) || (graph[i][j] != 1 ) ) return;
        graph[i][j] =2;

        travelISLAND(graph, i , j-1 , rowLimit , columnLimit);  //Left
        travelISLAND(graph, i , j+1 , rowLimit , columnLimit); //right
        travelISLAND(graph, i-1 , j ,rowLimit,columnLimit);    //top
        travelISLAND(graph, i+1 , j ,rowLimit,columnLimit); //down

    }

    public static int countNoOfIsland(int[][] graph,int row,int column) {
        int noOFISLAND = 0;
        System.out.println("Row : "+row+" column "+column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (graph[i][j]== 1) {
                    travelISLAND(graph,i,j,row,column);
                    noOFISLAND++;
                }
            }
        }
        return noOFISLAND;
    }
    public static void main(String[] args) {
        printGraph(graph,ROW,COLUMN);
        System.out.println("-----------------------Print no of island in graph ---------------------------------");
        int noOFISLAND = countNoOfIsland(graph,ROW,COLUMN);
        System.out.println("countNoOfIsland "+noOFISLAND);
    }
}
