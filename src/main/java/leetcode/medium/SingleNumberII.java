package leetcode.medium;

public class SingleNumberII {

    public static void main(String[] args) {
        int [] nums = {2,3,2,2};
        System.out.println( "output : "+ singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
       int ones =0;
       int tows =0;
       for (int num : nums) {
            ones = (ones ^ num) & ~tows;
            tows = (tows ^ num) & ~ones;

           System.out.println("a "+ones+" twoes "+tows);
       }

        return ones;
    }
}
