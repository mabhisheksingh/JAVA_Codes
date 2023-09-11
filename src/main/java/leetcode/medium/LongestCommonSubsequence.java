package leetcode.medium;

/**
 * Dp problem
 * */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
//        int output = new LongestCommonSubsequence().longestCommonSubsequence("abcde","ace");
        int output = new LongestCommonSubsequence().longestCommonSubsequence("babad","dabab");
//        int output = new LongestCommonSubsequence().longestCommonSubsequence("abc","def");
        System.out.println("OUTPUT: "+output);
    }
    int output_1 = 0;


    public int longestCommonSubsequence(String text1, String text2) {


//        int output = longestCommonSubsequenceUsingDP1( text1, text2, text1.length() - 1 , text2.length() - 1  );

//        int memo [][] = new int[text1.length()][text2.length()];
//
//        for (int i = 0; i < text1.length(); i++) {
//            for (int j = 0; j < text2.length(); j++) {
//                memo[i][j] = -1;
//            }
//        }
//        int output = longestCommonSubsequenceUsingDP1( text1, text2, text1.length() - 1 , text2.length() - 1 , memo  );

        int output = longestCommonSubsequenceUsingDP2( text1, text2, text1.length() , text2.length()  );
        return output;
    }


    /**
    * Here we are using to get SUBSEQUENCE in both string with the help of backtracking
    * getting Time Limit Exceeded in leetcode.com
    * */
    private int longestCommonSubsequenceBackTracking( String text1, String text2, int len1, int len2){
        int length = 0;
        if(len1 == -1 || len2 == -1){
            return 0;
        }
        if( text1.charAt( len1 ) == text2.charAt( len2) ){
            length =1 + longestCommonSubsequenceBackTracking( text1, text2, len1 - 1, len2 - 1);
        }else{
            length = Math.max( longestCommonSubsequenceBackTracking( text1, text2, len1 - 1, len2) , longestCommonSubsequenceBackTracking( text1, text2, len1, len2 - 1) );
        }
        return length;
    }



    /**
     * Here we are using to get SUBSEQUENCE in both string with the help of backtracking but using DP
     * leetcode Success.
     * Top to down approach
     */
    private int longestCommonSubsequenceUsingDP1( String text1, String text2, int len1, int len2 , int [][] memo){
        if(len1 == -1 || len2 == -1){
            return 0;
        }
        if( memo[len1][len2] != -1){
            return memo[len1][len2];
        }else{
            if( text1.charAt( len1 ) == text2.charAt( len2) ){
                memo[len1][len2] =1 + longestCommonSubsequenceUsingDP1( text1, text2, len1 - 1, len2 - 1 , memo);
            }else{
                memo[len1][len2] = Math.max( longestCommonSubsequenceUsingDP1( text1, text2, len1 - 1, len2 , memo ) , longestCommonSubsequenceUsingDP1( text1, text2, len1, len2 - 1 , memo ) );
            }
        }
        return memo[len1][len2];
    }

    /**
     * Here we are using to get SUBSEQUENCE in both string with the help of backtracking but using DP
     * leetcode Success.
     * Bottom to UP approach
     */
    private int longestCommonSubsequenceUsingDP2( String text1, String text2, int len1, int len2 ){
        int [][] tablelour = new int[len1+1][len2+1];

        for (int i = 0; i < len1+1 ; i++) {
            for (int j = 0; j < len2+1; j++) {
                if(i == 0 || j == 0 ){
                    tablelour[i][j] = 0;
                }else{
                    if( text1.charAt( i - 1 ) == text2.charAt( j - 1 ) ){
                        tablelour [i  ][j  ] = tablelour[i-1 ][j-1 ] +1;
                    }else{
                        tablelour [i ][j ] = Math.max(tablelour[i-1][j] , tablelour[i][j - 1 ]) ;
                    }

                }
            }

        }
        printMatrix(tablelour);
       return tablelour[len1][len2];
    }
    public void printMatrix(int [][]matrix){
        System.out.println("\n****** printing start********");
        for (int [] row : matrix){
            for( int item : row){
                System.out.print(item+" ");
            }
            System.out.println("");
        }
        System.out.println("\n****** printing End********");
    }

}
