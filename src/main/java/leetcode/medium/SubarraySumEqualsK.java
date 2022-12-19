package leetcode.medium;

import java.util.*;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int [] nums = {16 ,2, 3, 7, 15};
        int k = 15;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(14);
        List<Integer> l = (List) queue;
        Collections.reverse( l );
        List<Integer> l1 = (List) queue;

       // System.out.println("output : "+subarraySum( nums, nums.length, k ));
    }

   // public static int subarraySum(int[] nums, int k) {}
    static int subarraySum(int[] arr, int n, int sum) {
        int currentSum = arr[0], start = 0, i;
        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }
            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return 1;
            }
            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }
}
