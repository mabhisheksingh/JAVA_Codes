package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";

        System.out.println("result : "+frequencySort(s)  );
    }

    public static String frequencySort(String s) {
            Map<Character,Integer> hash = new HashMap<>();
            for( int i=0; i < s.length() ; i++ ){
                if( hash.containsKey(s.charAt(i))){
                    hash.put(s.charAt(i),1 + hash.get(s.charAt(i))  );
                }else{
                    hash.put(s.charAt(i),1);
                }
            }

            PriorityQueue<Pair1> heap = new PriorityQueue<>(new PairSort());
            for (Map.Entry<Character, Integer> set : hash.entrySet()) {
                heap.add( new Pair1(set.getKey() ,set.getValue() ));
            }

            String str = "";
            while( !heap.isEmpty() ){
                Pair1 p = heap.poll();
                for(int i =0;i< p.val;i++){
                    str = p.key+str;
                }
            }
            return str;

    }
}

class Pair1{
        char key;
        int val;
        Pair1(char key,int val){
            this.key = key;
            this.val = val;
        }
}

    class PairSort implements Comparator<Pair1>{
        public int compare(Pair1 p1 ,Pair1 p2){
            if( p1.val > p2.val ) return 1;
            if( p1.val < p2.val ) return -1;
            if( p1.key > p2.key ) return -1;
            else return 1;

        }
    }