package Heap;

import java.util.*;

public class FindKPairswithSmallestSums {

    public static void main(String[] args) {
//        int [] nums1 = {1,7,11};
//        int [] nums2 = {2,4,6};
//        int k = 3;
        int [] nums1 = {1,1,2};
        int [] nums2 = {1,2,3};
        int k = 2;

        System.out.println(" " +kSmallestPairs(nums1,nums2,k));
    }
    //un-optimized
    public static List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        PriorityQueue< pair  > pq = new PriorityQueue<>(new pair());
        for(int i=0; i < nums1.length ; i++){
            for(int j=0 ; j< nums2.length  ; j++){
               pq.add( new pair(nums1[i]+nums2[j], Arrays.asList( nums1[i] ,nums2[j] )));
                if(pq.size() > k)
                    pq.remove();
            }
        }
        System.out.println( pq );
        List<List<Integer>> lists = new ArrayList< List<Integer >>();
        for (int i = 0; i < k && !pq.isEmpty() ; i++) {
            lists.add( pq.poll().list );
        }
        return lists;
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue< int[]  > pq = new PriorityQueue<>( (a,b) -> (a[0]+a[1]) - (b[0]+ b[1]) );
        for(int i=0; i < nums1.length ; i++){
            for(int j=0 ; j< nums2.length  ; j++){
               pq.add( new int[]{nums1[i], nums2[j]} );
                if(pq.size() > k)
                    pq.remove();
            }
        }
        System.out.println( pq.toArray() );
        System.out.println("A "+Arrays.asList(pq.toArray()).get(0) );
        List<List<Integer>> lists = new ArrayList< List<Integer >>();
        for (int i = 0; i < k && !pq.isEmpty() ; i++) {
            int [] temp= pq.poll();
            lists.add( Arrays.asList( temp[0],temp[1] ) );
        }
        return lists;
    }
}

class pair implements Comparator<pair> {
    int key;
    List<Integer> list;
    pair(int key , List<Integer> list) {
        this.key = key;
        this.list = list;
    }
    pair() {}

    @Override
    public int compare(pair o1, pair o2) {
        return o1.key  - o2.key;
    }
}
