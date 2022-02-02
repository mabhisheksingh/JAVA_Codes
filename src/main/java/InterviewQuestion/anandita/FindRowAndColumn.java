package InterviewQuestion.anandita;

import java.util.ArrayList;
import java.util.List;

public class FindRowAndColumn {
    public static void main(String[] args) {
        int[][] arr = { {5, 8, 9},
                        {8, 7, 9},
                        {10, 19, 14}};

        List<Integer> output = getOutput(arr,arr[0].length);
        System.out.printf("List : "+output);
    }

    private static List<Integer> getOutput(int[][] arr,int size) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < size; j++) {
                max =Integer.MIN_VALUE;
                min=Integer.MAX_VALUE;
                for (int k = 0; k < size; k++) { //{ {5, 8, 9},
                                                  //  {8, 7, 9},
                                                  //  {10, 19, 14}};
                    //find min
                    if(min > arr[j][k]) {
                        min= arr[j][k];
                    }
                    //find max
                    if(max < arr[k][j]) {
                        max= arr[k][j];
                    }

                }
                System.out.println("max : "+max +" Min : "+min);
                if(max==min) {
                    list.add(max);
                }
            }
        //}
        return  list;
    }
}
