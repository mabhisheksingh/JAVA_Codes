package ShivamProblems.UnsortedArray;

public class FindMaximumSeqOf1InArray {
    public static void main(String[] args) {
       // int []arr = {1,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,0,1};
        int []arr = {1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,0,1};
        ///int arr[] = {0,0,0,0};
        System.out.println("max Seq : "+findmaxseqlenOptimize(arr));
    }

    private static int findmaxseqlen(int[] arr) {
        if(arr.length == 1) return (arr[0] == 1) ? 1 : 0;
        int count =0;
        int max =0;
        for(int i=1 ;i <arr.length;i++ ){
            if(arr[i-1] == arr[i]){
                count++;
            }else {
                if(max < count) {
                    max = count;
                    count = 0;
                }
            }
        }
        return max;
    }

    private static  int findmaxseqlenOptimize(int [] arr){
        if(arr.length == 1) return (arr[0] == 1) ? 1 : 0;
        int count =0;
        int max =0;
        for(int i=0 ;i <arr.length;i++ ){
            if(arr[i] == 0) count++;
            else {

            }
        }
        return max;
    }
}
