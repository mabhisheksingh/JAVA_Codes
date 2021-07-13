package ShivamProblems.UnsortedArray;

public class FindAPeakElementNotSmallerThenNeighobour {
    public static void main(String[] args) {
        //int []arr = {6,6,6,5,23,90,6};
        int []arr = {1,5};
        int []arr1 = {15,20,19,50,51,52,55};
        int index = findPeakElement(arr);
        int index1 = getPeak(arr,arr.length);
        System.out.println("Value : "+arr[index]);
        System.out.println("Value : "+arr[index1]);
    }

    private static int findPeakElement(int[] arr) {
        int element_index=-1;
        int low =0,high = arr.length-1;
        int mid =0;
        while (low <=high){
            mid = (low+high)/2;
            if(mid ==0 || (arr[mid-1]<= arr[mid]) && ( mid == arr.length-1 || ( arr[mid+1] <= arr[mid]) )){
                return mid;
            }
            if(mid>0  && arr[mid-1] >= arr[mid]){
                high = mid-1;
            }else
                low = mid+1;
        }
        return element_index;
    }
    public int findPeakElementLeetCode(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    static int getPeak(int arr[], int n)
    {
        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if( (mid == 0 || arr[mid - 1] <= arr[ mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return mid;
            if(mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid -1;
            else
                low = mid + 1;
        }

        return -1;
    }



}
