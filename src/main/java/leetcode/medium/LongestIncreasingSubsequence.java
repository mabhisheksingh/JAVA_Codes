package leetcode.medium;

import utils.arrays.MyArrayUtils;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//       int [] nums = {10,9,2,5,3,7,101,18};
       int [] nums = {0,1,0,3,2,3};
//       int [] nums = {1,3,6,7,9,4,10,5,6};
//       int [] nums = {0};
//       int [] nums = {1,2,2,2};


        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS( nums ));
        System.out.println("TRUE "+new LongestIncreasingSubsequence().lengthOfLISDP1( nums ));
    }
    public int lengthOfLIS(int[] nums) {
//        int [] nums = {1,3,6,7,9,4,10,5,6};
        int []tail = new int[nums.length];
        Arrays.fill(tail, Integer.MAX_VALUE);

        tail[0] = nums[0];
        int right  = 0;
        for (int i = 1; i < nums.length; i++) {
            if( tail[right]< nums[i]){
                tail[++right] = nums[i];
            }else{
                int index = getLeftSmallerIndex(tail,0, right+1, nums[i], nums);
                tail[index] = nums[i];
            }
        }
        new MyArrayUtils().print1DArray( tail, "Dp Array");
        int max = 0;
        for (int i : tail) {
            if(i == Integer.MAX_VALUE)
                break;
            max++;
        }
        return max;
    }

    private int getLeftSmallerIndex(int [] arr, int left, int right, int value, int [] nums){
        while (left < right){
            int mid = left + (right - left )/2;
            System.out.println("MID "+mid+ " Left "+left + " right "+right);
            if(arr[mid] == value) return mid;
            if( arr[mid] < value && arr[mid+1] > value )
                return mid+1;
            if(arr[mid] > value)
                right = mid;
            else
                left = mid;
        }

        return left;
    }

    public int lengthOfLISDP1(int[] nums) {
        int []dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        new MyArrayUtils().print1DArray( dp, "Dp Array");
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max( max,i );
        }
        return max;
    }
}
