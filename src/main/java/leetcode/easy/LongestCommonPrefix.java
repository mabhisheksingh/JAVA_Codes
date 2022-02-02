package leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String [] strs = {"cir","car"};
       String output = longestCommonPrefix(strs);
        System.out.println("Output : "+output);
    }

    //time complexity(n*M) n= no string in array and m = the smallest string in array
    private static String longestCommonPrefix(String[] strs) {
        String output = "";
        int minimumLength = Integer.MAX_VALUE;
        String minimumString = "";
        for (int i = 0; i < strs.length; i++) {
            if (minimumLength > strs[i].length()) {
                minimumLength = strs[i].length();
                minimumString = strs[i];
            }
        }
        System.out.println("Minimum Len  : "+minimumLength+" Minimum String "+minimumString);

        for (int i = 0; i < minimumLength; i++) {
            char ch = minimumString.charAt(i);
            int flag =0;
            for (int j = 0; j < strs.length; j++) {
                if( (ch != strs[j].charAt(i))){
                    flag=1;
                }
            }
            if(flag ==0){
                output+=ch;
            }else{
                break;
            }
        }
        return output;
    }


}
