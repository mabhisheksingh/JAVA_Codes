package CodingQuestions.stack;
/* find getMin in 0(1) time and 0(n) space*/
import java.util.ArrayDeque;

public class StackWithGetMinV1 {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayDeque<Integer> stackMin = new ArrayDeque<>();
    public static void main(String[] args) {
        /*push(5);
        push(10);
        push(20);
        push(2);
        push(6);
        push(4);
        pop();pop();push(2);
        getMin();
        pop();push(1);getMin();pop();pop();
        getMin();*/
        push(1);
        push(2);
        push(30 );
        getMin();
        System.out.println(stack);
        getMin();

    }
    private static void push(int pushElement) {
        System.out.println("Element pushed successfully in stack : "+pushElement);
        if (stack.isEmpty()) {
            stack.push(pushElement);
            stackMin.push(pushElement);
        }else{
            stack.push(pushElement);
            if(stackMin.peek() > pushElement) stackMin.push(pushElement);
        }
    }
    private static void pop() {
        if (!stack.isEmpty()) {
            int removeElement = stack.pop();
            System.out.println("Element poped successfully in stack : "+removeElement);
            if(stackMin.peek() == removeElement) stackMin.pop();
        }else System.out.println("Stack is empty");
    }
    private static void getMin() {
        if (!stackMin.isEmpty()) System.out.println("Min Element in stack is  : "+ stackMin.peek());
        else System.out.println("Stack is empty");
    }

}
