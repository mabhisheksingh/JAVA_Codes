package CodingQuestions.string;

import java.util.ArrayList;
import java.util.List;

public class LeastLenSubStringCharContaining {

    public static void main(String[] args) {
        String input1 = "i am i abhishek";
        String input2 = "ash";

        String str = getStr(input1,input2);
        System.out.println("Output "+ str);
    }

    private static String getStr(String input1, String input2){
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();

        for (int i = 0; i < input1.length(); i++) {
            if( input1.charAt(i) ==  input2.charAt(0))
                startList.add(i);
            if(input1.charAt(i) == input2.charAt( input2.length() -1 )){
                endList.add(i);
            }
        }
        String minStr = "";
        int minStrLen =Integer.MAX_VALUE;

        for (int i : startList) {
            int str2 = 0;
            for (int j = i ; j < input1.length(); j++) {
                if(input1.charAt(j) == input2.charAt(str2) ) str2++;

                if( str2 == input2.length() ){
                    String str=  input1.substring(i,j+1);
                    if( minStrLen > str.length() ){
                        minStrLen = str.length();
                        minStr = str;
                    }
                    break;
                }
            }
        }


        return minStr;
    }
}
