package CodingQuestions.matrix;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {

    public static void main(String[] args) {
//        int arr[][] = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int arr[][] = {{1, 2, 3},{4,5, 6},{ 7, 8,9}};

        List<Integer> output = sprialMatrix(arr);

        System.out.println("\n********Printing Start************");
        System.out.println("m and n are size of matrix : "+arr.length+"\n");
        System.out.println(output);
    }

    private static List<Integer> sprialMatrix(int[][] arr) {
        List<Integer> output  =new ArrayList<>();
        int n = arr.length;
        int m = arr.length;
        for (int i = 0; i < arr.length/2; i++) {
            System.out.println("I "+i);
            System.out.println("left to right\n");
            //left --> right from top
            for (int j = i ; j < arr.length - i; j++) {
                int temp  =arr[i][j];
                System.out.print(temp+" ");
                output.add( temp);
            }
            System.out.println("\ntop to bottom\n");
            //top --> bottom from right
            for (int j = i + 1 ; j < arr.length-i ; j++) {
                int temp = arr[j][arr.length-1  - i ];
                System.out.print(temp +" ");
                output.add(  temp);
            }
            System.out.println("\nright to left\n");
            //right -->left  but from bottom
            for (int j = arr.length - 1 -i -1; j >=i+1 ; j--) {
                int temp =  arr[arr.length -1 -i][j];
                System.out.print(temp +" ");
                output.add(  temp);
            }
            System.out.println("\ntop to up\n");
            //top --> up but from left
            for (int j = arr.length-1 -i; j >= i+1 ; j--) {
                int temp = arr[j][i];
                System.out.print(temp +" ");
                output.add(  temp);

            }
            System.out.println();

        }

        if(arr.length % 2 !=0) output.add( arr[arr.length/2][arr.length/2]);

        return output;
    }
}
