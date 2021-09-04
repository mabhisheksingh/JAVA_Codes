package ShivamProblems.sortedArray;

/*Find position of an element in a sorted array of infinite numbers*/
public class FindElementInInfiniteArray {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,5,6,7,7,8,9,10,10};
        int element = 1; // we assume that all element be present in array or element should be <= max(element in array)
        int index = finpos(arr,element);
        if(index ==-1)
            System.out.println("Not found element");
        else
            System.out.println("Element : "+element +" and its index : "+ index);
    }

    private static int finpos(int[] arr, int element) {
        int element_index = -1;
        int low =0,high =1;
        int val = arr[low];
        while (val < element){
        //we assume that array in infinite but here we don't have infinite array that's why we use arr.length
            low = high;
            if( high*2 < arr.length){
                high = 2*high;
            }else {
                high = arr.length-1;
            }
            val = arr[high];
        }
        System.out.println("high "+ high);
        return binarySearch(arr,element,low,high);
    }

    private static int binarySearch(int[] arr, int element,int low ,int high) {
        int element_index = -1;
        int mid =0;
        if(arr[low] == element){
            element_index = low;
            return element_index;
        }
        while (low!=high){

            mid = (int)Math.ceil( (low + high )/2.0);
            if(arr[mid] == element ){
                element_index = mid;
                if(arr[mid-1] == element){
                    high = mid;
                }else {
                    return element_index;
                }
                continue;
            }
            if(arr[mid] < element){
                low = mid;
            }else {
                high = mid;
            }
        }
        return element_index;
    }
}
