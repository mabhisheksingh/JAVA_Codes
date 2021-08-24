package leetcode;

import java.util.Arrays;

// All problem in sorted rotated array
public class BinarySearchProblems {
    public static void main(String[] args) {
        {
            int[] nums = {4,5,6,7,0,1,2};//{8,9,3,4,5,6,7};//{1,2,3,4,5,6,8,9};//{9,8,7,6,5,4,3,2,1};//{5,77,88,99,3};//{5,1,3};//{1};//{4,5,6,7,8,0,1,2},
            int target = 3;
            Arrays.stream(nums).forEach(no -> System.out.print(no + " " ));
            System.out.println("\nFIND MAX : "+findMaximumElement(nums));
            System.out.println("FIND MIN : "+findMinimumElement(nums));
            System.out.println("FIND MAX Index : "+findMaximumElementIndex(nums));
            System.out.println("FIND MIN Index : "+findMinimumElementIndex(nums));
            //for(int i =0;i<nums.length;i++)
            System.out.println("FIND Target Value "+ target+" and its Index is : "+findElementInRotatedSortedArray(nums,target)  );

        }
        int[] nums = {4,5,6,7,0,1,2};//{8,9,3,4,5,6,7};//{1,2,3,4,5,6,8,9};//{9,8,7,6,5,4,3,2,1};//{5,77,88,99,3};//{5,1,3};//{1};//{4,5,6,7,8,0,1,2},
        int target = 3;
        Arrays.stream(nums).forEach(no -> System.out.print(no + " " ));
        System.out.println("\nFIND MAX : "+findMaximumElement(nums));
        System.out.println("FIND MIN : "+findMinimumElement(nums));
        System.out.println("FIND MAX Index : "+findMaximumElementIndex(nums));
        System.out.println("FIND MIN Index : "+findMinimumElementIndex(nums));
        //for(int i =0;i<nums.length;i++)
         System.out.println("FIND Target Value "+ target+" and its Index is : "+findElementInRotatedSortedArray(nums,target)  );

         //for repeated sorted rotated array
        int[] nums1 = {4,5,6,7,7,7,7,7,0,1,2};//{8,9,3,4,5,6,7};//{1,2,3,4,5,6,8,9};//{9,8,7,6,5,4,3,2,1};//{5,77,88,99,3};//{5,1,3};//{1};//{4,5,6,7,8,0,1,2},
        target = 3;
        System.out.println("FIND Element First Index Sorted Rotated Array : "+findFirstElementIndexInRotatedSortedArray(nums1 ,target));
    }
    //non repeated number
    private static int findElementInRotatedSortedArray(int [] nums , int target) {
        if(nums.length ==0) return -1;
        if(nums.length ==1 ) return  (nums[0] == target) ?  0 :-1;
        int low  = findMinimumElementIndex(nums);
        int high = findMaximumElementIndex(nums);
        while (low !=high){
            int mid = low + (high-low)/2;
            if(low  == high-1) return (nums[low] == target)? low : (nums[high] == target) ? high :-1;
            if(nums[mid]== target) return mid;
            else if ( high > low){
                if( target > nums[mid]){
                    low= mid+1;
                }else{
                    high = mid-1;
                }
            }else if( low > high){
                if(  target >= nums[low] && target <= nums[nums.length-1]){
                    high = nums.length-1;
                }else{
                    low=0;
                }
            }
            System.out.println("Low "+low+" high "+high+" Mid "+mid);
        }
        return (nums[low] == target )? low :-1;
    }

    //non repeated number
    private static int findMinimumElementIndex(int[] nums) {
        if(nums.length ==0 ) return -1;
        if(nums.length ==1 ) return 0;
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if( (mid == 0 || nums[mid] < nums[mid-1] ) &&  (mid == nums.length-1 || nums[mid] < nums[mid+1] )) {
                return mid;
            }else if( (nums[low] <= nums[mid] && nums[mid] > nums[high]) ||
                    ( nums[low] > nums[mid] && nums[mid] > nums[high] ) ){
                low = mid+1;
            }else{
                high = mid-1;
            }
            //System.out.println("Low "+low+" high "+high);
        }
        return low;
    }

    //non repeated number
    private static int findMaximumElementIndex(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid =0;
        if(high == low ) return low;
        while(low!=high){
            mid = (int)Math.ceil((low+high)/2);
            if(low == high-1) return (nums[low] > nums[high]) ? low : high;
            if( (mid == 0 || nums[mid] > nums[mid-1] ) && ( mid == nums.length-1  || nums[mid] > nums[mid+1])){
                return mid;
            }if( nums[mid] >= nums[low]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return -1;
    }

    //non repeated number
    private static int findMinimumElement(int[] nums) {
        if(nums.length ==0 ) return -1;
        if(nums.length ==1 ) return 0;
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if( (mid == 0 || nums[mid] < nums[mid-1] ) &&  (mid == nums.length-1 || nums[mid] < nums[mid+1] ) ) {
                return nums[mid];
            }else if( (nums[low] <= nums[mid] && nums[mid] > nums[high]) ||
                    ( nums[low] > nums[mid] && nums[mid] > nums[high] ) ){
                low = mid+1;
            }else{
                high = mid-1;
            }
            //System.out.println("Low "+low+" high "+high+" Mid "+mid);
        }
        return nums[low];
    }

    //non repeated number
    private static int findMaximumElement(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int mid=0;
        if(high == low ) return nums[low];

        while (low!=high){

            mid = (int) Math.ceil( low + (high - low)/2 );
            if( low == high-1) return (nums[low] > nums[high]) ? nums[low] : nums[high];
            //System.out.println("Max index : "+high +" max val : "+nums[high] + " and low : "+ low +" low val : "+nums[low]);
            if( (mid == 0  || nums[mid] > nums[mid-1] ) && ( mid == nums.length-1  || nums[mid] > nums[mid+1])   ){
                return nums[mid];
            }
            if( nums[mid] >= nums[low]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return -1;
    }

    //for repeated sorted rotated array
    private static int findFirstElementIndexInRotatedSortedArray(int[] nums , int target){
        int low =0;
        int high = nums.length-1;
        while (low!=high){
            int mid = low + (high-low)/2;
            if(low == high-1) return -1;
            if( (mid ==0 || nums[mid] != nums[mid-1]) ) return mid;
            //else if()
        }
        return -1;
    }

}
