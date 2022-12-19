package leetcode.medium;

public class FindTheIndexofTheFirstOccurrenceInString {

    public static void main(String[] args) {
        String haystack= "a", needle = "a";
        System.out.println("output : "+strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        if( needle.length() > haystack.length() ) return -1;
        int i=0,j=0;
        while ( i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) ==  needle.charAt(j)) {
                i++;j++; continue;
            }else{
                i = i-j;
                j=0;
                i++;
            }
        }
        System.out.println("i "+i+" j "+j);
        if( j == needle.length() ) return  i-j;
        return -1;
    }
}
