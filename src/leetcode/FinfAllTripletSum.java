package leetcode;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:
Input: nums = []
Output: []
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinfAllTripletSum {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output = finfAllTripletSum(nums);
        System.out.println(output);
    }
    private static List<List<Integer>> finfAllTripletSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int i=0;
        int k=0;
        for(int j =1 ;j< nums.length ;j++){
            i=0;
            k = nums.length-1;
            while (i<k){
                System.out.println(i+" "+j+" "+k);
                if(i != j &&  i != k &&  j != k){
                    if( nums[i] + nums[j] + nums[k] ==0){
                        List<Integer>  temp  = Arrays.asList(i,j,k);
                        temp.sort( (a,b) ->{
                            return a.compareTo(b);
                        });
                        output.add(temp);
                    }else if(nums[i] + nums[j] + nums[k] >= 0) {
                        k--;
                    }else {
                        i++;
                    }
                }
            }
        }
        return output;
    }
}
