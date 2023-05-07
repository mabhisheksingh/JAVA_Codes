package CodingQuestions.Array;

public class MoveZerostoEnd {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,0,0,5,0,7,0};

        arr = movingZero(arr);

        System.out.println("Moving Zero\n");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" " );
        }
        System.out.println();
    }

    /**
     * The function moves all the zeros in an integer array to the end while maintaining the order of
     * the non-zero elements.
     * 
     * @param arr an integer array that may contain zeros.
     * @return The method is returning an integer array with the same elements as the input array, but
     * with all the zeros moved to the end of the array while maintaining the order of the non-zero
     * elements.
     */
    private static int[] movingZero(int[] arr) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] != 0){
                
                if( flag){
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp; 
                }
                count++;
                continue;
            }
            flag = true;
        }
        return arr;
    }
    
}
