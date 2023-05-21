package leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int [] nums = {16 ,8, 2, 5, 15};
        // int [] nums = {0,0,0,0};
        int k = 15;
       System.out.println("output : "+subArraySum( nums, k ));
    }

   // public static int subarraySum(int[] nums, int k) {}
    static int subArraySum(int[] arr,int k) {
        int count = 0;
        HashMap <Integer,Integer> hashMap = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if( curSum == k ) count++;
            if( hashMap.containsKey( curSum - k)) {
                count+= hashMap.get(curSum - k );
                hashMap.put(curSum , hashMap.get(curSum - k ) + 1 );
                
            }else
                hashMap.put(curSum, 1);
        }

        return count;
    }
}


