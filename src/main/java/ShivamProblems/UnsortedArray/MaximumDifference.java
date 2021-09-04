package ShivamProblems.UnsortedArray;

public class MaximumDifference {
    public static void main(String[] args) {
        //int []arr = {2,3,10,6,4,8,1};
       // int []arr = {2,3,10,6,4,8,1,11};
        int []arr = {30,20,10,8}; //-2
        System.out.println("Max Diff : "+ findmadDif(arr));
    }

    private static int findmadDif(int[] arr) {
        int maxdiff = arr[1] - arr[0];
        int minVal = arr[0];
        for (int i = 1 ; i < arr.length;i++){
            maxdiff = Math.max(maxdiff ,arr[i]- minVal );
            minVal = Math.min( minVal,arr[i] );
        }
        return maxdiff;
    }

}
