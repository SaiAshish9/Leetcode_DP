package com.sai;

public class BestTimeToBuyAndSellStock3 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[3][n];

        for (int i = 1; i <= 2; i++) {
            int maxDiff = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[2][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

}


