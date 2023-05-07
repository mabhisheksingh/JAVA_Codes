package leetcode.medium;


import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> list= subsets(nums);
        System.out.println("List : "+list);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer> > output = new ArrayList<>();
        int size = (int)Math.pow(2 , nums.length) - 1 ;
        while( size >= 0){
            int tempNumber =  size;
            List<Integer> list = new ArrayList<>();
            int index=0;
            while( tempNumber  != 0 ){
                int temp = tempNumber % 2 ;
                tempNumber = tempNumber / 2;
                if( temp != 0 ) list.add(nums[index]);
                index ++;
            }
            output.add( list);
            size--;
        }
        return output;
    }
}
