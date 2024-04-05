package org.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {

// dp[i] represents the maximum money can make until index i
// 0 -> buy
// 1 -> sell

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
//[[-7, 0],
// [-1, 0],
// [-1, 4],
// [1, 4],
// [1, 7],
// [3, 7]]
// dp[i][0] represents the maximum profit at the end of day i when holding a stock,
// and dp[i][1] represents the maximum profit at the end of day i when not holding a stock
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock.
//  You can only hold at most one share of the stock at any time. 
// However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.


 public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] dp = new int[n];

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            dp[i] = Math.max(dp[i - 1] + diff, dp[i - 1]);
        }

        return dp[n - 1];
    }
    // dp array stores the maximum profit at each day. 

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 0
    }

}
