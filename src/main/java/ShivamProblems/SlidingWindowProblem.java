package ShivamProblems;
/*
[1, 8, 30, -5, 20, 7] K=3
 O/P - 45

[5, -10, 6, 90, 3] K=2
O/P - 96

You have to take K consecutive elements sum... and find out the maximum sum
*/
public class SlidingWindowProblem {
    public static void main(String[] args) {
        //int []arr = {1, 8, 30, -5, 20, 7};
        int []arr = {5, -10, 6, 90, 3};
        int k=2;
        findMax(arr,k);
    }

    private static void findMax(int[] arr, int k) {
        int max =0;
        int sum=0;
        int temp_k = k;
        if(arr.length < k){
            System.out.println("Not Possible");
        }else {
            for (int i = 0 ; i< k ;i++){
                max = max+arr[i];
                sum+=arr[i];
            }
            for(int i=k;i< arr.length ;i++){
                max = Math.max(max , sum-arr[i-k]+arr[i]);
                sum =  sum-arr[i-k]+arr[i];
            }
        }
        System.out.println("MAX : "+max);
    }
}
