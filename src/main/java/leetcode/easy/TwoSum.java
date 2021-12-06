package leetcode.easy;
import java.util.HashMap;
import java.util.Map;
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,2,5,3};//{2,7,11,15};
        int target = 6;//9;
        int []arr1 = twoSumOptimized(arr,target);
        System.out.println("Optimized output:["+arr1[0]+","+arr1[1]+"]");
    }

    private static int[] twoSumOptimized(int[] arr, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        int []output = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int completed = target-temp;
            if ( hash.containsKey(completed)) {
                output[0] = i;
                output[1] = hash.get(completed);
            }
            hash.put(arr[i],i);
        }
        return output;
    }
}
