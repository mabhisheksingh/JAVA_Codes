package ShivamProblems.sortedArray;

public class FindElementInSortedAndRotatedArray {
    public static void main(String[] args) {
        //int arr[] = {40,30,30,10,20,20,22,24,26,28}; //3 rotation length =9
        int arr[] = {40,31,30,10,20,20,22,24,26,28,29} ;//l=11
        int element = 28;
        int element_Index = findElementIndex(arr,element);
        System.out.println("element "+element +" element index "+element_Index);
    }
    private static int findElementIndex(int[] arr,int element) {
        int element_index = -1;
        int low=0,high =arr.length-1;
        int mid =0;
        //int arr[] = {40,31,30,10,20,20,22,24,26,28,29} l=11
        if(element == arr[low] ) return low;
        if(element == arr[low+1] ) return low+1;
        if(element == arr[high]) return  high;
        while(low!=high  && low!=high-1){
            mid =(int) Math.ceil( (low + high)/2.0 );
            if(arr[mid] == element){
                element_index = mid;
                return element_index;
            }
            if(element > arr[mid] && element > arr[high]){
                high = mid;
            }else if(element > arr[mid] && element < arr[high]){
                low= mid;
            }else if(element < arr[mid] && element > arr[low]) {
                high = mid;
            }else if(element < arr[mid] && element < arr[low]) {
                high = mid;
            }

            System.out.println("h "+high +" l "+ low + " Mid"+mid);
        }

        return element_index;
    }
}
