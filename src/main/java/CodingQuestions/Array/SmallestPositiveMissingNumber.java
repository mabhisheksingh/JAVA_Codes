package CodingQuestions.Array;
/*You are given an unsorted array with both positive and negative elements. You have to find the smallest
positive number missing from the array in O(n) time using constant extra space.
You can modify the original array.

Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2
*/
public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int [] arr = {2, 3, 7, 6, 8, -1, -10, 15,1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int output = findSPMN(arr,arr.length);
        System.out.println("\nOutput : "+output);
    }

    private static int findSPMN(int[] arr, int n) {
        int ptr = 0;

        // Check if 1 is present in array or not
        for(int i = 0; i < n; i++)
        {
            if (arr[i] == 1)
            {
                ptr = 1;
                break;
            }
        }

        // If 1 is not present
        if (ptr == 0)
            return (1);

        // Changing values to 1
        for(int i = 0; i < n; i++)
            if (arr[i] <= 0 || arr[i] > n)
                arr[i] = 1;

       /* for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }*/
        System.out.println();
        // Updating indices according to values
        for(int i = 0; i < n; i++)
            arr[(arr[i] - 1) % n] += n;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        // Finding which index has value less than n
        for(int i = 0; i < n; i++)
            if (arr[i] <= n)
                return (i + 1);

        // If array has values from 1 to n
        return (n + 1);
    }

}
