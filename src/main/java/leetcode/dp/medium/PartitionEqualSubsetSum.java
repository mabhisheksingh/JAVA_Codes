package leetcode.dp.medium;

import utils.arrays.MyArrayUtils;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
//        int nums[] = {1, 5, 11, 5};
        int nums[] = {1,2,5};
        boolean output = new PartitionEqualSubsetSum().canPartition(nums);
        System.out.println("OP: " + output);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0) return false;
        else return canPartition(nums, sum / 2);
    }


    /**
     * DP solution
     */
    private boolean canPartition(int[] nums, int targetSum) {
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                } else if (i == 0) {
                    dp[i][j] = false;
                    continue;
                } else if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i-1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }

        new MyArrayUtils().print2DArray(dp, "Divide Array ");
        return dp[nums.length][targetSum];
    }

    /**
     * TLE solution
     */
    private boolean canPartition(int[] nums, int position, int sum, int targetSum) {
        if (position == nums.length || sum > targetSum) return false;
        if (sum == targetSum) return true;
        boolean a = canPartition(nums, position + 1, sum + nums[position], targetSum);
        boolean b = canPartition(nums, position + 1, sum, targetSum);
        return (a || b);
    }

}
