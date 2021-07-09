package ShivamProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PushZerosAtTheEndOfArray {
    public static void main(String[] args) {
        //int arr[] ={1,0,2,0,3,0,0,0,0,55,0};
        int arr[] ={10,10,20};
        arr = pushZerosAtTheEndOfArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static int[] swaping(int [] arr,int l ,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return arr;
    }
    private static int[] pushZerosAtTheEndOfArray(int[] arr) {
        int zero_index = 0;
        int flag = 0;
        int count_zero =0;
        for (int i =0;i< arr.length;i++){
            if(arr[i] == 0){
                if(flag == 0){
                    zero_index = i;
                    flag =1;
                }
                count_zero++;
               continue;
            }else if(arr[i] != 0 && i > zero_index ){
                swaping(arr,zero_index,i);
                zero_index =zero_index +1;
            }
        }
        /*for (int i : arr){
            System.out.print(i+" ");
        }*/

        for (int i = arr.length-1 ;count_zero>0;i--) {
            arr[i] = 0;
            count_zero--;
        }
       // System.out.println("count  : "+ count_zero);
        return arr;
    }
}
