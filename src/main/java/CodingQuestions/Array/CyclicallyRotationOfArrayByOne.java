package CodingQuestions.Array;

public class CyclicallyRotationOfArrayByOne {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,7};
        arr = cyclicRotate(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" " );
        }
        System.out.println();
    }
    private static int[] swap(int []arr,int size,int i,int j){
        int temp = arr[i%size];
        arr[i%size] = arr[j%size];
        arr[j%size] = temp;
        return arr;
    }

    private static int[] cyclicRotate(int[] arr, int length) {
        for (int i = length-1; i >0 ; i--) {
            arr = swap(arr,length,i,i-1);
        }
        return arr;
    }
}
