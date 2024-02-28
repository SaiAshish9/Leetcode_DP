package com.sai;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {

// dp[i] represents the maximum money can make until index i
// 0 -> buy
// 1 -> sell

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        System.out.println();
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        System.out.println();
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

}


