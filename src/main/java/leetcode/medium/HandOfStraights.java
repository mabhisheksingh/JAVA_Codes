package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* Example 1:
*
* Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
* Output: true
* Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
*
* Example 2:
*
* Input: hand = [1,2,3,4,5], groupSize = 4
* Output: false
* Explanation: Alice's hand can not be rearranged into groups of 4
*/
public class HandOfStraights {
    public static void main(String[] args) {
//        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int[] hand = { 8,10,12 };
        int groupSize = 3;

        System.out.println("Output : " + isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if( hand.length % groupSize != 0 ) return false;

        Map<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand){
            if( !hash.containsKey(i))
                pq.add(i);
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        while (!pq.isEmpty()){
            int min  = pq.poll();
            while ( !pq.isEmpty() && hash.get(min) == 0) min = pq.poll();
            if( hash.get(min) > 1 ) pq.add(min);
            int tempMin = min;
            for (int i = 0; i < groupSize && !pq.isEmpty(); i++) {
                System.out.println("TempMin : "+tempMin);
                if(hash.containsKey(tempMin) && hash.get(tempMin) > 0){
                    hash.put( tempMin , hash.get(tempMin) - 1);
                    tempMin++;
                }else {
                    return false;
                }

            }
        }
        return true;
    }

}
