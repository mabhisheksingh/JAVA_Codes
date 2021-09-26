package leetcode.medium;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
       int[] nums ={1,3,5};//{5,1,3};//{1};// {4,5,6,7,0,1,2}; //{4,5,6,7,0,1,2}, target = 3;
        for(int i =0 ;i < nums.length;i++) {
            int target = 4;//nums[i];
            int index = search(nums,target);
            if(index == -1)
                System.out.println("Not found");
            else
                System.out.println("Index : "+index +" and value = "+nums[index]);
        }


    }

    private static int search(int[] nums, int target) {

        int high = findMax(nums,0,nums.length-1);
        int low  = (high==0) ? nums.length -1 : ( high+1 )%nums.length;
        int mid =0;
        if(nums.length==1) return (nums[0]==target)? 0:-1;
        if(nums.length==2) return (nums[0] == target)?0: (nums[1] == target)?1:-1;
        System.out.println("Max index : "+high +" max val : "+nums[high] + " and low : "+ low +" low val : "+nums[low]);
        while(low!=high){
            mid = (int)Math.ceil( (low+high)/2);
            if( low == high-1) return (nums[low] == target) ? low : (nums[high] == target)? high :-1;
            if(nums[mid] == target) return mid;
            System.out.println("Low "+low+" High "+ high+" mid "+ mid);
            if(low < high){ //normal
                if(nums[mid] < target) low = mid;
                else high = mid;
            }else { //low > high
                //System.out.println("l g h");
                if( target <= nums[nums.length -1] ){
                    high = nums.length -1;
                }else low = 0;
            }
        }
        return -1;
    }

    private static int findPivotElement(int[] arr,int n){
        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if( (mid == 0 || arr[mid - 1] <= arr[ mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return mid;
            if(mid > 0 && arr[mid]<= arr[mid - 1]  )
                high = mid -1;
            else
                low = mid + 1;
        }

        return -1;
    }

    private static int findMax(int[] arr,int low,int high){
        // If there is only one element left
        if (high == low)
            return arr[low];

        // Find mid
        int mid = low + (high - low) / 2;
        // Check if mid reaches 0 ,it is greater than next element or not
        if(mid==0 && arr[mid]>arr[mid+1])
        {
            return arr[mid];
        }

        if (arr[low] > arr[mid])
        {
            return findMax(arr, low, mid - 1);
        }
        else
        {
            return findMax(arr, mid + 1, high);
        }
    }
}
