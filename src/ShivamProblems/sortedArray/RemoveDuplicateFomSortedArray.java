package ShivamProblems.sortedArray;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateFomSortedArray {
    public static void main(String[] args) {
       // int arr[] = {1,22,22,44,55,55,55,55,99};
        int arr[] ={10,10,20};
        //removeDuplicatewithStreamApi(arr);
        arr =removeDuplicate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static int[] swaping(int [] arr,int l ,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return arr;
    }
    private static int[] removeDuplicate(int[] arr) {
        int pre_index = 0;
        int pre_index_val = arr[pre_index];
        for(int i =1 ; i < arr.length ;i++){
            if( ! ( arr[i] == pre_index_val)){
               arr = swaping(arr,pre_index+1,i);
                pre_index = pre_index+1;
                pre_index_val = arr[pre_index];
            }
        }
        for(int i =pre_index+1 ; i < arr.length ;i++){
            arr[i] = -1;
        }
        return arr;
    }

    private static void removeDuplicatewithStreamApi(int[] arr) {
         Arrays.stream(arr).distinct().forEach(System.out::println);
    }
}
