package hackerRrank;

import java.util.*;

public class TripleSum {
    static List<Integer> seta =  new ArrayList<Integer>();
    static List<Integer> setb =  new ArrayList<Integer>();
    static List<Integer> setc =  new ArrayList<Integer>();
    //Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {


        for (int i =0 ; i< a.length ; i++){
            if(!seta.contains(a[i]))
                seta.add(a[i]);
        }
        for (int i =0 ; i< b.length ; i++){
            if(!setb.contains(b[i]))
                setb.add(b[i]);
        }
        for (int i =0 ; i< c.length ; i++){
            if(!setc.contains(c[i]))
                setc.add(c[i]);
        }
        Collections.sort(seta);
        Collections.sort(setb);
        Collections.sort(setc);

        System.out.println( seta +" "+setb+" "+setc);
       // return 9;

        for(Integer integer : setb){
            int temp = integer;
            int[] arr = seta.stream().mapToInt(i-> Integer.parseInt( i.toString()  )  ).toArray();
            int aindex = binarySearch(arr ,0,seta.size()-1,temp);

            System.out.println(aindex);
        }
        return 9;
    }



    static int binarySearch(int arr[], int l, int r, int x)
    {
        //int[] arr = arr1.stream().mapToInt(i-> Integer.parseInt( i.toString()  )  ).toArray();
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
    public static void main(String args[]){
        int a[] = {1,3,5,7};
        int b[] = {5,7,9};
        int c[]= {7,9,11,13};

        System.out.println("Output : "+triplets(a,b,c));
    }
}
