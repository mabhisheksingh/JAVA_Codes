package InterviewQuestion.paytm;

public class PaytmPractice {
    public static void main(String[] args) {
        int []arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        arr = Segregate(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        
    }

    private static int[] Segregate(int[] arr) {
        int left =0;
        int right = arr.length-1;
        for (int i = 0; left <right ; i++) {
            if(arr[i]==0){
                arr = swap(arr,left,i);
                left++;
            }else{
                arr =  swap(arr,right,i);
                right--;
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int left, int i) {
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i]= temp;
        return arr;
    }
}
