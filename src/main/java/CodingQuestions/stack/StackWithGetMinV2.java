package CodingQuestions.stack;

import java.util.ArrayDeque;

/* find getMin in 0(1) time and 0(1) space
* Worked only for +ve numbers*/
public class StackWithGetMinV2 {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    private static int Min=Integer.MIN_VALUE;
    public static void main(String[] args) {
        push(5);
        push(10);
        push(20);
        push(2);
        push(6);
        push(4);
        push(2);
        getMin();
        pop();pop();
        getMin();
        pop();push(1);getMin();pop();pop();
        getMin();

    }

    private static void push(int num) {
        System.out.println("Item pushed successfully : "+num);
        if(stack.isEmpty()){
            Min = num;
            stack.push(num);
        }else if(Min >= num){
            stack.push(num-Min);
            Min = num;
        }else stack.push(num);
    }
    private static void pop() {
        int poped = stack.pop();
        if(poped<0){
            int temp = poped;
            poped = Min;
            Min = Min-temp;
        }
        System.out.println("Item poped successfully : "+poped);
    }
    private static void getMin() {
        System.out.println("Get Min is : "+Min);
    }
}
