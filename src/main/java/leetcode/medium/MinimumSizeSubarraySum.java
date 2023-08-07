package leetcode.medium;

/*
* Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
*
* Constraints:

    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104
*
*
Tags
array | two-pointers | binary-search

Companies
facebook
* */

//209. Minimum Size SubArray Sum
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
//        int target = 7;
//        int []nums = {2,3,1,2,4,3};
        int target = 11;
//        int []nums = {1,1,1,1,1,1,1,1};

        int []nums = {1,2,3,4,5};
        System.out.println("Output : "+ minSubArrayLen(target,nums));
    }

    //two pinter approach
    private static int minSubArrayLen(int target, int[] nums) {
        int subArrLen =Integer.MAX_VALUE;
        int i=0;
        int j=1;
        int sum =nums[0];
        int count =1;
        while (i < j) {

            //** Checking sum is greater than target
            if( sum >= target){
                if( subArrLen > count )
                    subArrLen=count;
            }
            if(j < nums.length && sum < target) {
                sum+= nums[j];
                j++;
                ++count;
            }
            else{ // sum > target
                sum = sum - nums[i];
                i++;
                --count;
            }
        }
        if( subArrLen == Integer.MAX_VALUE)
            return 0;
        return subArrLen;
    }
}
