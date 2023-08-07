package leetcode.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * backTracking problem
 * */

public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> output = new LetterCasePermutation().letterCasePermutation("a1b2");
        System.out.println("output "+output);

    }
    public List<String> letterCasePermutation(String s) {

        List<String> output = new ArrayList<>();
        int N = s.length();
        StringBuilder stringbuilder = new StringBuilder();
        letterCasePermutationFindAll(s,output,N, 0,stringbuilder);

        return output;


    }

    private void letterCasePermutationFindAll(String s, List<String> list , int N , int position , StringBuilder stringbuilder){
        if( position == N){
            System.out.println("stringBuilder "+ stringbuilder + " position "+position+" s "+s );
            list.add( stringbuilder.toString() );
            return;
        }
        char ch = s.charAt( position );
        if ( !Character.isDigit( ch ) ){
            letterCasePermutationFindAll(s, list, N, position + 1 , stringbuilder.append( Character.toLowerCase( ch ) ) );
            stringbuilder.deleteCharAt( stringbuilder.length() - 1);
            letterCasePermutationFindAll(s, list, N, position + 1 , stringbuilder.append( Character.toUpperCase( ch ) ) );
            stringbuilder.deleteCharAt( stringbuilder.length() - 1);
        }else{
            letterCasePermutationFindAll(s, list, N, position+1 ,  stringbuilder.append( ch ) );
            stringbuilder.deleteCharAt( stringbuilder.length() - 1);
        }
    }
}
