package ShivamProblems;

import java.util.Arrays;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(" Original String  "+str);

        findAllPermutations(str,0,str.length() - 1);
    }

    private static String swap(String str,int l,int r){
        char strarr[] = str.toCharArray();
        char temp = strarr[l];
        strarr[l] =  strarr[r];
        strarr[r] = temp;
        return String.valueOf(strarr);
    }

    private static void findAllPermutations(String str, int l, int r) {
        if(l == r){
            System.out.println(str);
            return;
        }
        for(int i = l ; i<= r ; i++){
            str = swap(str, i,l);
            findAllPermutations(str,l+1,r);
            str = swap(str, l,i);
        }
    }
}
