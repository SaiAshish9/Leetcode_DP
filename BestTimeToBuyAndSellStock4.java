package com.sai;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        // If k is large enough, we can use the greedy solution
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        // dp[i][j] stores the maximum profit with at most i transactions
        // using prices[0:j] (0-based index)
        int[][] dp = new int[k + 1][n];
        
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][n - 1];
    }

    static int maxProfit(int k, int[] prices) {
        if (k >= (prices.length / 2)) {
            int sell = 0;
            int hold = Integer.MIN_VALUE;
            for (int p : prices) {
                sell = Math.max(sell, hold + p);
                hold = Math.max(hold, sell - p);
            }
            return sell;
        }
        int[] sell = new int[k + 1];
        int[] hold = new int[k + 1];
        Arrays.fill(hold, Integer.MAX_VALUE);
        for (int price : prices)
            for (int i = k; i > 0; --i) {
                sell[i] = Math.max(sell[i], hold[i] + price);
                hold[i] = Math.max(hold[i], sell[i - 1] - price);
            }
        System.out.println();
        System.out.println("sell");
        System.out.println(Arrays.toString(sell));
        System.out.println();
        System.out.println("hold");
        System.out.println(Arrays.toString(hold));
        System.out.println();
        return sell[k];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1})); // 2
    }

// Input: k = 2, prices = [2,4,1]
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

}


