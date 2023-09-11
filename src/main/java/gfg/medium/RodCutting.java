package gfg.medium;

import utils.arrays.MyArrayUtils;

public class RodCutting {

    public static void main(String[] args) {
//        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        RodCutting rodCutting = new RodCutting();
        System.out.println(rodCutting.cutRod(prices, n));
    }

    public int cutRod(int price[], int n) {
        //code here
        int weight[] = new int[n];
        for (int i = 1; i <= n; i++) {
            weight[i - 1] = i;
        }
        int output1 = cutRodRec(weight, price, n, price.length);
        System.out.println("OUTPUT1 " + output1);
        return cutRodDP(price, n);
    }

    public int cutRodRec(int []weightArr, int[] value, int weight, int valLength) {
        if (weight == 0 || valLength == 0) return 0;
        if (weightArr[valLength - 1] <= weight) {
            return Math.max(value[valLength - 1] + cutRodRec(weightArr, value, weight - weightArr[valLength - 1], valLength), cutRodRec(weightArr, value, weight, valLength - 1));
        } else {
            return cutRodRec(weightArr, value, weight, valLength - 1);
        }
    }

    public int cutRodDP(int[] value, int rodLength) {
        int[][] dp = new int[value.length + 1][rodLength + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        new MyArrayUtils().print2DArray(dp, "DP array");
        return dp[value.length][rodLength];
    }
}
