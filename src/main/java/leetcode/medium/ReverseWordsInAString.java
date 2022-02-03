package leetcode.medium;

public class ReverseWordsInAString {
/*
Input: s = "the sky is blue"
Output: "blue is sky the"
*/
    public static void main(String[] args) {
        String s = "    the   sky is blue  ";
        System.out.println("reverse a word:"+reverseWords(s)+":");
    }
    private static String reverseWords(String s) {
        String output = "";
        String str[] = s.split(" ");
        for (int i = str.length-1; i >=0; i--) {
            output=output.trim()+" "+str[i].trim();
        }
        return output.trim();
    }
}
