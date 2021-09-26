package CodingQuestions.Array;
/*
 * Create a data structure twoStacks that represents two stacks.
 * Implementation of twoStacks should use only one array, i.e., both stacks should use the
 * same array for storing elements. Following functions must be supported by twoStacks.
 * push1(int x) –> pushes x to first stack
 * push2(int x) –> pushes x to second stack
 * pop1() –> pops an element from first stack and return the popped element
 * pop2() –> pops an element from second stack and return the popped element
 * Implementation of twoStack should be space efficient.
 */
public class ImplementTwoStacksInAnArray {
    private static int [] stacks = new int[5];
    private static final int STACK_ONE_LEFT =-1;
    private static int stack1_right =-1;
    private static final int STACK_TWO_LEFT =stacks.length;
    private static int stack2_right =stacks.length;
    public static void main(String[] args) {
        for (int i = 0; i < stacks.length; i++) {
            System.out.print(stacks[i]+" ");
        }
        System.out.println();
        push1(1);
        push1(2);
        push2(3);
        push2(5);
        push2(7);
        push1(6);
        for (int i = 0; i < stacks.length; i++) {
            System.out.print(stacks[i]+" ");
        }
        System.out.println();
        pop1();
        pop2();
        for (int i = 0; i < stacks.length; i++) {
            System.out.print(stacks[i]+" ");
        }
        System.out.println();
        push2(9);
        for (int i = 0; i < stacks.length; i++) {
            System.out.print(stacks[i]+" ");
        }
        System.out.println("\n-----Next--------Final");
        pop2();
        pop1();
        pop1();
        pop2();
        pop2();
        pop2();
        for (int i = 0; i < stacks.length; i++) {
            System.out.print(stacks[i]+" ");
        }
        System.out.println();
    }

    private static void push1(int input){
        //System.out.println("Push 1 stack1_right "+stack1_right+"stack2_right "+stack2_right+" push "+input);
        if(stack1_right+1 < stack2_right){
            stacks[++stack1_right] = input;
            System.out.println("PUSH1 "+stacks[stack1_right]);
        }else{
            System.out.println("Stack1 is full and there is no empty space available "+input);
        }
    }
    private static void push2(int input){
       // System.out.println("Push 2 stack2_right "+stack2_right +" and stak 1 right " +stack1_right+" push "+input);
        if(stack2_right-1 > stack1_right ){

            stacks[--stack2_right] = input;
            System.out.println("PUSH2 "+stacks[stack2_right]);
        }else{
            System.out.println("Stack2 is full and there is no empty space available "+input);
        }
    }
    private static void pop1(){
       // System.out.println("Pop 1 stack1_right "+stack1_right+" pop "+stacks[stack1_right]);
        if(stack1_right >= 0){
            System.out.println("POP1 "+stacks[stack1_right]);
            stacks[stack1_right] = 0;
            stack1_right--;
        }else{
            System.out.println("No element is present in Stack1 ");
        }
    }
    private static void pop2(){
       // System.out.println("pop 2 stack2_right "+stack2_right+" pop "+stacks[stack2_right]);
        if(stack2_right < STACK_TWO_LEFT){
            System.out.println("POP2 "+stacks[stack2_right]);
            stacks[stack2_right] = 0;
            stack2_right++;
        }else{
            System.out.println("No element is present in Stack2 ");
        }
    }

}
