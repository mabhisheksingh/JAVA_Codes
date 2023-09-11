package gfg.medium;

import utils.arrays.MyArrayUtils;

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "gesek";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.editDistance(str1, str2));
    }

    public int editDistance(String s, String t) {
        // Code here
//        return editDistanceRec(s, t, s.length(), t.length());
        return editDistanceDP(s, t);

    }

    public int editDistanceRec(String s, String t, int sLen, int tLen) {
        //base condition
        if (sLen == 0) {
            return tLen;
        } else if (tLen == 0) {
            return sLen;
        }
        if (s.charAt(sLen - 1) == t.charAt(tLen - 1)) {
            return editDistanceRec(s, t, sLen - 1, tLen - 1);
        } else {
            return 1 + Math.min(
                    editDistanceRec(s, t, sLen, tLen - 1), /* insert 1 element */
                    Math.min(
                            editDistanceRec(s, t, sLen - 1, tLen),/* delete 1 element */
                            editDistanceRec(s, t, sLen - 1, tLen - 1)/* replace 1 element */
                    )
            );
        }
    }

    public int editDistanceDP(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if( i == 0 && j==0 ) {
                    dp[i][j] =0;
                    continue;
                }
                else if( i==0){
                    dp[i][j]= j;
                    continue;
                } else if (j == 0) {
                    dp[i][j] =  i;
                    continue;
                }

                if(s.charAt(i-1) == t.charAt( j-1) ){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        new MyArrayUtils().print2DArray(dp, "DP array");
        return dp[s.length()][t.length()];
    }
}
