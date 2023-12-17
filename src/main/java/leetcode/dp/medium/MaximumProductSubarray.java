package leetcode.dp.medium;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
//        int arr [] = {2,3,0,14};
//        int arr [] = {-1};
//        int arr [] = {-2,0,-1};
        int arr [] = {-4,-3,-2};
        int output = maxProduct(arr );
        System.out.println("Output "+ output);
    }

    private static int maxProduct(int[] nums) {
        int currMin = 1;
        int curMax = 1;
        int res = Arrays.stream(nums).max().getAsInt();
        System.out.println("res "+res);
        for (int i : nums) {
            if( i == 0 ){
                currMin =1;
                curMax=1;
                continue;
            }
            int temp = curMax * i;
            curMax =Math.max( curMax * i,Math.max( currMin* i , i) );
            currMin =Math.min( temp,Math.min( currMin* i , i) );
            res = Math.max( curMax, res );
        }
        return res;
    }
}
