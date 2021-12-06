package leetcode.medium;

public class SortColors {
    public static void main(String[] args) {
        int [] arr = {1,2,0};
        //sortColors(arr);
        //sortColors(arr);

    }
    private static void sortColors(int[] arr) {
        if (arr.length == 1 || arr.length==0) return;
        int left = 0;
        int right = arr.length-1;
        int index=0;
        while(index<=right && left < right) {
           if (arr[index] == 0) {
                arr[index] = arr[left];
                arr[left]=  0;
                left++;
                index++;
           }else if(arr[index]==2) {
               arr[index] = arr[right];
               arr[right]=  2;
               right--;
           }else{
               index++;
           }
        }


        for (int output : arr)
            System.out.print(output+" ");
    }
}
