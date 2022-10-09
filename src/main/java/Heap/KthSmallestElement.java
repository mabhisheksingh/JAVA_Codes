package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    static int arr [] = {3,2,1,5,6,4,9,-1};
    static int k = 3;
    public static void main(String[] args) {
        print(arr);
        System.out.println("Kth largest number "+getKthSmallestElement( arr ,k ) );
        print(arr);
    }

    public static int getKthSmallestElement(int  [] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
            if( priorityQueue.size() > k )
                priorityQueue.poll();
        }
        System.out.println(priorityQueue);

        return priorityQueue.peek();
    }



    public static void print(int [] args) {
        System.out.println("_____________________Printing array Start--------------- ");
        for (int i = 0; i < args.length; i++) {
            System.out.print("{ arr[" + i + "] : "+args[i]+"}, ");
        }
        System.out.println("\n_____________________Printing array End--------------- ");
    }
}
