package gfg.medium;

import utils.arrays.MyArrayUtils;

public class MinimumNumberOfJump {

    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int arr2[] = {2,3,1,1,4};
        int arr3[] = {2,3,0,1,4};
        int arr4[] = {1,2,3};
        int arr5[] = {3,2,1};
        int arr6[] = {1,2,1,1,1};
        int arr7[] = {10,9,8,7,6,5,4,3,2,1,1,0};
        int arr8[] = {1,1,1,1};
//        System.out.println(minJumps(arr1));
//        System.out.println(minJumps(arr2));
//        System.out.println(minJumps(arr3));
//        System.out.println(minJumps(arr4));
//        System.out.println(minJumps(arr5));
        System.out.println(minJumpsTLE(  arr7, arr7.length  ));
        System.out.println(minJumpsTLE(  arr8 ,arr8.length ));
        System.out.println(minJumpsDP(  arr8  ));
//        System.out.println(minJumps(arr7));
    }

    static int minJumpsTLE(int[] arr,int len) {
        if(len == 1 ) return 0; //Edge case
        int min = Integer.MIN_VALUE-1;
        for (int i = 0; i < len-1; i++) {
            if( i+ arr[i] >= len-1){
                int tempMin = minJumpsTLE( arr , i+1);
                if( tempMin != min){
                    min = Math.min( min ,tempMin+1);
                }
            }
        }

        return min;
    }
    static int minJumpsDP(int[] arr) {
        new MyArrayUtils().print1DArray(arr," INPUT JUMEGAME 2 ");
        int []dp = new int[arr.length];
        if(arr.length == 1 ) return 0; //Edge case
        for (int i = 1; i < arr.length; i++) {
            dp[i]= Integer.MAX_VALUE-1;
        }
        for (int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE-1;
            for (int j = 0; j < i; j++) {
                if( j+ arr[j] >= i){
                   min = Math.min( min, dp[j]);
                }
            }
            dp[i] =min+1;
        }

        new MyArrayUtils().print1DArray(dp," JUMEGAME 2 ");
        return dp[arr.length-1];
    }

    static int getMaxIndex(int [] arr, int from, int to){
        System.out.println("from "+from + " to "+to);
        int maxIndex=from;
        for (int i = from; i <=to && i < arr.length; i++) {
            if( arr[i] >= arr[ maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
