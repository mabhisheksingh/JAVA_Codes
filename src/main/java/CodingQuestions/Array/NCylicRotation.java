package CodingQuestions.Array;

public class NCylicRotation {

    /*
    * How to rotate array left right
    * First Step is reverse the array
    * Rotate again 0--> len- rotationCount & len- rotationCount--> len [for left rotation]
    * Rotate again 0--> len- rotationCount & len- rotationCount--> len [for left rotation]

    */


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,7}; //!--> left rev [7,5,4,3,2,1] left output  [5,7,1,2,3,4] right [3,4,5,7,1,2]
        int arrRight[] = {1,2,3,4,5,7};
        int rotationCount = 8;
        rotationCount = rotationCount % arr.length;

        arr = reverse( arr , 0, arr.length );
                

        //! Rotating array left
        arr = reverse( arr , 0, arr.length - rotationCount  );
        arr = reverse( arr , arr.length - rotationCount , arr.length );

        System.out.println("Rotating left\n");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" " );
        }
        System.out.println();
        System.out.println("Rotating Right\n");
        //! Rotating array Right

        arrRight = reverse( arrRight , 0, arrRight.length );
        
        arrRight = reverse( arrRight , 0, rotationCount  );
        arrRight = reverse( arrRight , rotationCount , arrRight.length );

        for (int i = 0; i < arrRight.length; i++) {
            System.out.print(arrRight[i]+" " );
        }
        System.out.println();
    }

    /**
     * The function reverses a portion of an integer array between two given indices.
     * 
     * @param arr an integer array that needs to be reversed
     * @param i The starting index of the subarray to be reversed.
     * @param j The parameter "j" represents the ending index of the subarray that needs to be
     * reversed.
     * @return The method is returning an integer array that has been reversed between the indices i
     * and j.
     */
    private static int[] reverse(int []arr, int i , int j) {

        for (int k = i ; k  < (i + (j-i)/2)  ; k++) {
            int temp  = arr[ j - 1 - (k - i) ];
            arr[ j - 1 - (k - i)  ] = arr[k];
            arr[k] =  temp;
        }

        return arr;
    }
    
}
