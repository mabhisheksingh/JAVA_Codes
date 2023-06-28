package CodingQuestions.matrix;

public class rotate90Degree {

    public static void main(String[] args) {
//        int arr[][] = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int arr[][] = {{1, 2, 3},{4,5, 6},{ 7, 8,9}};

        int output [][] = rotate90DegreeAntiClockWise(arr);

        System.out.println("\n********Printing Start************");
        System.out.println("m and n are size of matrix : "+arr.length+"\n");
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                System.out.printf(output[i][j]+" ");
            }
            System.out.println();

        }
    }

    private static int[][] rotate90DegreeAntiClockWise(int[][] arr) {
        int output [][] = new int[arr.length][arr.length];
        int n = arr.length;
        int m = arr.length;
        for (int i = m-1 ; i >=0; i--) {
            for (int j = 0; j < m; j++) {
                output[m - 1 - i ][j] = arr[j][i];
            }
        }

        return output;
    }


}
