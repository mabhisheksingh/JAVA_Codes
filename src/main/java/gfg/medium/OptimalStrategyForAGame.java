package gfg.medium;

import utils.arrays.MyArrayUtils;

//This is working for only even length of array
public class OptimalStrategyForAGame {
    public static void main(String[] args) {
//        int A[] = {5,3,7,10};
//        int A[] = {8,15,3,7};
//        int A[] ={6335 ,2103 ,3929 ,7359 ,587 ,1551 ,3341, 1060};
        int A[] = {1,2,1,2,3};
        long output = countMaximum(A, A.length);
        System.out.println("OUTPUT "+ output);
    }
    static long countMaximum(int arr[], int n){
        // Your code here
//        long ans = countMaximum(arr,n ,0,n-1,0,0);
//        long ans = countMaximum(arr ,0,n-1);
        long ans = countMaximum(arr );
        return ans;
    }

    static long countMaximum(int [] arr){
        int dp [][]=new int[arr.length][arr.length];
        for (int i = 0; i < arr.length-1; i++) {
            dp[i][i+1] = Math.max(arr[i],arr[i+1]);
        }
        new MyArrayUtils().print2DArray(dp,"Initilize ");
        for (int gap = 3; gap < dp.length; gap+=2) {
            for (int j = 0; j+gap < dp.length; j++) {
                int k=j +gap;
                dp[j][k]= Math.max(
                   arr[j]+ Math.min(dp[j+2][k], dp[j+1][k-1]),
                   arr[k]+ Math.min(dp[j+1][k-1], dp[j][k-2])
                );
            }
        }
        new MyArrayUtils().print2DArray(dp," OUTPUT ");
        return dp[0][arr.length-1];

    }
    static long countMaximum(int [] arr, int left , int right){
        if( left > right){
            return 0;
        }
        return Math.max(
              arr[left]  + Math.min( countMaximum(arr,left+2, right ) , countMaximum(arr,left+1, right-1 ) ) ,
              arr[right] + Math.min( countMaximum(arr,left, right-2 ) , countMaximum(arr,left+1 , right-1) )
        );

    }

}
