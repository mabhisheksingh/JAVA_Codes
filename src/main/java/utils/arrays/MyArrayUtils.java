package utils.arrays;

public class MyArrayUtils<T> {

    public void print2DArray(T [][]matrix,String obj){
        System.out.println("\n****** Printing start for "+ obj+" ********");
        for (T [] row : matrix){
            for( T item : row){
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        System.out.println("\n****** printing End for "+ obj+" ********");

    }
    public void print2DArray(int [][]matrix,String obj){
        System.out.println("\n****** Printing start for "+ obj+" ********");
        for (int [] row : matrix){
            for( int item : row){
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        System.out.println("\n****** printing End for "+ obj+" ********");

    }
    public void print2DArray(boolean [][]matrix,String obj){
        System.out.println("\n****** Printing start for "+ obj+" ********");
        for (boolean [] row : matrix){
            for( boolean item : row){
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        System.out.println("\n****** printing End for "+ obj+" ********");

    }
}
