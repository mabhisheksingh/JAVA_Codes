package CodingQuestions.stack;

import java.util.ArrayDeque;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr=new int[]{18,12,13,14,11,16};//->1,1,2,3,1,2
        printSpan(arr,arr.length);
    }
    private static void printSpan(int [] arr,int len){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        System.out.print("1 ");
        for (int i = 1; i < len; i++) {
            int span =0;
            while (!stack.isEmpty()  && arr[stack.peek()] < arr[i] ){
                stack.pop();
            }
            span = stack.isEmpty() ? i+1 : i-stack.peek();
            System.out.print(span+" ");
            stack.push(i);
        }
    }
}
