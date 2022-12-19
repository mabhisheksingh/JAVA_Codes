package Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class ClosetElementInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,6,7,8,9,90};
        int k=3;
        int element = findNearestElementN(arr,k);
        System.out.printf("Closet element "+element);
    }

    private static Pair findNearestElement(int arr[],  int k) {
        int low = 0;
        int high = arr.length-1;
        int left =Integer.MIN_VALUE;
        int right =Integer.MIN_VALUE;
        int curr = Integer.MIN_VALUE;
        int tempIndex  = -1;
        int tempval = -1;
        Pair pair = new Pair();
        while (low < high){
            int mid = low + (high - low )/2;
            System.out.println("Low "+low + " High : "+high+" Mid "+ mid + " Val "+arr[mid]+ " k "+k);
            if( arr[mid ] == k){
                pair.index = mid;
                pair.val = arr[mid];
                return pair; //left
            }
            curr = ( k - arr[mid]);
            // int[] arr = {1,2,3,4,6,7,8,9,90};
            if (mid - 1 > 0) {
                left =(k - arr[mid-1]);
            }if (mid + 1 < arr.length) {
                right = ( k - arr[mid+1]);
            }
            if( left > right){
                high = mid -1;
            } if( left < right){
                low = mid +1;
            }
           if( ( left < right) && ( left < curr) ){
               tempval = arr[mid+1];
               tempIndex = mid+1;
           }if( ( right < left) && ( right < curr) ){
               tempval = arr[mid-1];
               tempIndex = mid-1;
           }if( ( curr < right) && ( curr < left) ){
               tempval = arr[mid];
               tempIndex = mid;
           }
           if( pair.val >tempval){
               pair.val = tempval;
               pair.index = tempIndex;
           }

        }

        System.out.println("Outside Low "+low + " High : "+high+" Left "+left +" right "+right);
        System.out.println(pair);
        return pair ;
    }

    private static int findNearestElementN(int arr[],  int k) {
        int low = 0;
        int high = arr.length-1;
        Pair pair = new Pair();
        //corner case
        if( k <= arr[low]){
            return arr[low];
        } else if (k >= arr[high] ) {
            return arr[high];
        }
        int left =  Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int mid =-1;
        while (low < high){
            mid = low + (high - low )/2;
            if( arr[mid ] == k){
                pair.val = arr[mid];
                pair.index = mid;
                return arr[mid];
            }
            if (k < arr[mid]) {
                if (mid > 0 && k > arr[mid - 1])
                    return getClosest(arr[mid - 1], arr[mid], k);
                high = mid;
            }
            else {
                if (mid < arr.length-1 && k < arr[mid + 1])
                    return getClosest(arr[mid],arr[mid + 1], k);
                left = mid + 1; // update i
            }
        }
        return arr[mid] ;
    }

    public static int getClosest(int val1, int val2,
                                 int target)
    {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }
}

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
class Pair{
    int val=0;
    int index=0;

}
