package CodingQuestions.Array;
/*
Find duplicates in O(n) time and O(1) extra space | Set 1
Given an array of n elements that contains elements from 1 to n,
with any of these numbers appearing any number of times.
Find these repeating numbers in O(n) and using only constant memory space.
* Example:

Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
Output: 1, 3, 6

Explanation: The numbers 1 , 3 and 6 appears more
than once in the array.

Input : n = 5 and array[] = {1, 2, 3, 4 ,3}
Output: 3

Explanation: The number 3 appears more than once
in the array.
* */

public class FinDuplicatesInArray {
    public static void main(String[] args) {
        int array[] = {1,3,4,2,2};
        int n = array.length;
        System.out.println("Dublicates : "+findDublicates(array));
    }

    private static int findDublicates(int[] array) {
        int dublicates =0;
        int n=array.length;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(array[i]);

            if(array[temp-1]<=0){
                    System.out.println("Dublicates  values: "+temp);
                    dublicates++;
            }else{
                array[temp-1]= -array[temp-1];
            }

        }

        return dublicates;
    }
}
