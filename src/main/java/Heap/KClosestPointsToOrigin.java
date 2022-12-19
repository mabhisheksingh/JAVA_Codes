package Heap;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class KClosestPointsToOrigin {


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PairsInGraph> heap = new PriorityQueue<>( new distanceComparator());
        for(int i =0 ;i < points.length ; i++){
            heap.add( new PairsInGraph( points[i][0],points[i][1] ) );
        }
        int [][] output = new int[k][2];
        int i =0;
        while ( !heap.isEmpty()  && i < k ){
            PairsInGraph list = heap.poll();
            // System.out.println(list.key + " i "+list.val +" dis "+list.originDistance);
            output[i][0] = list.key;
            output[i][1] = list.val;
            i++;
        }

        return output;
    }

    public static void main(String[] args) {

        int [][] arr = {{2,10},{-9,-9},{0,8},{-2,-2},{8,9},{-10,-7},{-5,2},{-4,-9}};
        int k =7;

        int min[][] = new KClosestPointsToOrigin().kClosest(arr,k);
    }
}

class PairsInGraph{
    int key;
    int val;
    double originDistance;

    PairsInGraph(){}
    PairsInGraph(int key,int val){
        this.key = key;
        this.val = val;
        this.originDistance = distance( key,val);
    }
    public double distance(int x1 , int y1){
        return Math.sqrt( Math.pow( x1-0 , 2) +  Math.pow( y1 -0 ,2) );
    }
}

class distanceComparator implements Comparator<PairsInGraph> {
    public int compare(PairsInGraph p1,PairsInGraph p2){
        if( p1.originDistance < p2.originDistance ) return -1;
        if( p1.originDistance > p2.originDistance ) return 1; //swap
        return 0;

    }
}