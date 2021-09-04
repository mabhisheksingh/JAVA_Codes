package leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {3,1,4};
        int arr2[] = {2};

        mergearr(arr1,arr2);
    }

    private static void mergearr(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int arr[] =  new int[arr1.length + arr2.length];
        int a1=0,a2 =0,index=0;
        while(a1<arr1.length && a2 < arr2.length){
            if(arr1[a1]<arr2[a2]){
                arr[index++]=arr1[a1];
                a1++;
            }else{
                arr[index++]=arr2[a2];
                a2++;
            }
        }
        for(int i = a1 ; i< arr1.length;i++){
            arr[index++] = arr1[i];
        }
        for(int i = a2 ; i< arr2.length;i++){
            arr[index++] = arr2[i];
        }

        Arrays.stream(arr).forEach(System.out::print);
        System.out.println(index);
    }
}
