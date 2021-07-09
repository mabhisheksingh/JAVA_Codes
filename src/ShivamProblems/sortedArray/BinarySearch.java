package ShivamProblems.sortedArray;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,22,33,44,44,44,44,56};
        int element = 0;
        int index= findElementIndex(arr,element);
        System.out.println("Element : "+ element+" and its Index is   :"+index);
    }
    private static int findElementIndex(int[] arr,int element) {
        int left= 0, right= arr.length -1;
        int mid =0;
        int element_index=-1;
        while (left != right){
            mid = (int)Math.ceil( (left + right) /2.0);
            if(arr[mid] == element){
                System.out.println("l "+left+ " r "+right+ " mid "+mid);
                element_index = mid;
                if( arr[mid-1] == element){
                    right = mid;
                }else{
                    return element_index;
                }
                continue;
            }
            System.out.println("l "+left+ " r "+right+ " mid "+mid);
            if(right==1 && left ==0){
                if (element == arr[right-1]){
                    element_index = right-1;
                    return  element_index;
                }else {
                    return element_index;
                }
            }
            if ( element < arr[mid] ) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return element_index;
    }
}
