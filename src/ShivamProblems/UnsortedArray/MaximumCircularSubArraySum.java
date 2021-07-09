package ShivamProblems.UnsortedArray;

public class MaximumCircularSubArraySum {
    public static void main(String[] args) {
         int arr[] = {2,3,-8,7,-1,2,3};
       // int [] arr ={-6,-1,-8};
       // int [] arr ={5,8,3};
        //int [] arr = {10,5,-5};
        System.out.println("output : "+ findMaximumCircularSubArraySum(arr));
    }

    private static int findMaximumCircularSubArraySum(int[] arr) {
        int max = arr[0];
        int sum =0;
        int index_curr_digit =0;
        for (int i =0 ; index_curr_digit < arr.length &&  i< 2*arr.length ;i++){
            sum  = sum+arr[i%arr.length];
            index_curr_digit ++;
            //System.out.println("Index curr digit : "+index_curr_digit);


            max = Math.max(max ,sum);
            //System.out.println("Sum "+sum+" max : "+max);
            if(sum <=0 ){
                sum =0;
                index_curr_digit  =0;
              //  System.out.println("Index curr digit : "+index_curr_digit);
            }
        }

        return max;
    }
}
