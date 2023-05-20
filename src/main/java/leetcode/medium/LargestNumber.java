package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String[] args) {
//        int [] nums = {3,30,34,5,9};
        int [] nums = {0,0};

        List<String> list = Arrays.stream(nums).mapToObj(a -> String.valueOf(a) ).collect(Collectors.toList());
                Collections.sort(list , (a,b)->{
            String xy = a+b;
            String yx = b+a;
            return  xy.compareTo( yx ) > 0 ? -1 : 1 ;
        });

        String result = list.stream().reduce("" ,  (a, b) -> a+b );
        System.out.println(list);

        result = removeZero(result);
        if( result.isEmpty()) result = "0";
        System.out.println(result);

    }

    public static String removeZero(String str) {

        // Count leading zeros

        // Initially setting loop counter to 0
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;

        // Converting string into StringBuffer object
        // as strings are immutable
        StringBuffer sb = new StringBuffer(str);

        // The StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(0, i, "");

        // Returning string after removing zeros
        return sb.toString();
    }
}
