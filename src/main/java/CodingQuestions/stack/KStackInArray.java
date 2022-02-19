package CodingQuestions.stack;

public class KStackInArray {

    public static final int TOTAL_SIZE_OF_ALL_STACK=10;
    public static final int TOTAL_NO_OF_STACK = 3;
    private static int [] arr = new int[TOTAL_SIZE_OF_ALL_STACK];
    private static int [] stacksTop=new int[TOTAL_NO_OF_STACK];
    private static int []next=new int[TOTAL_SIZE_OF_ALL_STACK];
    private static int free =0;

    private static void fillStacksTop(int [] stacksTop){
        for (int i = 0; i < stacksTop.length; i++) stacksTop[i]=-1;
    }
    private static void fillNext(int [] next){
        next[next.length-1] = -1;
        for (int i = 0; i < next.length-1; i++) next[i]=i+1;
    }
    private static void printArray(int  [] arr){
        System.out.println("Start Printing Array");
        for (int i : arr)
            System.out.print(i+" ");
        System.out.println("\nEnd Printing Array");
    }
    private static boolean checkValidStackNumber(int stackNumber){ return (stackNumber>= TOTAL_NO_OF_STACK)?false:true;}

    static {
        fillStacksTop(stacksTop);
        fillNext(next);
        //printArray(next);
    }
    private static boolean isEmpty(int stackNumber){
        return (stacksTop[stackNumber]==-1) ? true:false;
    }
    private static boolean isStackFull(){
        return (free==-1)?true:false;
    }
    private static void pop(int stackNumber){
        if(checkValidStackNumber(stackNumber) && free!=-1 && stacksTop[stackNumber] >-1){
            int i = stacksTop[stackNumber];
            arr[i] =0;
            stacksTop[stackNumber]= next[i];
            next[i]= free;
            free = i;
        }else{
            System.out.println("Not valid stack Number or stack is Empty");
        }
    }
    private static void push(int value,int stackNumber){
        if(checkValidStackNumber(stackNumber)){
            int i= free;
            arr[i]=value;
            free = next[i];
            next[i] = stacksTop[stackNumber];
            stacksTop[stackNumber] = i;
           // System.out.println("free"+free);
        }else{
            System.out.println("Not valid stack Number");
        }

    }
    public static void main(String[] args) {
        push(1,0);
        push(12,0);
        push(3,1);
        push(5,1);
        push(6,1);
        push(13,0);
        push(7,1);
        pop(0);
        pop(0);
        pop(0);
        pop(0);
        push(1,0);
        push(12,0);
        pop(1);
        printArray(arr);
        printArray(stacksTop);
        printArray(next);
        System.out.println("free : "+free);
    }


}
