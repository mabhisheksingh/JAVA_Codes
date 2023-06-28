package leetcode.medium;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is a subarray where:
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * Example 1:
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * Example 2:
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * Example 3:
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int [] nums = {23,2,4,6,9};
        int k = 6;
//        int [] nums = {1,3,6,0,9,6,9};
//        int k = 7;
        System.out.println("Output : "+ checkSubarraySum(nums,k));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum =0;
        hashMap.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(  sum %k == 0 && i>0)  return true;
            if( !hashMap.containsKey( sum % k)  ){
                hashMap.put(sum%k ,i );
            }else if(i - hashMap.get( sum % k) >1 ){
                return true;
            }
        }
        return false;
    }
}
