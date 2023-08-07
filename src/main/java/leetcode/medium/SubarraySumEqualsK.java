package leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
//        int [] nums = {16 ,8, 2, 5, 15};
//        int k = 15;
         int [] nums = {0,0,0,0,0,0,0,0,0,0};
        int k = 0;
//        int [] nums = {1,2,1,2,1};
//        int k = 3;
       System.out.println("output : "+subArraySum( nums, k ));
    }


    static int subArraySum(int[] arr,int k) {
        int count = 0;
        HashMap <Integer,Integer> hashMap = new HashMap<>();
        int currSum =0;
        for (int i = 0; i < arr.length; i++) {
            currSum+=arr[i];

            //sum present from starting index
            if(currSum == k) {
               count++;
            }

            count+= hashMap.getOrDefault(currSum-k , 0);
            hashMap.put(currSum,hashMap.getOrDefault(currSum , 0) +1 );
        }
        System.out.println(hashMap);

        return count;
    }
}


