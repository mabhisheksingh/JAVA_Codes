package CodingQuestions.backtarcking;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NQueen {
    private static final int N = 5;
    private final HashMap<Integer, Boolean> hashMap = new HashMap();

    static final ArrayList< ArrayList<ArrayList<String>> > ARRAY_LIST  = new ArrayList<>();

    public static void main(String[] args) {
        NQueen Queen = new NQueen();
        Queen.solveNQ();
    }
    public  List<List<String>> solveNQ() {
        int [][]matrix = new int[N][N];
        List<List<String>> output  = new ArrayList<>();
        solveNQList(matrix,0, output, N);


//        if(solveNQList(matrix,0)){
//            printMatrix(matrix);
//        }else{
//            System.out.println("Not find...");
//            printMatrix(matrix);
//        }
        System.out.println("--------------OUTPUT----------------");
        System.out.println(ARRAY_LIST);
        System.out.println("--------------SIZE----------------");
        System.out.println("SIZE :"+ output.size());

        return output;
    }

    public boolean solveNQq(int [][] matrix, int row){

        if( row == N)
            return true;

        for (int j = 0; j < N; j++) {
            if( isSafe( matrix , row , j,N ) ){
                if( hashMap.containsKey(j) && hashMap.get(j)) continue;
                matrix[row][j] = 1;
                hashMap.put(j,true);
                if( solveNQq(matrix, row + 1)) return true;
                matrix[row][j] = 0;
                hashMap.put(j,false);
            }
        }
        return false;
    }

    public void solveNQList(int [][] matrix, int row , List<List<String>> output,int N ){

//        System.out.println(row);
        if( row == N){
            printMatrix(matrix);
            List<String> oneSolution = addToList(matrix);
            output.add(oneSolution);
            return ;
        }

        for (int j = 0; j < N; j++) {
            if( isSafe( matrix , row , j,N ) ){
                if( hashMap.containsKey(j) && hashMap.get(j)) continue;
                matrix[row][j] = 1;
                hashMap.put(j,true);
                solveNQList(matrix, row + 1, output,N);
                matrix[row][j] = 0;
                hashMap.put(j,false);
            }
        }

//        System.out.println("output "+output.size());
        return ;
    }

    public boolean isSafe(int [][] matrix, int i, int j , int N){

        //left upper diagonal
        for (int row=i-1, col = j-1 ;row>=0 && col >= 0 ;row--,col-- )
            if( matrix[row][col] == 1 ) return false;

        //left lower diagonal
        for (int row=i+1, col = j-1 ;row<N && col >= 0 ;row++ ,col-- )
            if( matrix[row][col] == 1 ) return false;

        //right upper diagonal
        for (int row=i-1, col = j+1 ;row>=0 && col <N ;row--,col++ )
            if( matrix[row][col] == 1 ) return false;

        //right lower diagonal
        for (int row=i+1, col = j+1 ;row< N && col <N ;row++,col++ )
            if( matrix[row][col] == 1 ) return false;

        return true;
    }

    public void printMatrix(int [] @NotNull []matrix){
        System.out.println("\n****** printing start********");
        for (int [] row : matrix){
            for( int item : row){
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        System.out.println("\n****** printing End********");
    }

    private List<String> addToList(int [][] matrix ){

        ArrayList<String> list = new ArrayList<>();
        for (int i[] : matrix) {
            String string = "";
            for (int j : i) {
                if(j == 1){
                    string+="Q";
                }else{
                    string+=".";
                }
            }
            list.add(string);
        }
        return list;
    }

}
