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
import java.util.HashMap;
import java.util.List;

public class FindAllTripletSum {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1,-4};
        //nums= removeDups(nums, nums.length);
       // Arrays.stream(nums).forEach(System.out::print);
       // System.out.println();
        List<List<Integer>> output = finfAllTripletSum(nums);
        System.out.println(output);
    }

    static int [] removeDups(int[] arr, int n) {

        // Hash map which will store the
        // elements which has appeared previously.
        HashMap<Integer,Boolean> mp = new HashMap<>();

        for (int i = 0; i < n; ++i)
        {// Print the element if it is not
            // there in the hash map
            if (mp.get(arr[i]) == null)
            // Insert the element in the hash map
            mp.put(arr[i], true);
        }
        arr = new int[mp.size()];
        int k=0;
        for(Integer i : mp.keySet()){
            arr[k++] = i;
        }
        return arr;
    }


    private static List<List<Integer>> finfAllTripletSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int i=0;
        int k=0;
        for(int j =1 ;j< nums.length ;j++){
            i=0;
            k = nums.length-1;
            while (i<k && i>=0 && k>=0 ){
                System.out.println(i+" "+j+" "+k);
                if(i != j &&  i != k &&  j != k){
                    if( nums[i] + nums[j] + nums[k] ==0){
                        List<Integer>  temp  = Arrays.asList(i,j,k);
                        temp.sort( (a,b) ->{
                            return a.compareTo(b);
                        });
                        System.out.println("temp "+temp);
                        output.add(temp);
                    }else {
                        i++;
                    }
                }else if( i==j) i++;
                else if( j==k ) k--;
            }
        }
        return output;
    }
}
