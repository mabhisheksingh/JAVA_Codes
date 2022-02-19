package leetcode.hard;

import java.util.ArrayDeque;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr=new int[] {25,20,15,10};//{5,15,10,8,6,12,9,18};
        for(int x: nextGreater(arr,arr.length)){
            System.out.print(x + " ");
        }
    }
    private static int [] nextGreater(int []arr, int len){
        int [] output = new int[len];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for (int i = len-1; i >=0 ; i--) {
            while (!s.isEmpty() && arr[i] > s.peek()) s.pop();
            int nextLargest = s.isEmpty() ? -1 : s.peek();
            output[i] = nextLargest;
            //System.out.print(nextLargest+" ");
            s.push(arr[i]);
        }
        return output;
    }
}
