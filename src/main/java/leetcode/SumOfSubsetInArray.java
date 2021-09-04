package leetcode;

import java.util.*;

public class SumOfSubsetInArray {
    private static List< List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {

        int arr[] = {1,2,4,5,9};
        int target = 7;
        SumOfSubsetInArray sumOfSubsetInArray = new SumOfSubsetInArray();
        findSubset(arr,target,new int[target],0);
        System.out.print("Input Array is : ");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]+" ");
        }
        System.out.println("\nLIST : "+list);
        System.out.println("LIST SIZE : "+list.size());

    }

    private static void findSubset(int[] arr, int target,int[] output,int sizeOfArray) {
        //base condition
        if( target < 0) return ;
        else if(target == 0 ) {
            //System.out.print("target ==  "+target+" Size of array "+sizeOfArray+" Output : ");
            List<Integer>  temp = new ArrayList<>();
            for (int i = 0; i < sizeOfArray; i++) {
                //System.out.print(output[i]+" ");
                temp.add(output[i]);
            }
           // System.out.println();
            sizeOfArray=0;
            list.add(temp);
            return ;
        }else if(target > 0 ){
            for (int j : arr) {
                if ((target - j) >= 0) {
                    output[sizeOfArray++] = j;
                    //System.out.println("Target : "+target);
                    findSubset(arr, target - j, output,sizeOfArray);
                    sizeOfArray--;
                } else continue;

            }
        }

        return ;
    }
}
