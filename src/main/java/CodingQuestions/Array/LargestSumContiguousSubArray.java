package CodingQuestions.Array;

public class LargestSumContiguousSubArray {
    public static void main(String[] args) {
        int []  arr = {-5,4,6,-3,4,-1};
        System.out.println("Sum : "+largestSumContiguousSubArray(arr));
    }

    private static int largestSumContiguousSubArray(int[] nums) {
        int max = nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max( sum+nums[i],nums[i]);
            max = Math.max(sum,max);
        }
        return max;
    }

}
