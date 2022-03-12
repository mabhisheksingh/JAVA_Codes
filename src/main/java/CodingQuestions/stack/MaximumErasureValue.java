package CodingQuestions.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaximumErasureValue {
    public static void main(String[] args) {
        int [] nums ={ 187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
                //{4,2,4,5,6};//{4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }

    private static int maximumUniqueSubarray(int[] nums) {//5,2,1,2,5,2,1,2,5
        System.out.println(nums.length);
        int left  =0;
        int localSum=0;
        HashSet<Integer> hashset = new HashSet<>();
        localSum= nums[left];
        hashset.add(localSum);
        int max = localSum;
        int right=1;
        int count = 1;
        while (left < nums.length-1 &&  right < nums.length ) {
            System.out.println(count++);
            if(!hashset.contains(nums[right]) ){
                localSum=localSum + nums[right];
                max = Math.max(max,localSum);
                hashset.add(nums[right++]);
            }else{
                localSum=localSum-nums[left];
                hashset.remove(nums[left++]);
            }
        }
        max = Math.max(localSum,max);
        return max;
    }
}
