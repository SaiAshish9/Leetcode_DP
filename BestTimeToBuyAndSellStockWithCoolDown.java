package com.sai;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCoolDown {

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as many transactions as you like 
// (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int ind = n - 1; ind >= 0; ind--) {
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
            dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
        }
        System.out.println();
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        System.out.println();
        return dp[0][1];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        int[] buy = new int[n]; // Maximum profit on each day when a stock is bought
        int[] sell = new int[n]; // Maximum profit on each day when a stock is sold
        int[] cooldown = new int[n]; // Maximum profit on each day when a cooldown is in effect

        // Base case initialization
        buy[0] = -prices[0];

        // Dynamic programming to calculate the maximum profit on each day
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        // The maximum profit will be the maximum of the last day's sell and cooldown
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }
    // Buy array: [-1, -1, -1, 1, 1]
// Sell array: [0, 1, 2, 2, 3]
// Cooldown array: [0, 0, 2, 2, 3]
// 3

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
        // buy for 1 , sell for 2 , cooldown for 3, buy at 0 and se at 2 = 1 + 2 =3
    }

}


