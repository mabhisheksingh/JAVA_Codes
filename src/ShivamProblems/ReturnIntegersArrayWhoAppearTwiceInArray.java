package ShivamProblems;
/*Given of arr length n ,1<=a[i]<=n and each int appear once ot twice,
return an array of all integer that appear twice.
*/
public class ReturnIntegersArrayWhoAppearTwiceInArray {
    public static void main(String[] args) {
        int arr[] = {4,3,2,7,8,2,3,1};
        //int arr[] = { 7, 3, 4, 5, 5, 3, 2 };
        int n = arr.length;
        //printTwoElements(arr, n);
         findarr(arr);
    }

    private static void findarr(int[] arr) {
        for(int i =0 ;i< arr.length;i++){
            int abs_Value = Math.abs(arr[i]);
            if (arr[abs_Value - 1] > 0) {
                arr[abs_Value -1 ] = -arr[abs_Value - 1];
            }else
                System.out.print(abs_Value+" ");
        }

    }

    static void printTwoElements(int arr[], int size)
    {
        int i;
        System.out.println("The repeating element is ");

        for (i = 0; i < size; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.println(abs_val);
        }

        System.out.println("And the missing element is ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
    }


}
