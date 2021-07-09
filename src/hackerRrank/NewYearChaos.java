package hackerRrank;
/*
STDIN       Function
-----       --------
2           t = 2
5           n = 5
2 1 5 3 4   q = [2, 1, 5, 3, 4]
                [1, 2, 3, 4, 5]
 5           n = 5
2 5 1 3 4   q = [2, 5, 1, 3, 4]
*/
import java.util.*;

public class NewYearChaos {
    public static void main(String[] args) {
        //int q[] = {2, 1, 5, 3, 4};
        //int q[] = {2, 5, 1, 3, 4};
        int q[] ={1, 2, 5, 3, 7, 8, 6 ,4};
        List<Integer> q1 = new ArrayList<>();
        for (int i =0 ;i< q.length ;i++){
            q1.add(q[i]);
        }
       // minimumBribes(q1);
        System.out.println( 95-("A").charAt(0));
    }

    private static int [] swap(int [] arr , int l ,int r){
        int temp  = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return arr;
    }

   /* private static void minimumBribes(List<Integer> q) {
        int arr[]=new int[q.size()];
        int swaping=0 ;
        String chaotic="";
        Map<Integer,Integer> arr_count = new HashMap<Integer,Integer>();
        for (int i =0 ;i< q.size() ;i++){
            arr[i] = i+1;
        }
        for(int i = q.size()-1 ;i>0 ;i--){
            if (arr[i] == q.get(i) ) continue;
            else {
                if ( (arr[i] == q[i-1])  ||  (arr[i-1] == q[i]) ){
                    if(!arr_count.containsKey(i)){
                        arr =  swap(arr , i ,i - 1 );
                        swaping++;
                        arr_count.put(i,1);
                    }else if(arr_count.get(i) >=2 ){
                       // System.out.println("Too chaotic");
                        chaotic ="Too chaotic";
                        break;
                    }else{
                        arr =  swap(arr , i ,i - 1 );
                        arr_count.put(i,arr_count.get(i) +1);
                        swaping++;
                    }
                }else {
                    //System.out.println("Too chaotic2");
                    chaotic ="Too chaotic";
                    break;
                }
            }
        }
        for(int i =0;i< arr.length;i++){
            if( !( arr[i]==q[i])){
                   // System.out.println("Too chaotic3");
                    chaotic ="Too chaotic";
                    break;
            }
        }
        if(chaotic.equals("Too chaotic")){
            System.out.println("Too chaotic");
        }else
            System.out.println("SWAp "+swaping);


    }*/
}
