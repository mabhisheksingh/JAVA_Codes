package CodingQuestions.Array;

public class RotateArray {
    private  static int [] arr = {1,2,3,4,5,6,7};
    static int d = 3;
    public static void main(String[] args) {
        print(arr);
        rotate(arr,0, arr.length);
      //  print(arr);
        d = d % arr.length;
        rotate(arr,0,d);
        //print(arr);
        rotate(arr,d, arr.length);
        print(arr);
    }

    public static void rotate(int[] arr, int left ,int right) {
        for (int i = left,k=0; i < left+(right- left)/2;k++, i++) {
            int temp = arr[right-1-k];
            arr[right-1-k] = arr[i];
            arr[i]=temp;
        }
    }

    public static void print(int [] args) {
        System.out.println("_____________________Printing array Start--------------- ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]+" ");
        }
        System.out.println("\n_____________________Printing array End--------------- ");
    }
}
