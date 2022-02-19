package CodingQuestions.stack;

import java.util.ArrayDeque;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr=new int[]{20,30,10,5,15};

        printPrevGreater(arr,arr.length);
    }
    private static void printPrevGreater(int [] arr ,int len){
        ArrayDeque<Integer>  s = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!s.isEmpty() && s.peek() < arr[i]) s.pop();
            int lastMax = s.isEmpty() ? -1 : s.peek();
            System.out.print(  lastMax +" ");
            s.push(arr[i]);
        }
    }
}
