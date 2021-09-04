package ShivamProblems;

public class MaximumLengthEvenOddSubarray {
    public static void main(String[] args) {
        int []arr = {10,12,14,7,8};
        //int []arr = {7,10,13,14};
        //int []arr = {10,12,8,4};
        System.out.println("Output : "+ maxEvenOddSubArray(arr));
    }

    private static int maxEvenOddSubArray(int[] arr) {
        int max = 1;
        int count_even_odd_length = 1;
        for (int i=1;i<arr.length;i++){
            if(arr[i]%2!=0 && arr[i-1]%2==0){
                count_even_odd_length++;
            } else if (arr[i]%2==0 && arr[i-1]%2!=0) {
                count_even_odd_length++;
            }else{
                count_even_odd_length =1;
            }

            max = Math.max(count_even_odd_length,max);
        }
        return max;
    }
}
