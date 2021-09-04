package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class KthLargestElementIAnArray {
    public static void main(String[] args) {
        int[] nums ={3,2,1,5,5,6,4};// {3,2,3,1,2,4,5,5,6};//
        int k = 2;
        System.out.println("findKthLargest "+findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        TreeMap<Integer,Integer> treehash = new TreeMap<>();
        int size=0;
        for(int i=0;i< nums.length;i++){

            if(treehash.containsKey(nums[i])){
                int temp = treehash.get(nums[i]);
                temp+=1;
                treehash.put(nums[i],temp);
            }else{
                treehash.put(nums[i],1);
            }
        }
        System.out.println(treehash +" K "+ k);
        size= treehash.size();
        System.out.println(" hash Size "+size+" nums len "+nums.length);
        k = nums.length-k;
        for(Map.Entry<Integer, Integer> key : treehash.entrySet()){
            k = k-key.getValue();
            if( k<0){
                return key.getKey();
            }
        }

        return -1;
    }
}
