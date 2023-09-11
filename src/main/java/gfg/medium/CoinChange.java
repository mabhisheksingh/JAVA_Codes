package gfg.medium;

import utils.arrays.MyArrayUtils;

public class CoinChange {

    public static void main(String[] args) {
//        int[] coins = new int[] { 1, 2, 3 };
        int[] coins = new int[] {89,62,82,87,88,53,29,16,50,95,70,32,17,57,3,61,44,91,24,72,94,34,90,52,7,65,22,15,92,38,60,63,78,64,55,36,46,85,30,11,12,33,96,45,13,4,98,40,93,83,1,42 };
//        int sum = 4;
        int sum = 432;
        long output = new CoinChange().count(coins, coins.length, sum);
        System.out.println("OUTPUT : " + output);
    }

    /**
     * @param coins
     * @param N
     * @param sum
     * @return Dp[N][sum]
     */
    public long count(int[] coins, int N, int sum) {
        Long[][] dpArray = new Long[ N+1 ][sum + 1];

        for (int i = 0; i <= sum; i++) {
            dpArray[0][i] = 0L;
        }
        for (int i = 0; i <= N; i++) {
            dpArray[i][0] = 1L;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                dpArray[i][j] = dpArray[i - 1][j];
                if (coins[i - 1] <= j) {
                    dpArray[i][j] += dpArray[i][j - coins[i - 1]];
                }
            }
        }

//        new MyArrayUtils<Integer>().print2DArray(dpArray, "GFG Utils");

        return dpArray[N][sum];

    }
}
