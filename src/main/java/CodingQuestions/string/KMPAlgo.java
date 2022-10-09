package CodingQuestions.string;

import java.time.Instant;

public class KMPAlgo {
    public static void main(String[] args) {
        String str =     "abcdabcbcdeaabcdabca";
        String pattern = "abcdabca";
        int lps[]= getLPS(pattern);
        System.out.println("String  :  "+pattern+"\n");
        System.out.println("Using Long");
        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i]+" ");
        }
        System.out.println("\nUsing new");
        int lps1[]= fillLPS(pattern);
        for (int i = 0; i < lps1.length; i++) {
            System.out.print(lps1[i]+" ");
        }

        System.out.println("\nString matched or not "+ matchingString(str,pattern,lps));
    }

    private static boolean matchingString(String str, String pattern, int[] lps) {
        int strLen = str.length();
        int patternLen = pattern.length();
        int j=0;
        int i=0;
        while (i < strLen){
            char strChar = str.charAt(i);
            char patternChar = pattern.charAt(j);
            if(strChar == patternChar){
                i++;j++;
            }else if(j == patternLen){
                System.out.println("String printing \n");
                for (int k =i-j; k < j; k++) {
                    System.out.print(str.charAt(k)+" ");
                }
                System.out.println();
                j= lps[j-1];
            }else {
                if(j == 0) i++;
                else{
                    j=lps[j-1];
                }
            }

        }
//        System.out.println(j);
        if(j == patternLen){
            System.out.println("\nString printing \n"+j+" i "+i);
            for (int k =i-j; k < i; k++) {
                System.out.print(str.charAt(k)+" ");
            }
            System.out.println();
        }


        return false;
    }

    public static int [] fillLPS(String str) {

        int [] lps = new int[str.length()];
        int strLen = str.length();
        int len=0;
        lps[0]= 0;
        int i =1;
        while (i<strLen){
            if (str.charAt(len) == str.charAt(i)) {
                len++;
                lps[i]=len;
            } else if (len==0) lps[i]=0;
            else {
                len = lps[len - 1];
                continue;
            }
            i++;
        }
        return lps;
    }
    public static int[] getLPS(String str) {

        int [] lps = new int[str.length()];
        lps[0]=0;
        for (int i = 1; i < str.length(); i++) {
            //case 1 when str[i-1] matched with str[i]
            int len = lps[i-1];
            if(str.charAt(len)  == str.charAt(i)){
                lps[i] = len+1;
            }else if(str.charAt(len)  != str.charAt(i) && len==0){
                lps[i] = 0;
            }else{
                while (len != 0){
                    len=lps[len-1];
                    if(str.charAt(len)  == str.charAt(i)){
                        lps[i] = len+1;
                    }else if(str.charAt(len)  != str.charAt(i) && len==0){
                        lps[i] = 0;
                    }
                }
            }
        }

        return lps;
    }
}
