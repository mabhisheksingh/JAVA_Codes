package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(new ValComparator() );
        for(int i=0;i< arr.length ;i++){
            int temp = Math.abs( arr[i]-x);
            heap.add( new Pair(temp,arr[i] ) );
        }
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for(int i=0;i< k;i++){
            int vl = heap.poll().arrVal;
            System.out.println(vl);
            list.add(vl);
        }
        List<Integer> output = new ArrayList<>(k);
        while( !list.isEmpty()){
            output.add( list.poll());
        }
        return output;
    }
}

class Pair {
    int val;
    int arrVal;
    Pair( int a,int b){
        this.val = a;
        this.arrVal = b;
    }
}

class ValComparator implements Comparator<Pair> {
    public int compare(Pair p1,Pair p2){
        if( p1.val < p2.val ) return -1;
        if( p1.val > p2.val ) return 1; //swap
        if( p1.arrVal < p2.arrVal ) return -1;
        if( p1.arrVal > p2.arrVal ) return 1;
        return 0;

    }
}


