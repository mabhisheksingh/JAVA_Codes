package ShivamProblems;

import java.util.Arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
       // int arr[] = {2,3,-8,7,-1,2,3};
        //int [] arr ={-6,-1,-8};
        //int [] arr ={5,8,3};
        int [] arr = {10,5,-5};
      //Arrays.stream(arr).forEach(System.out::print);
        System.out.println("output  :"+findMaximumSumSubArray(arr));
        System.out.println("output optimize  : "+findMaximumSumSubArrayOptimize(arr));
    }
    //n^2 time complexity
    private static int findMaximumSumSubArray(int[] arr) {
        int max =arr[0];
        for(int i =0;i< arr.length;i++){
            int sum =arr[i];
            max =Math.max(max ,sum);
            for(int j = i+1 ;j< arr.length ; j++){
                sum = sum + arr[j];
                max =Math.max(max ,sum);
            }
        }
        return max;
    }

    //n time complexity
    private static int findMaximumSumSubArrayOptimize(int[] arr){
        int max = arr[0];
        int sum =0;
        for(int i =0;i< arr.length;i++){
            sum = sum + arr[i];
            max = Math.max( max,sum);
            if(sum <= 0) sum =0;
        }
        return max;
    }

}
