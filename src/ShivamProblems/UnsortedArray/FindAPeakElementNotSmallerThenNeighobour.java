package ShivamProblems.UnsortedArray;

public class FindAPeakElementNotSmallerThenNeighobour {
    public static void main(String[] args) {
        //int []arr = {6,6,6,5,23,90,6};
        int []arr = {1,5};
        int []arr1 = {15,20,19,50,51,52,55};

        int index1 = getPeak(arr,arr.length);
        System.out.println("Value : "+arr[index1]);
    }

    static int getPeak(int arr[], int n) {
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
