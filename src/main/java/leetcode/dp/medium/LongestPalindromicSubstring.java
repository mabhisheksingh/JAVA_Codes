package leetcode.dp.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String s = "babad";
        String s = "abba";
//        String s = "aacabdkacaa";
        System.out.println("OUTPUT :"+ new LongestPalindromicSubstring().longestPalindrome(s));
    }
    public String longestPalindrome(String str1) {

        return middleTravelPalindrome(str1); //algo 1
    }

    public String middleTravelPalindrome(String str1){
        System.out.println("REQ "+ str1);
        int left=0, right=0;
        for (int k = 0; k < str1.length(); k++) {
            int start = 0, end = 0;
            System.out.println("\n************start***********");
            System.out.println("K " + k);
            int len1 = expandFromCenter(str1, k, k); // for odd String
            int len2 = expandFromCenter(str1, k, k + 1);// for even String

            System.out.println("Len1 " + len1 + " len2 " + len2);
            int max = Math.max(len1, len2);
            if( right -left < max){
                left = k - (max - 1) / 2;
                right = k + max / 2;
            }
            System.out.println("Max "+ max+ "start "+ start +"  end "+end);
            String temp =str1.substring( start , end );
        }

        return str1.substring(left,right+1);
    }

    private int expandFromCenter(String str1, int i, int j) {
        while( i >= 0 && j < str1.length() && str1.charAt(i) == str1.charAt(j)){
            i-=1;
            j+=1;
        }
        return j-i-1;
    }


}
