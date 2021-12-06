package leetcode.easy;

/*
Given a sorted array of distinct integers and a target value, return the index
if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0

Example 5:
Input: nums = [1], target = 0
Output: 0
*
* */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] nums = {1,3};//{1,3,5,7};
        int target = 2;
        int output = searchInsertPosition(nums,target);
        System.out.println("searchInsertPosition : "+output);
    }

    private static int searchInsertPosition(int []arr,int target) {
        int left =0;int right = arr.length-1;
        while (left<right){
            System.out.println("left : "+left+" right : "+right);
            int mid = left+ (right-left)/2;
            if(arr[mid] == target){
                System.out.println(mid);
                return mid;
            }else{
                if (target > arr[mid]) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        System.out.println("left : "+left+" right : "+right);
        return (arr[left] ==target)? left : (target > arr[left])?left+1:left;
    }
}
