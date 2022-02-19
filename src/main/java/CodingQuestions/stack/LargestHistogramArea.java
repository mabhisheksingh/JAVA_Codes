package CodingQuestions.stack;

import java.util.ArrayDeque;

public class LargestHistogramArea {
    static int [] arr ={2,1,5,6,2,3};
    static int [] prevMinArray=null;
    static int [] nextMinArray=null;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) {
        prevMinArray = new int [arr.length];
        nextMinArray = new int [arr.length];
        findPrevMinArray(arr);
        print(prevMinArray);
        findNextMinArray(arr);
        print(nextMinArray);
        int output = getMaxArea(arr,arr.length);
        System.out.println("Output : "+output);
    }
    private static void print(int[] arr) {
        System.out.print("[ ");
        for (int i =0;i< arr.length;i++) {
            if(i==arr.length-1) System.out.print(arr[i]);
            else System.out.print(arr[i]+" ,");
        }
        System.out.println(" ] \n");
    }
    private static void findNextMinArray(int[] arr) {
        stack.clear();
        for (int i = arr.length-1; i >=0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();
            int index = stack.isEmpty() ?arr.length : stack.peek();
            nextMinArray[i]= index;
            stack.push(i);
        }
    }
    private static void findPrevMinArray(int[] arr) {
        stack.clear();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();
            int index = stack.isEmpty() ? -1 : stack.peek();
            prevMinArray[i]= index;
            stack.push(i);
        }
    }

    private static int getMaxArea(int [] arr , int len) {
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int slab =0;
            if(prevMinArray[i] < 0 && nextMinArray[i] <= arr.length) {
                slab = (nextMinArray[i]) * arr[i];
            }
            else if(prevMinArray[i] >= 0 && nextMinArray[i] <= arr.length){
                slab = (nextMinArray[i] - prevMinArray[i] -1)*arr[i];
            }
            max = Math.max(slab,max);
        }
        return max;
    }
}
