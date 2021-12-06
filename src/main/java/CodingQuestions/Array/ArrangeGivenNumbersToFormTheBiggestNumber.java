package CodingQuestions.Array;

import java.util.*;

public class ArrangeGivenNumbersToFormTheBiggestNumber {
    static int i=0;
    public static void main(String[] args) {
       List<String> arr = Arrays.asList("1", "34", "3", "98", "9", "76", "45", "4");
       largestNumber(arr);

    }

    private static void largestNumber(List<String> arr) {
        Collections.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String x, String y) {
                String xy = x+y;
                String yx = y+x;
                //+1 swap -1 don't swap
                System.out.println(++i+" xy : "+xy +" yx : "+yx+" list : "+arr);
                System.out.println("xy.compareTo(yx) : "+xy.compareTo(yx));
                return xy.compareTo(yx)>0 ? -1:1;
            }
        });
        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }
}
