package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sudoku {

    public static int[][] sudokuObj;
    public static final int ROW = 9;
    public static final int COLUMN = 9;
    public static final int BLOCK_SIZE = 3;
    public static  Map<Integer,Boolean> hashMap = new HashMap<>();
    static {
        sudokuObj = new int[][]{
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}
        };
    }

    public static void removeHashMapToFalse(Map<Integer,Boolean> hashMapToFalse) {
        hashMapToFalse.clear();
//        for (int i = 1; i <= ROW; i++) {
//            hashMapToFalse.put(i,false);
//        }
    }
    public static void printSudoku(int[][] graph,int row,int column) {
        System.out.println("\n----------------printing start ------------------\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\n----------------printing end ------------------\n");

    }
    public static boolean isRowValidated(int[][] sudoku,int i,int j,int row,int column ,Map<Integer,Boolean> hash ) {
        if(i < 0 && j <  0 && i > row && j > column ) return false;
        for (int k = 0; k < row; k++) {
            if(hash.containsKey( sudoku[i][k])) return false;
            hash.put(sudoku[i][k], true);
        }
        return true;
    }

    public static boolean columnValidate(int[][] sudoku,int i,int j,int row,int column,Map<Integer,Boolean> hash) {
        if(i < 0 && j <  0 && i > row && j > column ) return false;
        for (int k = 0; k < row; k++) {
            if(hash.containsKey( sudoku[k][j])) return false;
            hash.put(sudoku[k][j], true);
        }
        return true;
    }
    public static boolean blockValidate(int[][] sudoku,int i,int j,Map<Integer,Boolean> hash) {
        removeHashMapToFalse(hashMap);
       // System.out.println("I "+i+" J "+ j );
        if(i < 0 && j <  0 && i > ROW && j > COLUMN ) return false;

        for (int k = i; k < i + BLOCK_SIZE ; k++) {
            for (int l = j; l < j+BLOCK_SIZE; l++) {
                //System.out.println("K "+k+" l "+l );
                if(hash.containsKey( sudoku[k][l])) return false;
                hash.put(sudoku[k][l], true);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        printSudoku(sudokuObj,ROW,COLUMN);

        //row validation
        for (int j = 0; j < ROW;  j++) {
            removeHashMapToFalse(hashMap);
            if(!isRowValidated(sudokuObj,j,0,ROW,COLUMN,hashMap)){
                System.out.print("Row Not Validated Column is ["+0 +"]["+j+"] ,");
                break;
            }else{
                System.out.print("Row Validated ,");
            }
        }
        System.out.println();

        //column validation
        for (int i = 0; i < COLUMN;  i++) {
            removeHashMapToFalse(hashMap);
            if(!columnValidate(sudokuObj,0 ,i,ROW,COLUMN,hashMap)){
                System.out.print("Column Not Validated Row is [ "+i +" ][ "+ 0 +" ] ,");
                break;
            }else{
                System.out.print("Column Validated ,");
            }
        }
        System.out.println();
        //Block Validation
        for (int i = 0; i < ROW;  i+=BLOCK_SIZE) {
            for (int j = 0; j < COLUMN; j+=BLOCK_SIZE) {

                if(!blockValidate(sudokuObj,i,j,hashMap)){
                    System.out.println("Block Not Validated for  is ["+i +"]["+ j +"]");
                    break;
                }else{
                    System.out.println("Block Validated for  is [ "+i +" ][ "+ j + " ]"  );
                }

            }


        }
        System.out.println();
        System.out.println(hashMap);

    }
}
