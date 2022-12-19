package graph;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static final int ROW = 9;
    public static final int COLUMN = 9;
    public static final int BLOCK_SIZE = 3;
    public static boolean isRowValidated(char[][] sudoku, int i, int j, int row, int column , Map<Character,Boolean> hash ) {
        if(i < 0 && j <  0 && i > row && j > column ) return false;
        for (int k = 0; k < row; k++) {
            if( sudoku[i][k] == '.')  continue;
            if(hash.containsKey( sudoku[i][k])) return false;
            hash.put(sudoku[i][k], true);
        }
        return true;
    }
    public static boolean columnValidate(char[][] sudoku,int i,int j,int row,int column,Map<Character,Boolean> hash) {
        if(i < 0 && j <  0 && i > row && j > column ) return false;
        for (int k = 0; k < row; k++) {
            if( sudoku[k][j] == '.')  continue;
            if(hash.containsKey( sudoku[k][j])) return false;
            hash.put(sudoku[k][j], true);
        }
        return true;
    }
    public static boolean blockValidate(char[][] sudoku,int i,int j,Map<Character,Boolean> hash) {
        hash.clear();
        if(i < 0 && j <  0 && i > ROW && j > COLUMN ) return false;
        for (int k = i; k < i + BLOCK_SIZE ; k++) {
            for (int l = j; l < j+BLOCK_SIZE; l++) {
                //System.out.println("K "+k+" l "+l );
                if( sudoku[k][l] == '.')  continue;

                if(hash.containsKey( sudoku[k][l])) return false;
                hash.put(sudoku[k][l], true);
            }
        }
        return true;
    }
    public static final char CharBoad [][]  =  {{'5','3','.','.','7','.','.','.','.'},
                                            {'6','.','.','1','9','5','.','.','.'}
                                            ,{'.','9','8','.','.','.','.','6','.'}
                                            ,{'8','.','.','.','6','.','.','.','3'}
                                            ,{'4','.','.','8','.','3','.','.','1'}
                                            ,{'7','.','.','.','2','.','.','.','6'}
                                            ,{'.','6','.','.','.','.','2','8','.'}
                                            ,{'.','.','.','4','1','9','.','.','5'}
                                            ,{'.','.','.','.','8','.','.','7','9'}};

    public static final char CharBoad1 [][] =  {{'8','3','.','.','7','.','.','.','.'}
                                            ,{'6','.','.','1','9','5','.','.','.'}
                                            ,{'.','9','8','.','.','.','.','6','.'}
                                            ,{'8','.','.','.','6','.','.','.','3'}
                                            ,{'4','.','.','8','.','3','.','.','1'}
                                            ,{'7','.','.','.','2','.','.','.','6'}
                                            ,{'.','6','.','.','.','.','2','8','.'}
                                            ,{'.','.','.','4','1','9','.','.','5'}
                                            ,{'.','.','.','.','8','.','.','7','9'}};
    public static void main(String[] args) {
        System.out.println("Board "+isValidSudoku(CharBoad)); //true
        System.out.println("Board1 "+isValidSudoku(CharBoad1)); //true
    }
    public static boolean isValidSudoku(char[][] board) {
        Map<Character,Boolean> hash = new HashMap<>();
        //Row Validation
        for (int i = 0; i < ROW; i++) {
            hash.clear();
            if(!isRowValidated(board,i,0,ROW,COLUMN,hash)) return false;
        }
        //Column Validation
        for (int i = 0; i < ROW; i++) {
            hash.clear();
            if(!columnValidate(board,0,i,ROW,COLUMN,hash)) return false;
        }
        //Block validation
        for (int i = 0; i < ROW;  i+=BLOCK_SIZE) {
            for (int j = 0; j < COLUMN; j+=BLOCK_SIZE) {
                if(!blockValidate(board,i,j,hash)) {
                    //System.out.println("Block Not Validated for  is [" + i + "][" + j + "]");
                    return false;
                }
            }
        }



//        //row validation
//        for (int j = 0; j < ROW;  j++) {
//            hash.clear();
//            if(!isRowValidated(board,j,0,ROW,COLUMN,hash)){
//                System.out.print("Row Not Validated Column is ["+0 +"]["+j+"] ,");
//                break;
//            }else{
//                System.out.print("Row Validated ,");
//            }
//        }
//        System.out.println();
//
//        //column validation
//        for (int i = 0; i < COLUMN;  i++) {
//            hash.clear();
//            if(!columnValidate(CharBoad,0 ,i,ROW,COLUMN,hash)){
//                System.out.print("Column Not Validated Row is [ "+i +" ][ "+ 0 +" ] ,");
//                break;
//            }else{
//                System.out.print("Column Validated ,");
//            }
//        }
//        System.out.println();
//        //Block Validation
//        for (int i = 0; i < ROW;  i+=BLOCK_SIZE) {
//            for (int j = 0; j < COLUMN; j+=BLOCK_SIZE) {
//
//                if(!blockValidate(CharBoad,i,j,hash)){
//                    System.out.println("Block Not Validated for  is ["+i +"]["+ j +"]");
//                    break;
//                }else{
//                    System.out.println("Block Validated for  is [ "+i +" ][ "+ j + " ]"  );
//                }
//
//            }
//
//
//        }
//        System.out.println();
//        System.out.println(hash);
        return true;
    }
}
