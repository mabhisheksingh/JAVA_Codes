package ShivamProblems.sortedArray;

public class FindNoOfRepeatedElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,22,33,44,44,44,44,56};
        int element = 56;
        //find in logn times
        int leftIndex = findFirstIndexOfElement (arr,element);
        System.out.println("lef index : "+ leftIndex);
        int rightIndex = findLastIndexOfElement(arr,element);
        System.out.println("right index : "+ rightIndex);
         if( leftIndex ==-1 && rightIndex == -1){
            System.out.println("freq : "+0);
        }else {
            System.out.println("Freq : "+ (rightIndex - leftIndex+1));
        }
    }

    private static int findLastIndexOfElement(int[] arr, int element) {
        int element_Index =-1;
        int left =0,right =arr.length -1 ;
        int mid =0;
        while (left != right){
            mid = (int) Math.ceil( (left +right) /2.0);
            if (arr[mid] == element) {
                element_Index = mid;
                if(mid< right && arr[mid+1] == element){
                    left = mid;
                }else {
                    return element_Index;
                }
                continue;
            }
            if(right==1 && left ==0){
                if (element == arr[right-1]){
                    element_Index = right-1;
                }
                return  element_Index;
            }
            if(element < arr[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return -1;
    }

    private static int findFirstIndexOfElement(int[] arr, int element) {
        int element_Index =-1;
        int left =0,right =arr.length -1 ;
        int mid =0;
        while (left != right){
            mid = (int) Math.ceil( (left +right) /2.0);
            if (arr[mid] == element) {
                element_Index = mid;
                if(arr[mid-1] == element){
                    right = mid;
                }else {
                    return element_Index;
                }
                continue;
            }
            if(right==1 && left ==0){
                if(element == arr[right-1]){
                    element_Index = right-1;
                }
                return  element_Index;
            }
            if(element < arr[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return element_Index;
    }
}
